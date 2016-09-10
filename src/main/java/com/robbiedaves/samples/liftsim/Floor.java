package com.robbiedaves.samples.liftsim;

/**
 * Author: Robin Davies
 * Date  : 06/09/2016
 */
public class Floor {

    Integer floorNumber;
    boolean upButtonSelected;
    boolean downButtonSelected;

    public Floor(Integer floorNumber){
        this.floorNumber = floorNumber;
        this.upButtonSelected = false;
        this.downButtonSelected = false;
    }
}
