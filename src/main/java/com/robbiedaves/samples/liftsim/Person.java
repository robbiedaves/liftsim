package com.robbiedaves.samples.liftsim;

/**
 * Author: Robin Davies
 * Date  : 06/09/2016
 */
public class Person {

    Integer id;
    String name;
    Floor currentFloor;
    Floor destination;

    public Person(Integer id, String name, Floor currentFloor, Floor destination) {
        this.id = id;
        this.name = name;
        this.currentFloor = currentFloor;
        this.destination = destination;
    }



}
