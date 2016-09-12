package com.robbiedaves.samples.liftsim;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Author: Robin Davies
 * Date  : 11/09/2016
 */
public class LiftSimModelUI extends JPanel
                        implements Runnable {

    private final int INITIAL_X = 40;
    private final int INITIAL_Y = 40;
    private final int DELAY = 25;
    private final int GAP_BETWEEN_LIFTS = 40;

    private Thread animator;
    private LiftSimulator liftSimulator;
    private List<LiftUI> liftUIArrayList = new ArrayList<>();
    private List<FloorUI> floorUIArrayList = new ArrayList<>();
    private int minY, maxY;


    public LiftSimModelUI(LiftSimulator simulator){
        liftSimulator = simulator;
        initLiftSim();
    }

    public void initLiftSim(){

        minY = INITIAL_Y;
        // TODO change 60 to a field to indicate the Y size of a floor
        maxY = minY + 60 * liftSimulator.floors.size();

        int maxWidth = 0;
        // Create the Lift UI array
        for (int i = 0; i < liftSimulator.lifts.size(); i++){
            int x = INITIAL_X + (GAP_BETWEEN_LIFTS * i);
            liftUIArrayList.add(new LiftUI(liftSimulator.lifts.get(i), x, minY, maxY ));
            maxWidth = (maxWidth < x) ? x : maxWidth;
        }

        // Create the floors
        int maxFloorPos = 0;
        for (int i = 0; i < liftSimulator.floors.size(); i++){
            // Convert the floor pos to a relative value between lowest and top floor
            float relativeFloorPos = (float)(liftSimulator.floors.get(i).floorNumber) / (liftSimulator.floors.size() -1);
            int floorPos = Math.round(maxY - ((maxY - minY) * relativeFloorPos));
            // TODO instead of hard code 80 we should hold the width of the lift as a field
            floorUIArrayList.add(new FloorUI(liftSimulator.floors.get(i), floorPos + 40, INITIAL_X + (40 * liftSimulator.lifts.size())));
            maxFloorPos = (maxFloorPos < floorPos + 40) ? floorPos + 40 : maxFloorPos;

        }
        setPreferredSize(new Dimension(maxWidth + 100, maxFloorPos + 40));
        setDoubleBuffered(true);


    }

    @Override
    public void addNotify(){
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }

    private void drawSimulator(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        for (LiftUI l : liftUIArrayList){
            l.drawLift(g2d);
        }
        for (FloorUI f : floorUIArrayList){
            f.drawFloor(g2d);
        }
        Toolkit.getDefaultToolkit().sync();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawSimulator(g);

    }

    @Override
    public void run(){
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();

        while (true){
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 2) {
                sleep = 2;
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e){
                LiftLog.log("Interrupted: " + e.getMessage());
            }
            beforeTime = System.currentTimeMillis();
        }
    }


}
