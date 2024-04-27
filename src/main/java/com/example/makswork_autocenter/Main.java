package com.example.makswork_autocenter;

import com.example.makswork_autocenter.configuration.ConfigurationClass;
import com.example.makswork_autocenter.controller.Controller;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var context = new AnnotationConfigApplicationContext(ConfigurationClass.class);
        Controller controller = context.getBean("controller", Controller.class);
        controller.createEntranceWindow();
    }
}
