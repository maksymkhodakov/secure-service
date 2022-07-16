package com.example.security.service;

import com.example.security.DTO.RoleDto;
import com.example.security.DTO.UserDto;
import com.example.security.domain.Role;
import com.example.security.domain.User;
import com.example.security.repo.RoleRepo;
import com.example.security.repo.UserRepo;
import com.example.security.utils.ModelMapping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepo.findByUsername(username);
        checkUserForNull(username, user);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorities);
    }

    private void checkUserForNull(String username, User user) {
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
        }
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        var user = convertUserDtoToEntity(userDto);
        log.info("Saving new user {} to db", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var savedUser = userRepo.save(user);
        return convertUserEntityToDto(savedUser);
    }

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        var role = convertRoleDtoToEntity(roleDto);
        log.info("Saving new {} to db", role.getName());
        var savedRole = roleRepo.save(role);
        return convertRoleEntityToDto(savedRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        var user = userRepo.findByUsername(username);
        var role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        log.info("Getting user by username: {}", username);
        var user = userRepo.findByUsername(username);
        return convertUserEntityToDto(user);
    }

    @Override
    public List<UserDto> getUsers() {
        log.info("Getting all users from db");
        return userRepo.findAll()
                .stream()
                .map(this::convertUserEntityToDto)
                .toList();
    }

    @Override
    public UserDto convertUserEntityToDto(User user) {
        ModelMapping.configureDefaultModelMapper(modelMapper);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User convertUserDtoToEntity(UserDto userDto) {
        ModelMapping.configureDefaultModelMapper(modelMapper);
        return modelMapper.map(userDto, User.class);
    }

    @Override
    public RoleDto convertRoleEntityToDto(Role role) {
        ModelMapping.configureDefaultModelMapper(modelMapper);
        return modelMapper.map(role, RoleDto.class);
    }

    @Override
    public Role convertRoleDtoToEntity(RoleDto roleDto) {
        ModelMapping.configureDefaultModelMapper(modelMapper);
        return modelMapper.map(roleDto, Role.class);
    }
}
