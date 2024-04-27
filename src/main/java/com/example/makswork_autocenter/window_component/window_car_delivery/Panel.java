package com.example.makswork_autocenter.window_component.window_car_delivery;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

@FieldDefaults(level = AccessLevel.PRIVATE)
public final class Panel extends JPanel {
    final File FILE_BACKGROUND = new File("C:\\Users\\admin\\Desktop\\JavaProject\\MaksWork_AutoCenter\\src\\" +
            "main\\resources\\image096-31.jpg");
    final File FILE_CAR_WHITE = new File("C:\\Users\\admin\\Desktop\\JavaProject\\MaksWork_AutoCenter\\src\\" +
            "main\\resources\\photo_2024-04-25_21-39-32.jpg");
    final File FILE_CAR_BLACK = new File("C:\\Users\\admin\\Desktop\\JavaProject\\MaksWork_AutoCenter\\src\\" +
            "main\\resources\\photo_2024-04-25_23-38-56.jpg");
    final File ARROW = new File("C:\\Users\\admin\\Desktop\\JavaProject\\MaksWork_AutoCenter\\src\\main\\" +
            "resources\\1680038742_phonoteka-org-p-krasnaya-strelochka-oboi-instagram-9.jpg");
    ImageIcon imageBackGroundIcon = new ImageIcon(FILE_BACKGROUND.getAbsolutePath());
    Image imgBackGround = imageBackGroundIcon.getImage();

    /**
     * получение отформатированного растрового изображения
     * @param originalImg
     * @param newWidth
     * @param newHeight
     * @return BufferedImage
     */
    private BufferedImage resizedImg(BufferedImage originalImg, int newWidth, int newHeight) {
        Image newImg = originalImg.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH); // создание нового изображения с заданными размерами(сглаживание более высокое)
        BufferedImage resultImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB); // создание нового растрового изображения(24-битная RGB модель изображения)
        Graphics2D g2 = resultImg.createGraphics(); //получение графического контекста
        g2.drawImage(newImg, 0, 0, null); //копирует масштабированное изображение в новое растровое изображение
        g2.dispose(); //освобождение ресурсов
        return resultImg;
    }

    /**
     * получение отформатированного изображения
     * @param file
     * @return Image
     */
    @SneakyThrows
    private Image workWithImgCar(File file, int width, int height) {
        BufferedImage originalImg = ImageIO.read(file); //получение растрового изображения из файла jpg
        BufferedImage resultImg = resizedImg(originalImg, width, height); //форматирование изображения
        ImageIcon resizedImgIconCarWhite = new ImageIcon(resultImg);
        Image imgResultWhiteCar = resizedImgIconCarWhite.getImage();
        return imgResultWhiteCar;
    }

    @SneakyThrows
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(imgBackGround, 0, 0, null);
        g2.drawImage(workWithImgCar(FILE_CAR_WHITE, 250, 200), 400, 100, this);
        g2.drawImage(workWithImgCar(FILE_CAR_BLACK, 250, 200), 400, 400, this);
        g2.drawImage(workWithImgCar(ARROW, 75,65), 245,110, this);
        g2.drawImage(workWithImgCar(ARROW, 75,65), 245,192, this);

        //отрисовка прямогольников для картинок автомобилей
        g2.drawRect(400, 100, 250, 200);
        g2.drawRect(400, 400, 250, 200);

        //отрисовка прямоугольников с ценой
        g2.drawRect(400, 300, 250, 70);
        g2.drawRect(400, 600, 250, 70);

        //отрисовка прямоугольника с ценой
        g2.drawRect(0, 580, 200, 150);
        g2.drawLine(0, 650, 200, 650);

        //отрисовка двух прямоугольников: марки автомобиля
        g2.drawRect(10, 110, 300, 60);
        g2.drawRect(10, 190, 300, 60);

        //отрисовка прямоугольника: поиск автомобиля
        g2.setColor(Color.BLUE);
        g2.fillRect(90, 300, 150, 50);

        //отрисовка линий
        g2.setColor(Color.BLACK);
        g2.drawLine(130, 110, 130, 170);
        g2.drawLine(130, 190, 130, 250);
        g2.drawLine(250, 110, 250,170);
        g2.drawLine(250, 190,250,250);
    }
}
