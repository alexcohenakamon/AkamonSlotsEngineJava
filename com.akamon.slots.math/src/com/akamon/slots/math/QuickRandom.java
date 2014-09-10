package com.akamon.slots.math;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/7/14
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuickRandom implements IRandom {

    private Random rng;

    public QuickRandom() {
       this.rng = new Random();

    }
    @Override
    public int nextInt(int range) {
        return rng.nextInt(range);
    }

    @Override
    public double nextDouble(double range) {
        return rng.nextDouble()*range;
    }
}
