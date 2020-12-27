package com.noe.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
public class TankFrame extends Frame {

    final static int GAME_WIDTH = 800;
    final static int GAME_HEIGHT = 600;


    Tank myTank = new Tank(200, 200, Dir.UP, this);
    List<Tank> tanks = new ArrayList<>();
    List<Bullet> bullets = new ArrayList<Bullet>();
    Bullet b = new Bullet(300, 300, Dir.UP, this);

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        // 设置是否可放缩窗口
        setResizable(false);
        setTitle("tank war");
        // 设置可见
        setVisible(true);
        this.addKeyListener(new MyKeyListener());
        // 添加窗口监听事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // 解决坦克移动时抖动问题
    // 双缓冲
    // 用两块画布渲染
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public void paint(Graphics g) {
        myTank.paint(g);
        // 如果用for(Bullet b : bullets) 会有问题，为什么这种遍历就不行，只能用下面这种朴素的遍历
        // 因为上面这种方式使用内部迭代器迭代，不允许遍历过程中其他地方进行删除
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }
    }


    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
         boolean bR = false;
        boolean bD = false;

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU  = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU  = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {

            myTank.setMoving(bL || bU || bR || bD);

            if(bL) myTank.setDir(Dir.LEFT);
            if(bU) myTank.setDir(Dir.UP);
            if(bR) myTank.setDir(Dir.RIGHT);
            if(bD) myTank.setDir(Dir.DOWN);
        }
    }

}
