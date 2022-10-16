package com.example.security.repo;


import com.example.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles")
    List<User> findAllUsers();

    @Query("select u from User u where u.username = ?1")
    User findByUsername(String username);

    @Query("select u from User u where u.name = ?1")
    Optional<List<User>> findByName(String name);

    @Query("select u from User u where u.password = ?1")
    Optional<List<User>> findUserByPassword(String password);

    @Query("select u from User u where u.created between ?1 and ?2")
    Optional<User> findByCreatedBetween(LocalDateTime start, LocalDateTime end);
}
