package com.robbiedaves.samples.liftsim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Author: Robin Davies
 * Date  : 10/09/2016
 */
public class LiftSimApp extends JFrame {

    private JLabel statusBar;
    private JMenuBar menuBar;
    private JPopupMenu popupMenu;

    private LiftSimulator liftSimulator;

    public LiftSimApp(){
        liftSimulator = new LiftSimulator();
        initUI();
        liftSimulator.startSimulator();
    }

    private void initUI(){
        setTitle("Lift Simulator");
        createMenuBar();
        createPopupMenu();
        setJMenuBar(menuBar);

        LiftSimModelUI modelUI = new LiftSimModelUI(liftSimulator);
        JScrollPane scrollModelUI = new JScrollPane(modelUI);
        //add(modelUI);
        add(scrollModelUI);

        statusBar = new JLabel("Ready");
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        add(statusBar, BorderLayout.SOUTH);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        revalidate();
        repaint();
    }

    private void createMenuBar(){
        menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit Application");
        exitMenuItem.addActionListener((ActionEvent event) -> System.exit(0));
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                InputEvent.CTRL_MASK));
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // View Menu
        JMenu viewMenu = new JMenu("View");
        viewMenu.setMnemonic(KeyEvent.VK_V);
        JCheckBoxMenuItem statusBarMenuItem = new JCheckBoxMenuItem("Show Status Bar");
        statusBarMenuItem.setMnemonic(KeyEvent.VK_S);
        statusBarMenuItem.setDisplayedMnemonicIndex(5);
        statusBarMenuItem.setSelected(true);
        statusBarMenuItem.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                statusBar.setVisible(true);
            } else {
                statusBar.setVisible(false);
            }
        });
        viewMenu.add(statusBarMenuItem);

        // About Menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        JMenuItem aboutMenuItem = new JMenuItem("About");
        helpMenu.add(aboutMenuItem);

        // Menu Bar
        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(helpMenu);
    }

    private void createPopupMenu(){
        popupMenu = new JPopupMenu();
        JMenuItem quitSimMenuItem = new JMenuItem("Exit Simulator");
        quitSimMenuItem.addActionListener((ActionEvent e) -> System.exit(0));
        popupMenu.add(quitSimMenuItem);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

    }



    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            LiftSimApp sim = new LiftSimApp();
            sim.setVisible(true);
        });
    }

}
