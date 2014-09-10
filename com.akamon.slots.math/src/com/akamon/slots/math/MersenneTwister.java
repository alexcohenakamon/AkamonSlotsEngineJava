package com.akamon.slots.math;

import org.apache.commons.math3.random.*;
/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/7/14
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class MersenneTwister implements IRandom {

    private org.apache.commons.math3.random.MersenneTwister rng;

    public MersenneTwister() {
        this.rng = new org.apache.commons.math3.random.MersenneTwister();
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
