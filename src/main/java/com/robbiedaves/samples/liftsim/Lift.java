package com.robbiedaves.samples.liftsim;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Robin Davies
 * Date  : 06/09/2016
 */
public class Lift {

    public enum Status {
        UP (1), DOWN (-1), STOPPED (0);

        private final Integer statusNum;
        Status(Integer i) {
            statusNum = i;
        }
    }

    String liftName;
    Status status;
    boolean doorsOpen;
    Integer capacity;
    ArrayList<Person> passengers = new ArrayList<Person>();
    ArrayList<Floor> selectedFloors = new ArrayList<Floor>();
    Floor currentFloor;
    Floor nextDestination;

    public Lift(String name, Integer capacity, Floor currentFloor) {
        this.liftName = name;
        this.capacity = capacity;
        this.status = Status.STOPPED;
        this.doorsOpen = false;
        this.currentFloor = currentFloor;
        this.nextDestination = null;
    }

}
