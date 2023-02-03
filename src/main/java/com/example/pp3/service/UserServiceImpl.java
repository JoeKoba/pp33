package com.example.pp3.service;

import com.example.pp3.dao.UserDAO;
import com.example.pp3.model.Role;
import com.example.pp3.model.User;
import com.example.pp3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserDAO userDAO,
                           UserRepository userRepository) {
        this.userDAO = userDAO;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userDAO.findAllUsers();
    }

    @Override
    public User findUser(Long userId) throws IllegalArgumentException {
        return userDAO.findUser(userId);
    }

    @Override
    public void deleteUser(Long userId) {
        userDAO.deleteUser(userId);
    }

    @Override
    public Iterable<Role> findAllRoles() {
        return userDAO.findAllRoles();
    }

    @Override
    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (null == user) {
            throw new UsernameNotFoundException(String.format("User email %s not found", email));
        }
        return user;
    }
}
