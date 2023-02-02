package com.example.pp3.service;

import com.example.pp3.model.Role;
import com.example.pp3.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface UserService extends UserDetailsService {





    List<User> findAllUsers();

    User findUser(Long userId) throws IllegalArgumentException;

    void deleteUser(Long userId);

    Iterable<Role> findAllRoles();

    void insertUser(User user);

    void updateUser(User user);
}
