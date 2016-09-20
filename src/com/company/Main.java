package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by idokov on 16/09/2016.
 */
public class Main {
    public static void main(String [] args) {

        BufferedImage imageBasis;
        BufferedImage imageOverlay;
        BufferedImage intersectionImage = null;

        try {
            imageBasis = scaleImage(ImageIO.read(new File("res/circle.png")), 400, 400);
            imageOverlay = scaleImage(ImageIO.read(new File("res/minus.png")), 400, 400);
            intersectionImage = new BufferedImage(400, 400, BufferedImage.OPAQUE);

            Graphics graphics = intersectionImage.getGraphics();
            graphics.drawImage(imageBasis, 0, 0, null);
            graphics.drawImage(imageOverlay, 0, 0, null);
            graphics.dispose();


        } catch (IOException e) {
            System.out.println("Unable to open image.");
        }

        if (intersectionImage != null) {
            showImage(intersectionImage);
        }
    }

    private static void showImage(BufferedImage img) {
        JFrame frame = new JFrame();

        ImagePane imagePane = new ImagePane();
        imagePane.addImage(img);

        frame.getContentPane().add(imagePane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    private static BufferedImage scaleImage(BufferedImage image, int width, int height) {
        Image toolkitImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        BufferedImage newImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        Graphics g = newImage.getGraphics();
        g.drawImage(toolkitImage, 0, 0, null);
        g.dispose();

        return newImage;
    }
}
