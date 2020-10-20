package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.exception.UserAlreadyExistsException;
import com.thoughtworks.capacity.gtb.mvc.exception.WrongUsernameOrPasswordException;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public UserService() {
    }


    public void createUser(User user) throws UserAlreadyExistsException {
        Optional<User> userOptional = userRepository.findUserByName(user.getUsername());
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("用户已存在");
        }
        userRepository.insert(user);
    }

    public User login(String username, String password) throws WrongUsernameOrPasswordException {
        Optional<User> userOptional = userRepository.findUserByName(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (Objects.equals(user.getPassword(), password)) {
                return user;
            }
        }
        throw new WrongUsernameOrPasswordException("用户名或密码错误");
    }
}
