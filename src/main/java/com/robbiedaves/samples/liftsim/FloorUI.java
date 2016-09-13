package com.robbiedaves.samples.liftsim;

import java.awt.*;

/**
 * Author: Robin Davies
 * Date  : 11/09/2016
 */
public class FloorUI {

    private Floor _floor;
    private int _height;
    private int _width;

    public FloorUI(Floor floor, int height, int width) {
        _floor = floor;
        _height = height;
        _width = width;
    }

    public void drawFloor(Graphics2D g2d){
        LiftLog.log("Drawing floor: " + _floor.floorNumber);
        g2d.setColor(new Color(241, 98, 69));
        g2d.drawString(_floor.floorNumber.toString(), 1, _height);
        g2d.drawLine(1, _height, _width, _height);
    }

}