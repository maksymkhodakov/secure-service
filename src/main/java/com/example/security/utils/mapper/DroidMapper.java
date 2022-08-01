package com.example.security.utils.mapper;

import com.example.security.domain.Droid;
import com.example.security.repo.UnicornRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class DroidMapper extends AbstractMapper<Droid, com.example.security.DTO.DroidDto> {

    private final ModelMapper mapper;
    private final UnicornRepo unicornRepository;

    @Autowired
    public DroidMapper(ModelMapper mapper, UnicornRepo unicornRepository) {
        super(Droid.class, com.example.security.DTO.DroidDto.class);
        this.mapper = mapper;
        this.unicornRepository = unicornRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Droid.class, com.example.security.DTO.DroidDto.class)
                .addMappings(m -> m.skip(com.example.security.DTO.DroidDto::setUnicornId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(com.example.security.DTO.DroidDto.class, Droid.class)
                .addMappings(m -> m.skip(Droid::setUnicorn)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Droid source, com.example.security.DTO.DroidDto destination) {
        destination.setUnicornId(getId(source));
    }

    private Long getId(Droid source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getUnicorn().getId();
    }

    @Override
    void mapSpecificFields(com.example.security.DTO.DroidDto source, Droid destination) {
        destination.setUnicorn(unicornRepository.findById(source.getUnicornId()).orElse(null));
    }
}
