package com.example.makswork_autocenter.service;

import com.example.makswork_autocenter.entity.User;
import com.example.makswork_autocenter.repository.UserRepository;
import com.example.makswork_autocenter.window_register.WindowRegister;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "userService")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    final UserRepository repository;
    User user = new User();

    public UserServiceImpl(@Qualifier(value = "userRepository") UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser() {
        WindowRegister windowRegister = new WindowRegister(user, repository);
        windowRegister.createWindow(repository);
    }

    @Override
    public UserRepository getUserRepository() {
        return repository;
    }
}
