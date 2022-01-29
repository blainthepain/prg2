/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.prg.woche08.FallingBalls2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author sandro
 */
public class CinemaGUI {

    private static final int FRAME_WIDTH = 600;
    static final int FRAME_HEIGHT = 600;
    private static final String VERSION = "Falling Balls Version 2.0";

    private JFrame frame;
    private JLabel statusBar;
    private Container contentPane;

    public CinemaGUI() {

        this.makeFrame();

    }

    private void makeFrame() {

        frame = new JFrame(VERSION);

        frame.setLayout(new BorderLayout());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.makeMenu();
        this.makeContentPane();
        frame.setVisible(true);

    }

    private void makeMenu() {

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        /**
         * Menu adding
         */
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        /**
         * Menu Item adding File
         */
        JMenuItem newMenuItem = new JMenuItem("New");
        fileMenu.add(newMenuItem);
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newWindow();
            }
        });

        JMenuItem openMenuItem = new JMenuItem("Open");
        fileMenu.add(openMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });

        /**
         * Menu Item adding Help
         */
        JMenuItem aboutMenuItem = new JMenuItem("About");
        helpMenu.add(aboutMenuItem);
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAbout();
            }
        });
    }

    private void makeContentPane() {

        contentPane = frame.getContentPane();

        statusBar = new JLabel(VERSION);
        contentPane.add(statusBar, BorderLayout.SOUTH);

    }

    public void addScreen(Screen screen) {

        contentPane.add(screen, BorderLayout.CENTER);

    }

    private void showAbout() {

        JOptionPane about = new JOptionPane();
        about.showMessageDialog(frame, "Copyright 2015 Sandro Arnold\n",
                "About Falling Balls", INFORMATION_MESSAGE);
    }

    public void setStatus(String text) {

        statusBar.setText(text);
    }

    private void closeWindow() {

        System.exit(0);
        
    }

    private void newWindow() {

        new Cinema();        

    }
}
