package com.example.makswork_autocenter.window_component.window_auto_repair;

import com.example.makswork_autocenter.entity.User;
import com.example.makswork_autocenter.repository.UserRepository;
import com.example.makswork_autocenter.window_component.window_auto_parts.WindowAutoParts;
import com.example.makswork_autocenter.window_component.window_car_delivery.WindowCarDelivery;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class WindowAutoRepair {
    final JFrame mainWindow = new JFrame();
    final String polishingPrice = "12 000 руб.";
    final String repairPrice = "9 350 руб.";
    final String tuningPrice = "10 500 руб.";
    final String radiatorPrice = "4 660 руб.";
    final String wheelGeometryPrice = "1 250 руб.";
    final String brakingSystemPrice = "840 руб.";
    final JLabel polishingLabel = labelContent("Восстановительная полировка кузова", 25, 110);
    final JLabel polishingLabel1 = labelContent("кросовера/внедорожника", 25, 125);
    final JLabel polishingLabel2 = labelContent("кросовера/внедорожника", 25, 125);
    final JLabel repairLabel = labelContent("Ремонт рулевой рейки", 25, 170);
    final JLabel tuningLabel = labelContent("Чип-тюнинг ДВС(категория III)", 25, 240);
    final JLabel radiatorLabel = labelContent("Радиатор - ремонт/восстановление/пайка", 25, 315);
    final JLabel wheelGeometryLabel = labelContent("Геометрия колес(развал/схождение)", 25, 385);
    final JLabel wheelGeometryLabel1 = labelContent("иномарки Джип, микроавтобус,", 25, 400);
    final JLabel wheelGeometryLabel2 = labelContent("4WD (передняя + задняя)", 25, 415);
    final JLabel brakingSystemLabel = labelContent("Тормозная система - прокачать", 25, 450);
    final JLabel brakingSystemLabel1 = labelContent("(прокачка всей тормозной системы)", 25, 465);
    final User user;
    final UserRepository userRepository;

    public WindowAutoRepair(User user, UserRepository userRepository) {
        this.user = user;
        this.userRepository = userRepository;
    }

    JLabel labelResultPrice = new JLabel();
    int priceService = 0;
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
                    WindowCarDelivery windowCarDelivery = new WindowCarDelivery(userRepository, user);
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
        return button;
    }
    private JButton createButtonAutoParts() {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Автозапчасти"));
        button.setSize(250, 70);
        button.setBounds(500, 0, button.getWidth(), button.getHeight());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.dispose();
                WindowAutoParts windowAutoParts = new WindowAutoParts(user, userRepository);
                windowAutoParts.createWindow();
            }
        });
        return button;
    }
    private JLabel createPriceList() {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", "Прайс-лист"));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        label.setSize(200, 30);
        label.setBounds(20,100, label.getWidth(), label.getHeight());
        return label;
    }
    private JButton createButtonCancel() {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Отменить выбор"));
        button.setSize(250, 40);
        button.setBounds(500, 490, button.getWidth(), button.getHeight());
        return button;
    }
    private JButton createButtonChange(int x, int y) {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Выбрать"));
        button.setSize(100, 27);
        button.setBounds(x, y, button.getWidth(), button.getHeight());
        return button;
    }
    private JLabel labelInfoPrice(String txt, int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", txt));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        label.setSize(145,27);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }
    private JLabel labelContent(String txt, int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("%s", txt));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        label.setSize(400, 50);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }
    private JLabel changeElement(int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", "Выбранные элементы"));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        label.setSize(150, 50);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }
    private JLabel makeAnAppointment(String txt, int x, int y) {
        JLabel label = new JLabel();
        label.setText(String.format("%s", txt));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
        label.setSize(150,50);
        label.setBounds(x, y, label.getWidth(), label.getHeight());
        return label;
    }
    private JLabel newPlace(String txt, int x, int y, int width, int height) {
        JLabel label = new JLabel();
        label.setText(txt);
        label.setBounds(x, y, width, height);
        return label;
    }
    private int getNumberInString(String sum) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < sum.length(); i++) {
            if (sum.charAt(i) == '0' || sum.charAt(i) == '1' || sum.charAt(i) == '2'
                    || sum.charAt(i) == '3' || sum.charAt(i) == '4' || sum.charAt(i) == '5'
                    || sum.charAt(i) == '6' || sum.charAt(i) == '7' || sum.charAt(i) == '8'
                    || sum.charAt(i) == '9') {
                stringBuilder.append(sum.charAt(i));
            }
        }
        int result = Integer.parseInt(stringBuilder.toString());
        return result;
    }
    public void createWindow() {
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(765, 770);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);

        mainWindow.add(makeAnAppointment("Итоговая сумма", 550, 590));
        mainWindow.add(makeAnAppointment("ремонта:", 655, 590));

        mainWindow.add(makeAnAppointment("8(923) 787 78-78", 170, 645));
        mainWindow.add(makeAnAppointment("8(385) 656 65-65", 170, 690));
        mainWindow.add(makeAnAppointment("Записаться на прием", 3, 660));
        mainWindow.add(makeAnAppointment("или ремонт автомобиля", 3, 680));
        mainWindow.add(changeElement(550, 125));

        labelResultPrice.setText(priceService + " руб.");
        labelResultPrice.setSize(200, 80);
        labelResultPrice.setBounds(620, 650, labelResultPrice.getWidth(), labelResultPrice.getHeight());
        mainWindow.getContentPane().add(labelResultPrice);

        // показывает, что приобрели услугу: полировка кузова
        polishingLabel.setVisible(true);
        polishingLabel1.setVisible(true);
        polishingLabel2.setVisible(true);
        mainWindow.add(polishingLabel);
        mainWindow.add(polishingLabel1);
        mainWindow.add(polishingLabel2);
        JLabel newPositionPolishing1 = newPlace(polishingLabel.getText(), 505, 170, polishingLabel.getWidth(), polishingLabel.getHeight());
        JLabel newPositionPolishing2 = newPlace(polishingLabel1.getText(), 505, 190, polishingLabel1.getWidth(), polishingLabel1.getHeight());
        newPositionPolishing1.setVisible(false);
        newPositionPolishing2.setVisible(false);
        mainWindow.add(newPositionPolishing1);
        mainWindow.add(newPositionPolishing2);
        JButton button1 = createButtonChange(360,155);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button1.getText())) {
                    System.out.println("click1");
                    newPositionPolishing1.setVisible(true);
                    newPositionPolishing2.setVisible(true);
                    priceService += getNumberInString(polishingPrice);
                    labelResultPrice.setText(priceService + " руб.");
                    userRepository.addPriceRepair(priceService, user.getIdUser());
                }
            }
        });
        mainWindow.add(button1);

        //показывает что приобрели услугу: починки руля
        repairLabel.setVisible(true);
        mainWindow.add(repairLabel);
        JLabel newPositionRepairLabel = newPlace(repairLabel.getText(), 505, 210, repairLabel.getWidth(), repairLabel.getHeight());
        newPositionRepairLabel.setVisible(false);
        mainWindow.add(newPositionRepairLabel);
        JButton button2 = createButtonChange( 360, 225);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button2.getText())) {
                    System.out.println("click2");
                    newPositionRepairLabel.setVisible(true);
                    priceService += getNumberInString(repairPrice);
                    labelResultPrice.setText(priceService + " руб.");
                    userRepository.addPriceRepair(priceService, user.getIdUser());
                }
            }
        });
        mainWindow.add(button2);

        //показывает что приобрели услугу: Чип-тюнинг
        tuningLabel.setVisible(true);
        mainWindow.add(tuningLabel);
        JLabel newPositionTuningLabel = newPlace(tuningLabel.getText(), 505, 230, tuningLabel.getWidth(), tuningLabel.getHeight());
        newPositionTuningLabel.setVisible(false);
        mainWindow.add(newPositionTuningLabel);
        JButton button3 = createButtonChange(360, 300);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button3.getText())) {
                    System.out.println("click3");
                    newPositionTuningLabel.setVisible(true);
                    priceService += getNumberInString(tuningPrice);
                    labelResultPrice.setText(priceService + " руб.");
                    userRepository.addPriceRepair(priceService, user.getIdUser());
                }
            }
        });
        mainWindow.add(button3);

        //показывает что приобрели услугу: радиатор
        radiatorLabel.setVisible(true);
        mainWindow.add(radiatorLabel);
        JLabel newPositionRadiatorLabel = newPlace(radiatorLabel.getText(), 505, 250, radiatorLabel.getWidth(), radiatorLabel.getHeight());
        newPositionRadiatorLabel.setVisible(false);
        mainWindow.add(newPositionRadiatorLabel);
        JButton button4 = createButtonChange(360, 370);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button4.getText())) {
                    System.out.println("click4");
                    newPositionRadiatorLabel.setVisible(true);
                    priceService += getNumberInString(radiatorPrice);
                    labelResultPrice.setText(priceService + " руб.");
                    userRepository.addPriceRepair(priceService, user.getIdUser());
                }
            }
        });
        mainWindow.add(button4);

        //показывает что приобрели услугу: геометрия колес
        wheelGeometryLabel.setVisible(true);
        wheelGeometryLabel1.setVisible(true);
        wheelGeometryLabel2.setVisible(true);
        mainWindow.add(wheelGeometryLabel);
        mainWindow.add(wheelGeometryLabel1);
        mainWindow.add(wheelGeometryLabel2);
        JLabel newPositionWheelGeometry = newPlace(wheelGeometryLabel.getText(), 505, 270, wheelGeometryLabel.getWidth(), wheelGeometryLabel.getHeight());
        JLabel newPositionWheelGeometry1 = newPlace(wheelGeometryLabel1.getText(), 505, 285, wheelGeometryLabel1.getWidth(), wheelGeometryLabel1.getHeight());
        JLabel newPositionWheelGeometry2 = newPlace(wheelGeometryLabel2.getText(), 505, 300, wheelGeometryLabel2.getWidth(), wheelGeometryLabel2.getHeight());
        newPositionWheelGeometry.setVisible(false);
        newPositionWheelGeometry1.setVisible(false);
        newPositionWheelGeometry2.setVisible(false);
        mainWindow.add(newPositionWheelGeometry);
        mainWindow.add(newPositionWheelGeometry1);
        mainWindow.add(newPositionWheelGeometry2);
        JButton button5 = createButtonChange(360, 435);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button5.getText())) {
                    System.out.println("click5");
                    newPositionWheelGeometry.setVisible(true);
                    newPositionWheelGeometry1.setVisible(true);
                    newPositionWheelGeometry2.setVisible(true);
                    priceService += getNumberInString(wheelGeometryPrice);
                    labelResultPrice.setText(priceService + " руб.");
                    userRepository.addPriceRepair(priceService, user.getIdUser());
                }
            }
        });
        mainWindow.add(button5);

        //показывает что приобрели услугу: прокачка тормозной системы
        brakingSystemLabel.setVisible(true);
        brakingSystemLabel1.setVisible(true);
        mainWindow.add(brakingSystemLabel);
        mainWindow.add(brakingSystemLabel1);
        JLabel newPositionBrakingSystemLabel1 = newPlace(brakingSystemLabel.getText(), 505, 320, brakingSystemLabel.getWidth(), brakingSystemLabel.getHeight());
        JLabel newPositionBrakingSystemLabel2 = newPlace(brakingSystemLabel1.getText(), 505, 340, brakingSystemLabel1.getWidth(), brakingSystemLabel1.getHeight());
        newPositionBrakingSystemLabel1.setVisible(false);
        newPositionBrakingSystemLabel2.setVisible(false);
        mainWindow.add(newPositionBrakingSystemLabel1);
        mainWindow.add(newPositionBrakingSystemLabel2);
        JButton button6 = createButtonChange( 360, 500);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button6.getText())) {
                    System.out.println("click6");
                    newPositionBrakingSystemLabel1.setVisible(true);
                    newPositionBrakingSystemLabel2.setVisible(true);
                    priceService += getNumberInString(brakingSystemPrice);
                    labelResultPrice.setText(priceService + " руб.");
                    userRepository.addPriceRepair(priceService, user.getIdUser());
                }
            }
        });
        mainWindow.add(button6);

        //кнопка отмены услуг
        JButton buttonCancel = createButtonCancel();
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(buttonCancel.getText())) {
                    newPositionPolishing1.setVisible(false);
                    newPositionPolishing2.setVisible(false);
                    newPositionWheelGeometry.setVisible(false);
                    newPositionWheelGeometry1.setVisible(false);
                    newPositionWheelGeometry2.setVisible(false);
                    newPositionBrakingSystemLabel1.setVisible(false);
                    newPositionBrakingSystemLabel2.setVisible(false);
                    newPositionRadiatorLabel.setVisible(false);
                    newPositionTuningLabel.setVisible(false);
                    newPositionRepairLabel.setVisible(false);
                    priceService = 0;
                    labelResultPrice.setText(priceService + " руб.");
                    userRepository.deletePriceRepair(user.getIdUser());
                }
            }
        });
        mainWindow.add(buttonCancel);

        mainWindow.add(labelInfoPrice(polishingPrice, 358, 130));
        mainWindow.add(labelInfoPrice(repairPrice, 360, 200));
        mainWindow.add(labelInfoPrice(tuningPrice, 360, 275));
        mainWindow.add(labelInfoPrice(radiatorPrice, 360, 345));
        mainWindow.add(labelInfoPrice(wheelGeometryPrice, 360, 410));
        mainWindow.add(labelInfoPrice(brakingSystemPrice, 360, 475));

        mainWindow.add(createPriceList());
        mainWindow.add(createButtonAutoParts());
        mainWindow.add(createButtonAutoRepair());
        mainWindow.add(createButtonCarDelivery());
        mainWindow.add(new Panel());

        mainWindow.setVisible(true);
    }
}
