package org.example.labthree.serviceLayer.user;

import org.example.labthree.dataAccessLayer.entities.user.UserBase;
import java.util.UUID;

public interface UserService {
    boolean isCurrentUserEquals(String username);
    void addUser(UserBase user);
    void updateUser(UserBase user);
    void deleteUser(UserBase user);
    UserBase getUserById(UUID userId);
    UserBase getUserByUsername(String username);
}

