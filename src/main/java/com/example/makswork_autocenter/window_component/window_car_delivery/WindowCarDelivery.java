package com.example.makswork_autocenter.window_component.window_car_delivery;

import com.example.makswork_autocenter.entity.Car;
import com.example.makswork_autocenter.entity.User;
import com.example.makswork_autocenter.repository.UserRepository;
import com.example.makswork_autocenter.window_component.window_auto_parts.WindowAutoParts;
import com.example.makswork_autocenter.window_component.window_auto_repair.WindowAutoRepair;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


@FieldDefaults(level = AccessLevel.PRIVATE)
public final class WindowCarDelivery {
    final JFrame mainWindow = new JFrame();
    final String PRICE_WHITE_CAR = "7 550 000 руб.";
    final String PRICE_BLACK_CAR = "9 956 000 руб.";
    JLabel labelPriceWhiteCar = labelPrice(PRICE_WHITE_CAR);
    JLabel labelPriceBlackCar = labelPrice(PRICE_BLACK_CAR);
    final UserRepository repository;
    final User user;
    Car car;

    public WindowCarDelivery(UserRepository repository, User user) {
        this.repository = repository;
        this.user = user;
    }

    /**
     * кнопка для поставки автомобиля
     * @return JButton
     */
    private JButton createButtonCarDelivery() {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Поставка автомобилей"));
        button.setSize(250, 70);
        button.setBounds(0,0,button.getWidth(), button.getHeight());
        return button;
    }

