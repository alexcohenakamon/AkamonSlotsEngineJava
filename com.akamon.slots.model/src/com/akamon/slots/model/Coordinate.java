package com.akamon.slots.model;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/7/14
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Coordinate {

    protected int x;
    protected int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
