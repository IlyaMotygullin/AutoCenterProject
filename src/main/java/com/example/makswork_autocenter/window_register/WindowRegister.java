package com.example.makswork_autocenter.window_register;

import com.example.makswork_autocenter.entity.User;
import com.example.makswork_autocenter.repository.UserRepository;
import com.example.makswork_autocenter.window_entrance.WindowEntrance;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class WindowRegister {
    final JFrame mainWindow = new JFrame();
    String nameUser;
    String lastnameUser;
    String surnameUser;
    String passwordUser;
    final User user;
    final UserRepository repository;

    public WindowRegister(User user, UserRepository repository) {
        this.user = user;
        this.repository = repository;
    }

    private JLabel labelInfo(String info, int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", info));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
        label.setSize(250, 50);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }

    private JLabel labelRegister(int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", "Регистрация"));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        label.setSize(250, 80);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }
    private JButton createButtonRegister(int x, int y) {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Регистрация"));
        button.setSize(150, 40);
        button.setBounds(x, y, button.getWidth(), button.getHeight());
        return button;
    }
    public void createWindow(UserRepository repository) {
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(765, 770);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);

        JTextField fieldName = new JTextField();
        fieldName.setSize(550, 30);
        fieldName.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        fieldName.setBounds(100, 200, fieldName.getWidth(), fieldName.getHeight());
        fieldName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameUser = fieldName.getText();
            }
        });

        JTextField fieldLastName = new JTextField();
        fieldLastName.setSize(550, 30);
        fieldLastName.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        fieldLastName.setBounds(100, 300, fieldLastName.getWidth(), fieldLastName.getHeight());
        fieldLastName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastnameUser = fieldLastName.getText();
            }
        });

        JTextField fieldSurname = new JTextField();
        fieldSurname.setSize(550, 30);
        fieldSurname.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        fieldSurname.setBounds(100, 400, fieldSurname.getWidth(), fieldName.getHeight());
        fieldSurname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                surnameUser = fieldSurname.getText();
            }
        });

        JTextField fieldPassword = new JTextField();
        fieldPassword.setSize(550, 30);
        fieldPassword.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        fieldPassword.setBounds(100, 500, fieldPassword.getWidth(), fieldName.getHeight());
        fieldPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordUser = fieldPassword.getText();
            }
        });

        JButton buttonRegister = createButtonRegister(500, 600);
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(buttonRegister.getText())) {
                    mainWindow.dispose();
                    repository.createUser(new User(nameUser, lastnameUser, surnameUser, passwordUser));
                    WindowEntrance windowEntrance = new WindowEntrance(repository, user);
                    windowEntrance.createWindow();
                }
            }
        });
        mainWindow.add(buttonRegister);

        mainWindow.add(fieldPassword);
        mainWindow.add(labelInfo("Введиет пароль", 100, 465));
        mainWindow.add(fieldSurname);
        mainWindow.add(labelInfo("Введиет отчество", 100, 365));
        mainWindow.add(fieldLastName);
        mainWindow.add(labelInfo("Введите фамилмю", 100, 265));
        mainWindow.add(fieldName);
        mainWindow.add(labelInfo("Введите имя", 100, 165));
        mainWindow.add(labelRegister(305,100));
        mainWindow.add(new PanelRegister());

        mainWindow.setVisible(true);
    }
}