    /**
     * метод для создания кнопки, которая переходит на новое окно: Ремонт автомобилей
     * @return JButton
     */
    private JButton createButtonAutoRepair() {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Ремонт автомобилей"));
        button.setSize(250, 70);
        button.setBounds(250, 0, button.getWidth(), button.getHeight());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button.getText())) {
                    mainWindow.dispose();
                    WindowAutoRepair windowAutoRepair = new WindowAutoRepair(user, repository);
                    windowAutoRepair.createWindow();
                }
            }
        });
        return button;
    }

    /**
     * кнопка которая переводит на новое окно автозапчасти
     * @return JButton
     */
    private JButton createButtonAutoParts() {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Автозапчасти"));
        button.setSize(250, 70);
        button.setBounds(500, 0, button.getWidth(), button.getHeight());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.dispose();
                WindowAutoParts windowAutoParts = new WindowAutoParts(user, repository);
                windowAutoParts.createWindow();
            }
        });
        return button;
    }

    /**
     * создание текстового поля [сама цена]
     * создание текстового поля [цена автомобиля]
     * @param text
     * @param x
     * @param y
     * @return JLabel
     */
    private JLabel createInfo(String text, int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", text));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        label.setSize(200, 30);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }

    /**
     * создание текстового поля [......руб.]
     * @param txt
     * @return JLabel
     */
    private JLabel labelPrice(String txt) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", txt));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        label.setSize(200, 50);
        label.setBounds(500, 500, label.getWidth(), label.getHeight());
        return label;
    }

    /**
     * создание кнопок[выбрать]
     * @param x
     * @param y
     * @return JButton
     */
    private JButton createButtonChange(int x, int y) {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Выбрать"));
        button.setSize(100, 30);
        button.setBounds(x, y, button.getWidth(), button.getHeight());
        return button;
    }

    /**
     * создание кнопки[отмена]
     * @param x
     * @param y
     * @return JButton
     */
    private JButton createButtonCancel(int x, int y) {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Отмена"));
        button.setSize(200, 40);
        button.setBounds(x, y, button.getWidth(), button.getHeight());
        return button;
    }

    /**
     * при нажатии на кнопку появляютя картинки
     * @param txt
     * @param x
     * @param y
     * @return JButton
     */
    private JButton createPictures(String txt, int x, int y) {
        JButton button = new JButton();
        button.setText(String.format("[%s]", txt));
        button.setSize(150, 50);
        button.setBounds(x, y, button.getWidth(), button.getHeight());
        return button;
    }

    /**
     * метод для отображения надписи: [марка автомобиля]
     * метод для отображения надриси: [Jeep], [Wrangler]
     * @param txt
     * @param x
     * @param y
     * @return JLabel
     */
    private JLabel createLabelModelAuto(String txt, int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", txt));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        label.setSize(100, 30);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }
    /**
     * метод для надписи: поиск автомобиля
     */
    private JLabel labelSearchAuto(String txt, int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", txt));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        label.setForeground(Color.WHITE);
        label.setSize(150, 30);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }

    /**
     * метод для создания окна, отвечающего за поставку автомобилей
     * @throws IOException
     */
    public void createWindow() throws IOException {
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(765, 770);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);

        //отображение марок автомобиля
        mainWindow.add(createLabelModelAuto("Марка", 11, 120));
        mainWindow.add(createLabelModelAuto("автомобиля", 11, 135));
        mainWindow.add(createLabelModelAuto("Марка", 11, 200));
        mainWindow.add(createLabelModelAuto("автомобиля", 11, 215));
        mainWindow.add(createLabelModelAuto("Jeep", 150, 125));
        mainWindow.add(createLabelModelAuto("Wrangler", 150, 205));

        //отображение надписи: поиск автомобиля
        mainWindow.add(labelSearchAuto("Поиск автомобиля", 100, 310));

        //кнопка отмены
        JButton buttonCancel = createButtonCancel(0, 520);
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(buttonCancel.getText())) {
                    if (labelPriceWhiteCar.isVisible()) {
                        labelPriceWhiteCar.setVisible(false);
                        repository.deleteCar(user.getIdUser());
                    }
                    if (labelPriceBlackCar.isVisible()) {
                        labelPriceBlackCar.setVisible(false);
                        repository.deleteCar(user.getIdUser());
                    }
                }
            }
        });
        mainWindow.add(buttonCancel);

        //цена черной машины
        labelPriceBlackCar.setSize(145, 50);
        labelPriceBlackCar.setBounds(25,675, labelPriceBlackCar.getWidth(), labelPriceBlackCar.getHeight());
        labelPriceBlackCar.setVisible(false);
        mainWindow.add(labelPriceBlackCar);

        //кнопка для выбора черной машины
        JButton buttonChange2 = createButtonChange(550, 620);
        buttonChange2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(buttonChange2.getText())) {
                    System.out.println("click2");
                    if (labelPriceWhiteCar.isVisible()) {
                        labelPriceBlackCar.setVisible(false);
                    } else {
                        labelPriceBlackCar.setVisible(true);
                        car = new Car("Wrangler", "черный цвет", user);
                        repository.addCar(car, user.getIdUser());
                    }
                }
            }
        });
        mainWindow.add(buttonChange2);

        //кнопка для выбора белой машины
        labelPriceWhiteCar.setSize(145,50);
        labelPriceWhiteCar.setBounds(25,675,labelPriceWhiteCar.getWidth(), labelPriceWhiteCar.getHeight());
        labelPriceWhiteCar.setVisible(false);
        mainWindow.add(labelPriceWhiteCar);

        //верхняя кнопка
        JButton buttonChange1 = createButtonChange(550, 320);
        buttonChange1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(buttonChange1.getText())) {
                    System.out.println("click");
                    if (labelPriceBlackCar.isVisible()) {
                        labelPriceWhiteCar.setVisible(false);
                    } else {
                        labelPriceWhiteCar.setVisible(true);
                        car = new Car("Jeep", "белый цвет", user);
                        repository.addCar(car, user.getIdUser());
                    }
                }
            }
        });
        mainWindow.add(buttonChange1);

        mainWindow.add(createInfo("Итоговая цена", 50, 600));
        mainWindow.add(createInfo("Цена автомобиля", 402, 630));
        mainWindow.add(createInfo(PRICE_BLACK_CAR, 402, 615));
        mainWindow.add(createInfo("Цена автомобиля", 402, 330));
        mainWindow.add(createInfo(PRICE_WHITE_CAR, 402, 315));
        mainWindow.add(createButtonAutoRepair());
        mainWindow.add(createButtonAutoParts());
        mainWindow.add(createButtonCarDelivery());
        mainWindow.add(new Panel());

        mainWindow.setVisible(true);
    }
}
