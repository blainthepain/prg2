/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.prg.woche08.FallingBalls2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author sandro
 */
public class Cinema implements MouseListener {

    private final CinemaGUI cinemaGUI;
    private final Screen screen;
    private final List<Ball> balls;

    private int ballCounter;

    public Cinema() {

        this.balls = new ArrayList<Ball>();
        this.cinemaGUI = new CinemaGUI();
        this.cinemaGUI.addScreen(this.screen = new Screen(this.balls));

        this.screen.addMouseListener(this);

        this.ballCounter = 0;
        this.generateInitialBalls();
        this.makeThread();

    }

    private void makeThread() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    synchronized (balls) {
                        Iterator<Ball> ballsIterator = balls.iterator();

                        while (ballsIterator.hasNext()) {
                            Ball ball = ballsIterator.next();

                            if (ball.getPositionY() < CinemaGUI.FRAME_HEIGHT) {
                                ball.move();
                                ball.makeBrighter();
                            } else {
                                ballsIterator.remove();
                            }
                        }
                        countBalls();
                        screen.repaint();
                    }

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        System.out.println("Unterbrechung in sleep()");
                    }

                }
            }
        }).start();
    }

    private void generateInitialBalls() {
        for (int i = 0; i < 75; i++) {
            synchronized (balls) {
                this.balls.add(new Ball());
                ballCounter++;
            }
        }

    }

    private void countBalls() {
        cinemaGUI.setStatus("Number of fallen Balls: " + this.ballCounter);
    }

    private void generateBall(MouseEvent e) {
        synchronized (balls) {
            this.balls.add(new Ball(e.getX(), e.getY()));
            ballCounter++;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        generateBall(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        generateBall(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        generateBall(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        generateBall(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        generateBall(e);
    }

    public List<Ball> getBalls() {
        return this.balls;
    }

}
