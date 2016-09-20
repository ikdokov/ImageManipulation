package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePane extends JPanel {

    Image img;

    public void  paint(Graphics g) {
        g.drawImage(img, 20, 20, this);
    }

    public void addImage(Image img) {
        this.img = img;
    }
}
