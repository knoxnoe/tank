package com.noe.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
public class TankFrame extends Frame {

    Tank myTank = new Tank(200, 200, Dir.UP);
    public TankFrame() {
        setSize(800, 600);
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

    public void paint(Graphics g) {
        System.out.println("ff");
        myTank.paint(g);
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
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(bL) myTank.setDir(Dir.LEFT);
            if(bU) myTank.setDir(Dir.UP);
            if(bR) myTank.setDir(Dir.RIGHT);
            if(bD) myTank.setDir(Dir.DOWN);
        }
    }

}
