package com.example.makswork_autocenter.window_entrance;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.io.File;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PanelEntrance extends JPanel {
    final File FILE_BACKGROUND = new File("C:\\Users\\admin\\Desktop\\JavaProject\\MaksWork_AutoCenter\\src\\" +
            "main\\resources\\image096-31.jpg");
    final ImageIcon IMG_ICON_BACKGROUND = new ImageIcon(FILE_BACKGROUND.getAbsolutePath());
    final Image IMG_BACKGROUND = IMG_ICON_BACKGROUND.getImage();

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(IMG_BACKGROUND, 0, 0, null);
    }
}
