package com.robbiedaves.samples.liftsim;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: Robin Davies
 * Date  : 10/09/2016
 */
public class FloorTest {

    @Test
    public void testCreateFloor() {
        Floor floor = new Floor(3);
        assertNotNull(floor);
        assertEquals(floor.floorNumber.intValue(), 3);
        assertEquals(floor.downButtonSelected, false);
        assertEquals(floor.upButtonSelected, false);
    }

}