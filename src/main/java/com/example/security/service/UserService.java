package com.example.security.service;


import com.example.security.DTO.RoleDto;
import com.example.security.DTO.UserDto;
import com.example.security.domain.Role;
import com.example.security.domain.User;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto user);
    RoleDto saveRole(RoleDto role);
    void addRoleToUser(String username, String roleName);
    UserDto getUserByUsername(String username);
    /**
     * method @getUsers is not for production usage
     */
    List<UserDto> getUsers();

    UserDto convertUserEntityToDto(User user);
    User convertUserDtoToEntity(UserDto userDto);
    RoleDto convertRoleEntityToDto(Role role);
    Role convertRoleDtoToEntity(RoleDto roleDto);
}
