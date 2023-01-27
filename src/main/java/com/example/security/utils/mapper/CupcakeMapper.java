package com.example.security.utils.mapper;

import com.example.security.DTO.CupcakeDto;
import com.example.security.domain.Cupcake;
import com.example.security.repo.DroidRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class CupcakeMapper extends AbstractMapper<Cupcake, CupcakeDto> {
    private final ModelMapper modelMapper;
    private final DroidRepo droidRepository;

    @Autowired
    public CupcakeMapper(ModelMapper modelMapper, DroidRepo droidRepository) {
        super(Cupcake.class, CupcakeDto.class);
        this.modelMapper = modelMapper;
        this.droidRepository = droidRepository;
    }

    @PostConstruct
    public void setupMapper() {
        modelMapper.createTypeMap(Cupcake.class, CupcakeDto.class)
                .addMappings(m -> m.skip(CupcakeDto::setDroidId)).setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(CupcakeDto.class, Cupcake.class)
                .addMappings(m -> m.skip(Cupcake::setDroid)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(Cupcake source, CupcakeDto destination) {
        destination.setDroidId(getId(source));
    }

    private Long getId(Cupcake source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getDroid().getId();
    }

    @Override
    void mapSpecificFields(CupcakeDto source, Cupcake destination) {
        destination.setDroid(droidRepository.findById(source.getDroidId()).orElse(null));
    }
}
