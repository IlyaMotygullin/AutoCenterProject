package com.example.makswork_autocenter.window_component.window_auto_parts;

import com.example.makswork_autocenter.entity.User;
import com.example.makswork_autocenter.repository.UserRepository;
import com.example.makswork_autocenter.window_component.window_auto_repair.WindowAutoRepair;
import com.example.makswork_autocenter.window_component.window_car_delivery.WindowCarDelivery;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class WindowAutoParts {
    final JFrame mainWindow = new JFrame();
    final String priceRechargeableBattery = "9 219 руб.";
    final String priceBrush = "189 руб.";
    final String priceLiquid = "165 руб.";
    final String priceEngineOil = "261 руб.";
    int priceService = 0;
    final User user;
    final UserRepository repository;

    public WindowAutoParts(User user, UserRepository repository) {
        this.user = user;
        this.repository = repository;
    }

    private JButton createButtonCarDelivery() {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Поставка автомобилей"));
        button.setSize(250, 70);
        button.setBounds(0,0,button.getWidth(), button.getHeight());
        button.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button.getText())) {
                    mainWindow.dispose();
                    WindowCarDelivery windowCarDelivery = new WindowCarDelivery(repository, user);
                    windowCarDelivery.createWindow();
                }
            }
        });
        return button;
    }
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
    private JButton createButtonAutoParts() {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Автозапчасти"));
        button.setSize(250, 70);
        button.setBounds(500, 0, button.getWidth(), button.getHeight());
        return button;
    }
    private JLabel listAutoParts(int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", "Список автозапчастей"));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        label.setSize(300, 40);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }
    private JLabel contentLabel(String txt, int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("%s", txt));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        label.setSize(350, 50);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }
    private JLabel priceLabel(String price, int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", price));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        label.setSize(250, 50);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }
    private JButton createButtonChange(int x, int y) {
        JButton button = new JButton();
        button.setText(String.format("[Выбрать]"));
        button.setSize(100, 30);
        button.setBounds(x, y, button.getWidth(), button.getHeight());
        return button;
    }
    private JButton cancelButton(int x, int y) {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Отмена"));
        button.setSize(250, 50);
        button.setBounds(x, y, button.getWidth(), button.getHeight());
        return button;
    }
    private JLabel newPlace(String txt, int x, int y, int width, int height) {
        JLabel label = new JLabel();
        label.setText(String.format("%s", txt));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        label.setSize(width, height);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }
    private JLabel resultSumLabel(int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", "Итоговая сумма"));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        label.setSize(200, 50);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }
    private JLabel changeElement(int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", "Выбранные элементы"));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        label.setSize(250, 50);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }
    private int getStringPrice(String price) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < price.length(); i++) {
            if (price.charAt(i) == '0' || price.charAt(i) == '1' || price.charAt(i) == '2'
            || price.charAt(i) == '3' || price.charAt(i) == '4' || price.charAt(i) == '5'
            || price.charAt(i) == '6' || price.charAt(i) == '7' || price.charAt(i) == '8'
            || price.charAt(i) == '9') {
                stringBuilder.append(price.charAt(i));
            }
        }
        int priceResult = Integer.parseInt(stringBuilder.toString());
        return priceResult;
    }
    public void createWindow() {
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(765, 770);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);

        mainWindow.add(changeElement(540, 165));
        mainWindow.add(resultSumLabel(550,600));

        //показ цены
        JLabel labelViewSumResultService = new JLabel();
        labelViewSumResultService.setText(priceService + " руб.");
        labelViewSumResultService.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        labelViewSumResultService.setSize(250, 50);
        labelViewSumResultService.setBounds(605, 680, labelViewSumResultService.getWidth(), labelViewSumResultService.getHeight());
        mainWindow.getContentPane().add(labelViewSumResultService);

        //ценики
        mainWindow.add(priceLabel(priceRechargeableBattery, 405, 150));
        mainWindow.add(priceLabel(priceBrush, 405, 300));
        mainWindow.add(priceLabel(priceLiquid, 405, 450));
        mainWindow.add(priceLabel(priceEngineOil, 405, 600));

        //отображение
        JLabel labelBattery = contentLabel("Стартерная аккумуляторная батарея", 5, 120);
        JLabel labelBattery2 = contentLabel("19375454  ACDELCO", 5, 132);
        labelBattery.setVisible(true);
        labelBattery2.setVisible(true);
        mainWindow.add(labelBattery);
        mainWindow.add(labelBattery2);
        JLabel newPositionLabelBattery = newPlace(labelBattery.getText(), 507, 250, labelBattery.getWidth(), labelBattery2.getHeight());
        JLabel newPositionLabelBattery2 = newPlace(labelBattery2.getText(), 507, 265, labelBattery2.getWidth(), labelBattery2.getHeight());
        newPositionLabelBattery.setVisible(false);
        newPositionLabelBattery2.setVisible(false);
        mainWindow.add(newPositionLabelBattery);
        mainWindow.add(newPositionLabelBattery2);
        JButton button1 = createButtonChange(400, 185);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button1.getText())) {
                    System.out.println("click1");
                    newPositionLabelBattery.setVisible(true);
                    newPositionLabelBattery2.setVisible(true);
                    priceService += getStringPrice(priceRechargeableBattery);
                    labelViewSumResultService.setText(priceService + " руб.");
                    labelViewSumResultService.setVisible(true);
                    repository.addPriceAutoParts(priceService, user.getIdUser());
                }
            }
        });
        mainWindow.add(button1);
        mainWindow.add(contentLabel("Емкость", 10, 155));
        mainWindow.add(contentLabel("Полярность", 10, 175));
        mainWindow.add(contentLabel("Габариты", 10, 195));
        mainWindow.add(contentLabel("Напряжение", 10, 215));
        mainWindow.add(contentLabel("Пусковой ток, А", 10, 235));
        mainWindow.add(contentLabel("60", 230, 155));
        mainWindow.add(contentLabel("Прямая", 230, 175));
        mainWindow.add(contentLabel("242x175x190", 230, 195));
        mainWindow.add(contentLabel("12", 230, 215));
        mainWindow.add(contentLabel("600", 230, 235));

        JLabel brushLabel = contentLabel("Щетка стеклоочистителя каркасная", 5, 260);
        JLabel brushLabel1 = contentLabel("AD405C13 AIDO (13)", 5, 275);
        brushLabel.setVisible(true);
        brushLabel1.setVisible(true);
        mainWindow.add(brushLabel);
        mainWindow.add(brushLabel1);
        JLabel newPositionBrushLabel = newPlace(brushLabel.getText(), 507, 300, brushLabel.getWidth(), brushLabel.getHeight());
        JLabel newPositionBrushLabel1 = newPlace(brushLabel1.getText(), 507, 315, brushLabel1.getWidth(), brushLabel1.getHeight());
        newPositionBrushLabel1.setVisible(false);
        newPositionBrushLabel.setVisible(false);
        mainWindow.add(newPositionBrushLabel);
        mainWindow.add(newPositionBrushLabel1);
        JButton button2 = createButtonChange(400, 335);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button2.getText())) {
                    newPositionBrushLabel.setVisible(true);
                    newPositionBrushLabel1.setVisible(true);
                    priceService += getStringPrice(priceBrush);
                    labelViewSumResultService.setText(priceService + " руб.");
                    repository.addPriceAutoParts(priceService, user.getIdUser());
                }
            }
        });
        mainWindow.add(button2);
        mainWindow.add(contentLabel("Производитель", 10, 315));
        mainWindow.add(contentLabel("Длинна, мм", 10, 335));
        mainWindow.add(contentLabel("Тип крепления", 10, 355));
        mainWindow.add(contentLabel("Распылитель", 10, 375));
        mainWindow.add(contentLabel("AIDO", 230, 315));
        mainWindow.add(contentLabel("330", 230, 335));
        mainWindow.add(contentLabel("Крючок 9 мм", 230, 355));
        mainWindow.add(contentLabel("Нет", 230, 375));

        JLabel labelLiquid = contentLabel("Жидкость ГУР минеральное PSF", 5, 420);
        JLabel labelLiquid1 = contentLabel("55270 3TON", 5, 435);
        labelLiquid1.setVisible(true);
        labelLiquid.setVisible(true);
        mainWindow.add(labelLiquid);
        mainWindow.add(labelLiquid1);
        JLabel newPositionLabelLiquid = newPlace(labelLiquid.getText(), 507, 350, labelLiquid.getWidth(), labelLiquid.getHeight());
        JLabel newPositionLabelLiquid1 = newPlace(labelLiquid1.getText(), 507, 365, labelLiquid1.getWidth(), labelLiquid1.getHeight());
        newPositionLabelLiquid.setVisible(false);
        newPositionLabelLiquid1.setVisible(false);
        mainWindow.add(newPositionLabelLiquid);
        mainWindow.add(newPositionLabelLiquid1);
        JButton button3 = createButtonChange(400, 485);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button3.getText())) {
                    System.out.println("click3");
                    newPositionLabelLiquid.setVisible(true);
                    newPositionLabelLiquid1.setVisible(true);
                    priceService += getStringPrice(priceLiquid);
                    labelViewSumResultService.setText(priceService + " руб.");
                    repository.addPriceAutoParts(priceService, user.getIdUser());
                }
            }
        });
        mainWindow.add(button3);
        mainWindow.add(contentLabel("Состав", 10, 460));
        mainWindow.add(contentLabel("Объем", 10, 480));
        mainWindow.add(contentLabel("Тип", 10, 500));
        mainWindow.add(contentLabel("Место применения", 10, 520));
        mainWindow.add(contentLabel("Минеральное", 230, 460));
        mainWindow.add(contentLabel("0.5", 230, 480));
        mainWindow.add(contentLabel("Жидкость ГУР", 230, 500));
        mainWindow.add(contentLabel("ГУР", 230, 520));

        JLabel labelOil = contentLabel("Масло моторное минеральное 4", 5, 560);
        JLabel labelOil1 = contentLabel("Stroke Oil 30 40240 3TON", 5, 575);
        labelOil.setVisible(true);
        labelOil1.setVisible(true);
        mainWindow.add(labelOil);
        mainWindow.add(labelOil1);
        JLabel newPositionLabelOil = newPlace(labelOil.getText(), 507, 400, labelOil.getWidth(), labelOil.getHeight());
        JLabel newPositionLabelOil1 = newPlace(labelOil1.getText(), 507, 410, labelOil1.getWidth(), labelOil1.getHeight());
        newPositionLabelOil.setVisible(false);
        newPositionLabelOil1.setVisible(false);
        mainWindow.add(newPositionLabelOil);
        mainWindow.add(newPositionLabelOil1);
        JButton button4 = createButtonChange(400, 635);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button4.getText())) {
                    System.out.println("click4");
                    newPositionLabelOil.setVisible(true);
                    newPositionLabelOil1.setVisible(true);
                    priceService += getStringPrice(priceEngineOil);
                    labelViewSumResultService.setText(priceService + " руб.");
                    repository.addPriceAutoParts(priceService, user.getIdUser());
                }
            }
        });
        mainWindow.add(button4);
        mainWindow.add(contentLabel("Вязкость", 10, 605));
        mainWindow.add(contentLabel("API", 10, 625));
        mainWindow.add(contentLabel("Состав", 10, 645));
        mainWindow.add(contentLabel("Объем", 10, 665));
        mainWindow.add(contentLabel("30W", 230, 605));
        mainWindow.add(contentLabel("CD, SG", 230, 625));
        mainWindow.add(contentLabel("Минеральное", 230, 645));
        mainWindow.add(contentLabel("1л", 230, 665));

        JButton buttonCancel = cancelButton(505,535);
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPositionBrushLabel.setVisible(false);
                newPositionBrushLabel1.setVisible(false);
                newPositionLabelBattery2.setVisible(false);
                newPositionLabelBattery.setVisible(false);
                newPositionLabelLiquid.setVisible(false);
                newPositionLabelLiquid1.setVisible(false);
                newPositionLabelOil.setVisible(false);
                newPositionLabelOil1.setVisible(false);
                priceService = 0;
                labelViewSumResultService.setText(priceService + " руб.");
                repository.deletePriceAutoParts(user.getIdUser());
            }
        });
        mainWindow.add(buttonCancel);

        mainWindow.add(listAutoParts(0, 105));
        mainWindow.add(createButtonAutoParts());
        mainWindow.add(createButtonAutoRepair());
        mainWindow.add(createButtonCarDelivery());

        mainWindow.add(new Panel());

        mainWindow.setVisible(true);
    }
}
