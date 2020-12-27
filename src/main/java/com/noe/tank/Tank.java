package com.noe.tank;

import java.awt.*;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 7;
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private TankFrame tf;

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    private boolean moving = false;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        super(); // 从Object继承
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(x, y, WIDTH,HEIGHT);
        g.setColor(c);
        move();

    }

    public void move() {
        if(!moving) return;
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
        }
    }

    public void fire() {
        tf.bullets.add(new Bullet(this.x, this.y, this.dir, this.tf));
    }
}
