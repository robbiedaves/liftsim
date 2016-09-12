package com.robbiedaves.samples.liftsim;

import java.awt.*;

/**
 * Author: Robin Davies
 * Date  : 11/09/2016
 */
public class LiftUI {

    private Lift _lift;
    private int _x;
    private int _minY;
    private int _maxY;

    public LiftUI(Lift lift, int x, int minY, int maxY){
        _lift = lift;
        _x = x;
        _minY = minY;
        _maxY = maxY;
    }

    public void drawLift(Graphics2D g2d){
        int floorYPos = getCurrentYPos();
        LiftLog.log("Drawing lift: " + _x + " " + floorYPos + " " + 20 + 40);

        g2d.setColor(new Color(241, 98, 69));
        g2d.drawString("Y:" + floorYPos, _x, _minY - 30);
        //g2d.drawString("F:" + liftPos, _x, _minY);

        g2d.setColor(new Color(212, 212, 212));
        g2d.drawRect(_x, floorYPos, 20, 40);
    }

    private int getCurrentYPos() {
        // Convert the floor pos to a relative value between lowest and top floor
        float relativeFloorPos = (_lift.getFloorPos() - _lift._lowestFloor) / _lift._topFloor;
        LiftLog.log("Relative Floor Pos: " + relativeFloorPos);
        int result = Math.round(_maxY - ((_maxY - _minY) * relativeFloorPos));
        LiftLog.log("Current Y Pos : " + result);
        // TODO change 40 to a field that holds the lift height
        return result; // + 40;
    }



}
