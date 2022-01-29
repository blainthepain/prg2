/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.prg.woche08.FallingBalls2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author sandro
 */
public final class Ball {

    private int radius;
    private int position_x;
    private int position_y;
    private Color color;
    private double speed;

    private int red;
    private int green;
    private int blue;

    public Ball() {

        setRadius();
        setColor();
        setPosition();
        generateSpeed();

    }

    public Ball(int position_x, int position_y) {

        setRadius();
        setColor();
        generateSpeed();
        this.position_x = position_x;
        this.position_y = position_y;

    }

    private void setRadius() {

        this.radius = ((int) (Math.random() * 30) + 20);

    }

    private void setColor() {

        setRGB();
        this.color = new Color(this.red, this.green, this.blue);

    }

    private void setPosition() {

        this.position_x = (int) (Math.random() * 600);
        this.position_y = (int) (Math.random() * 400);
    }

    public void move() {

        this.position_y += this.speed;

    }

    private void generateSpeed() {

        this.speed = (Math.random() * 3 + 1);

    }

    private void setRGB() {

        this.red = generateRGBValue();
        this.green = generateRGBValue();
        this.blue = generateRGBValue();
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(this.color);
        g2d.fillOval(this.position_x, this.position_y, this.radius, this.radius);

    }

    public int getPositionY() {

        return this.position_y;
    }

    private int generateRGBValue() {

        return (int) (Math.random() * 255);

    }

    public void makeBrighter() {

        if (this.red < 255) {
            this.red++;
        }

        if (this.green < 255) {
            this.green++;
        }

        if (this.blue < 255) {
            this.blue++;
        }

        this.color = new Color(this.red, this.green, this.blue);

    }

}
