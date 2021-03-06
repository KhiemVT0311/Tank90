package com.khiem1999.models;

import com.khiem1999.gui.MyFrame;
import com.khiem1999.utils.LoaderUtils;

import java.awt.*;

public class Bullet {
    private Image image = LoaderUtils.getImage("bullet.png");
    private int x;
    private int y;
    private int orient;

    public Bullet(int x, int y, int orient) {
        this.x = x - image.getWidth(null) / 2;
        this.y = y - image.getHeight(null) / 2;
        this.orient = orient;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, x, y, null);
    }

    public boolean move() {
        switch (orient) {
            case Tank.LEFT:
                x -= 2;
                break;
            case Tank.RIGHT:
                x += 2;
                break;
            case Tank.UP:
                y -= 2;
                break;
            case Tank.DOWN:
                y += 2;
                break;
        }
        return x < 0 || x > MyFrame.W_FRAME ||
                y < 0 || y > MyFrame.H_FRAME;
    }

    public Rectangle getRect() {
        int w = image.getWidth(null);
        int h = image.getHeight(null);
        return new Rectangle(x, y, w, h);
    }
}
