package com.example.security.api;

import com.example.security.DTO.RoleDto;
import com.example.security.DTO.UserDto;
import com.example.security.domain.RoleToUserForm;
import com.example.security.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<UserDto> getUserByName(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.getUserByUsername(username));
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        var uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(userDto));
    }

    @PostMapping("/role/save")
    public ResponseEntity<RoleDto> saveRole(@RequestBody RoleDto roleDto) {
        var uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(roleDto));
    }

    @PostMapping("/role/addToUser")
    public ResponseEntity<Void> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
