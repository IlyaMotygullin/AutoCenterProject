package com.example.makswork_autocenter.window_component.window_auto_parts;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.io.File;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Panel extends JPanel {
    final File FILE_BACKGROUND = new File("C:\\Users\\admin\\Desktop\\JavaProject\\MaksWork_AutoCenter\\src" +
            "\\main\\resources\\image096-31.jpg");
    final ImageIcon imgIconBackGround = new ImageIcon(FILE_BACKGROUND.getAbsolutePath());
    final Image imgBackGround = imgIconBackGround.getImage();

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(imgBackGround, 0,0,null);
        g2.drawRect(0, 110, 500,700); //список автозапчастей
        g2.drawRect(505, 170, 300, 350); // выбранные элементы
        g2.drawRect(505, 600, 300, 200); // итоговая сумма

        g2.drawLine(0, 135, 500, 135);
        g2.drawLine(0, 275, 500, 275);
        g2.drawLine(0, 435, 500, 435);
        g2.drawLine(0, 575, 500, 575);
        g2.drawLine(0, 710, 500, 710);

        g2.drawLine(505, 235, 750, 235);
        g2.drawLine(505, 670, 750, 670);
    }
}
