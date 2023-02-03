package com.example.pp3.dao;

import com.example.pp3.model.Role;
import com.example.pp3.model.User;
import com.example.pp3.repository.RoleRepository;
import com.example.pp3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        return userRepository.findByEmail(email).orElseThrow(() ->
//                new UsernameNotFoundException(String.format("Username %s not found", email))
//        );
//    }

    @Override
    public Iterable<Role> findAllRoles() {
        return roleRepository.findAll();
    }


    @Override
    public List<User> findAllUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public User findUser(Long userId) throws IllegalArgumentException {
        return entityManager.find(User.class, userId);
    }

    @Override
    public void deleteUser(Long userId) {
        Query q = entityManager.createQuery("delete from User User where id = :id");
        q.setParameter("id", userId);
        q.executeUpdate();
    }

    @Override
    public void insertUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
