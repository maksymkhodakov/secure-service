package com.example.security.DTO;

import com.example.security.domain.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String password;
    private Collection<Role> roles = new ArrayList<>();
}
