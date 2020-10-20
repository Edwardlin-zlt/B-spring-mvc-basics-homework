package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class UserRepository {
    private Map<Integer, User> userMap = new HashMap<>();

    public Optional<User> findUserByName(String name) {
        return userMap.values().stream()
                .filter(user -> Objects.equals(user.getUsername(), name))
                .findFirst();
    }

    public void insert(User user) {
        userMap.put(user.getId(), user);
    }
}
