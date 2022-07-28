package com.example.security.DTO;

import com.example.security.domain.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends AbstractDto {
    private String name;
    private String username;
    private String password;
    private Collection<Role> roles = new ArrayList<>();
}
