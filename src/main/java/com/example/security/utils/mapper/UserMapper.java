package com.example.security.utils.mapper;

import com.example.security.DTO.UserDto;
import com.example.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDto>{
    @Autowired
    public UserMapper() {
        super(User.class, UserDto.class);
    }
}
