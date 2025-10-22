package com.cpfire.crud_basic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User createUser(User user) {
        user.setId(users.size()+1);
        users.add(user);
        return user;
    }

    public User updateUser(int id, User newUser) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(newUser.getName());
                user.setAge(newUser.getAge());
                return user;
            }
        }
        return null;
    }

    public boolean deleteUser(int id) {
        return users.removeIf(user -> user.getId() == id);
    }
}
