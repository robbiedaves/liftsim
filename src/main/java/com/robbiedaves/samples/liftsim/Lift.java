package com.robbiedaves.samples.liftsim;

import java.util.ArrayList;

/**
 * Author: Robin Davies
 * Date  : 06/09/2016
 */
public class Lift implements Runnable{

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
    ArrayList<Person> passengers = new ArrayList<>();
    ArrayList<Floor> selectedFloors = new ArrayList<>();
    Floor currentFloor;
    Floor nextDestination;
    float floorPos;
    final int _lowestFloor;
    final int _topFloor;

    public Lift(String name, Integer capacity, Floor currentFloor, int lowestFloor, int topFloor) {
        this.liftName = name;
        this.capacity = capacity;
        this.status = Status.UP;
        this.doorsOpen = false;
        this.currentFloor = currentFloor;
        this.nextDestination = null;
        _lowestFloor = lowestFloor;
        _topFloor = topFloor;
        floorPos = lowestFloor;
    }

    public float getFloorPos(){
        return floorPos;
    }

    private void moveLift(){
        while (true) {
            if (floorPos >= _topFloor) {
                status = Status.DOWN;
            }
            if (floorPos <= _lowestFloor){
                status = Status.UP;
            }

            if (status == Status.UP) {
                floorPos += 0.002;
            }
            if (status == Status.DOWN) {
                floorPos -= 0.002;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        moveLift();
    }

}
