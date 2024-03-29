package com.example.security.service;


import com.example.security.DTO.RoleDto;
import com.example.security.DTO.UserDto;
import java.time.LocalDateTime;
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

    List<UserDto> findByName(String name);

    List<UserDto> findUserByPassword(String password);

    UserDto findByCreatedBetween(LocalDateTime start, LocalDateTime end);
}
