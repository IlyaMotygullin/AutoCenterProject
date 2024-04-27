package com.example.makswork_autocenter.window_component.window_auto_repair;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.io.File;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Panel extends JPanel {
    final File FILE_BACKGROUND = new File("C:\\Users\\admin\\Desktop\\JavaProject\\MaksWork_AutoCenter\\src\\" +
            "main\\resources\\image096-31.jpg");
    ImageIcon imgIconBackGround = new ImageIcon(FILE_BACKGROUND.getAbsolutePath());
    Image imgBackGround = imgIconBackGround.getImage();

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(imgBackGround, 0, 0, null);
        g2.drawRect(20, 90, 440,440); // ценники
        g2.drawLine(460, 125, 20, 125);
        g2.drawRect(500, 135, 250, 300); // элементы
        g2.drawLine(500, 175, 800, 175);

        g2.drawLine(500, 650, 800, 650);
        g2.drawLine(460, 185, 20, 185);
        g2.drawLine(460, 255, 20, 255);
        g2.drawLine(460, 330, 20, 330);
        g2.drawLine(460, 400, 20, 400);
        g2.drawLine(460, 465, 20, 465);

        g2.drawLine(150, 800, 150,650);
        g2.drawLine(150, 695, 320, 695);

        g2.drawRect(500, 580, 260, 170); // итоговая цена
        g2.drawRect(0, 650, 320, 200); // номера телефонов
    }
}
