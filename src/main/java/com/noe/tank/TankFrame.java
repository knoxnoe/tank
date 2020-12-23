package com.noe.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
public class TankFrame extends Frame {

    public TankFrame() {
        setSize(800, 600);
        // 设置是否可放缩窗口
        //setResizable(false);
        // 设置可见
        setVisible(true);

        // 添加窗口监听事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        g.fillRect(200,200, 50,50);
    }

}
