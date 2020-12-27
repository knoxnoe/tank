package com.noe.tank;

import java.awt.*;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
public class Bullet {
    private static final int SPEED = 10;
    // 子弹大小
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    // 位置
    private int x, y;
    // 方向
    private Dir dir;

    private TankFrame tf;

    private boolean live = true;
    public Bullet() {
    }

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);

        move();
    }

    private void move() {
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
        if(x < 0 || x > TankFrame.GAME_WIDTH || y < 0 || y > TankFrame.GAME_HEIGHT) live = false;
    }
}
