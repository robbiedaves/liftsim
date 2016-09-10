package com.robbiedaves.samples.liftsim;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Author: Robin Davies
 * Date  : 06/09/2016
 */
public class LiftSimulator {

    ArrayList<Floor> floors = new ArrayList<Floor>();
    ArrayList<Lift> lifts = new ArrayList<Lift>();
    ArrayList<Person> people = new ArrayList<Person>();
    Integer maxNumberOfPeople;

    public LiftSimulator(Integer numberOfFloors, Integer numberOfLifts, Integer liftCapacity, Integer maxNumberOfPeople){

        for (int i=1; i<=numberOfFloors; i++) {
            floors.add(new Floor(i));
        }

        for (int j=1; j<=numberOfLifts; j++) {
            this.lifts.add(new Lift(String.valueOf(j), liftCapacity, floors.get(0)));
        }

        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public void start(){
        while (true){
            this.performEvent();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.printSim();
        }
    }

    public void performEvent(){
        //
    }

    public void printSim(){
        //
    }

    public static void main(String[] args) {

        // create lift simulator
        LiftSimulator liftSim = new LiftSimulator(11, 6, 15, 100);
        liftSim.start();



    }


}
