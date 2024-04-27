package com.example.makswork_autocenter.controller;

import com.example.makswork_autocenter.entity.User;
import com.example.makswork_autocenter.service.UserService;
import com.example.makswork_autocenter.window_entrance.WindowEntrance;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Controller(value = "controller")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Controller {
    final UserService service;
    User user = new User();

    public Controller(@Qualifier(value = "userService") UserService service) {
        this.service = service;
    }

    public void createEntranceWindow() {
        WindowEntrance windowEntrance = new WindowEntrance(service.getUserRepository(), user);
        windowEntrance.createWindow();
    }
}
