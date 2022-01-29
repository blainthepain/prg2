/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.prg.woche08.FallingBalls2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author sandro
 */
public class Screen extends JPanel {

    private List<Ball> balls;

    public Screen(List<Ball> balls) {
        super();
        this.setBackground(Color.white);
        this.balls=balls;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        synchronized (balls) {
            for (Ball ball : balls) {
                ball.paint(g);
            }
        }
    }
}
