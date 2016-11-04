package com.dreamteam.pvviter;

import org.junit.Test;


import utils.StringConvertion;

import static org.junit.Assert.assertTrue;

/**
 * Created by Admin on 04/11/2016.
 */

public class StringConvertionTest {

    @Test
    public void timeToStringTest() {
        double time = 0.5; //56 min in hour
        assertTrue(StringConvertion.timeToString(time).equals("30 min"));
        time = 1.2;
        assertTrue(StringConvertion.timeToString(time).equals("1 h 12 min"));
        time = 0.83; //49.8 min have to return  50 min
        assertTrue(StringConvertion.timeToString(time).equals("50 min"));
        time = 0.79; //47.4 min function have to return 48 min
        assertTrue(StringConvertion.timeToString(time).equals("48 min"));
    }

    @Test
    public void lengthToStringTest() {
        double length=0.750;
        assertTrue(StringConvertion.lengthToString(length).equals("750 m"));
        length=1.51;
        assertTrue(StringConvertion.lengthToString(length).equals("1 km 510 m"));
    }


}
