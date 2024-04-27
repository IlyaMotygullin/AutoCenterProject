package com.example.makswork_autocenter.window_entrance;

import com.example.makswork_autocenter.entity.User;
import com.example.makswork_autocenter.repository.UserRepository;
import com.example.makswork_autocenter.service.UserService;
import com.example.makswork_autocenter.window_component.window_car_delivery.WindowCarDelivery;
import com.example.makswork_autocenter.window_register.WindowRegister;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class WindowEntrance {
    final JFrame mainWindow = new JFrame();
    String nameUser;
    String lastnameUser;
    String password;
    final UserRepository repository;
    final User user;

    public WindowEntrance(UserRepository repository, User user) {
        this.repository = repository;
        this.user = user;
    }

    private JLabel inputInfoLabel(String txt, int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", txt));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        label.setSize(300, 80);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }

    private JLabel informationLabel(String txt, int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", txt));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
        label.setSize(250, 50);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }

    private JButton createButton(String txt, int x, int y) {
        JButton button = new JButton();
        button.setText(String.format("[%s]", txt));
        button.setSize(150, 40);
        button.setBounds(x, y, button.getWidth(), button.getHeight());
        return button;
    }

    public void createWindow() {
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(765, 770);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);

        JTextField fieldInputName = new JTextField();
        fieldInputName.setSize(550, 30);
        fieldInputName.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        fieldInputName.setBounds(100, 200, fieldInputName.getWidth(), fieldInputName.getHeight());
        fieldInputName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameUser = fieldInputName.getText();
            }
        });

        JTextField fieldInputLastname = new JTextField();
        fieldInputLastname.setSize(550, 30);
        fieldInputLastname.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        fieldInputLastname.setBounds(100, 300, fieldInputLastname.getWidth(), fieldInputLastname.getHeight());
        fieldInputLastname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastnameUser = fieldInputLastname.getText();
            }
        });

        JTextField fieldInputPassword = new JTextField();
        fieldInputPassword.setSize(550, 30);
        fieldInputPassword.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        fieldInputPassword.setBounds(100, 400, fieldInputPassword.getWidth(), fieldInputLastname.getHeight());
        fieldInputPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                password = fieldInputPassword.getText();
            }
        });

        mainWindow.add(fieldInputPassword);
        mainWindow.add(fieldInputLastname);
        mainWindow.add(fieldInputName);

        JButton buttonEntrance = createButton("Войти", 500, 600);
        buttonEntrance.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                List<User> userList = repository.getUserList();
                for (User user : userList) {
                    if (user.getName().equals(nameUser)
                            && user.getLastname().equals(lastnameUser)
                            && user.getPassword().equals(password)) {
                        mainWindow.dispose();
                        WindowCarDelivery windowCarDelivery = new WindowCarDelivery(repository, user);
                        windowCarDelivery.createWindow();
                        return;
                    }
                }
            }
        });

        JButton buttonRegister = createButton("Регистрация", 100, 600);
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(buttonRegister.getText())) {
//                    mainWindow.dispose();
//                    WindowRegister windowRegister = new WindowRegister();
//                    windowRegister.createWindow(repository);
                }
            }
        });

        mainWindow.add(buttonEntrance);
        mainWindow.add(buttonRegister);

        mainWindow.add(informationLabel("Введите пароль", 100, 365));
        mainWindow.add(informationLabel("Введите фамилию", 100, 265));
        mainWindow.add(informationLabel("Введите имя", 100, 165));

        mainWindow.add(inputInfoLabel("Войти в учетную запись", 230, 100));
        mainWindow.add(new PanelEntrance());

        mainWindow.setVisible(true);
    }
}
