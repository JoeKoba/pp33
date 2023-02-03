package com.example.pp3.dao;

import com.example.pp3.model.Role;
import com.example.pp3.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<User> findAllUsers();

    User findUser(Long userId) throws IllegalArgumentException;

    void deleteUser(Long userId);

    Iterable<Role> findAllRoles();

    void insertUser(User user);

    void updateUser(User user);


//    Optional<Object> findByEmail(String email);
}
