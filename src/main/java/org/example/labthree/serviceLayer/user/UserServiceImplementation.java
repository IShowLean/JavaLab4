package org.example.labthree.serviceLayer.user;

import org.example.labthree.dataAccessLayer.dao.UserDao;
import org.example.labthree.dataAccessLayer.entities.user.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserServiceImplementation implements UserService {

    private final UserDao userRepository;
    @Autowired
    public UserServiceImplementation(UserDao userRepo) {
        this.userRepository = userRepo;
    }

    @Override
    public boolean isCurrentUserEquals(String username) {
        String actualUser = SecurityContextHolder.getContext().getAuthentication().getName();
        return actualUser.equals(username);
    }

    @Override
    public void addUser(UserBase user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserBase user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(UserBase user) {
        userRepository.delete(user);
    }

    @Override
    public UserBase getUserById(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("UseEntity with current id does not exists"));
    }


    @Override
    public UserBase getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("UseEntity with current username does not exists"));
    }
}
