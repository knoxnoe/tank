package com.noe.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        while(true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
