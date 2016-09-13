package com.robbiedaves.samples.liftsim;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Robin Davies
 * Date  : 06/09/2016
 */
public class LiftSimulator {

    ArrayList<Floor> floors = new ArrayList<>();
    ArrayList<Lift> lifts = new ArrayList<>();
    ArrayList<Person> people = new ArrayList<>();
    Integer maxNumberOfPeople;

    List<Thread> liftThreads = new ArrayList<>();

    public LiftSimulator() {
        this(5, 12, 15, 100);
    }

    public LiftSimulator(Integer numberOfFloors,
                         Integer numberOfLifts,
                         Integer liftCapacity,
                         Integer maxNumberOfPeople){

        for (int i=0; i<=numberOfFloors; i++) {
            floors.add(new Floor(i));
        }

        for (int j=1; j<=numberOfLifts; j++) {
            Lift l = new Lift(String.valueOf(j), liftCapacity, floors.get(0), 0, numberOfFloors);
            lifts.add(l);
            liftThreads.add(new Thread(l, "Lift"+j));
        }

        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public void startSimulator(){
        liftThreads.forEach(Thread::start);
    }



}
