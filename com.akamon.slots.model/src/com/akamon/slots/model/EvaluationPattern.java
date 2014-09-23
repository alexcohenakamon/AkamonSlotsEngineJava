package com.akamon.slots.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/23/14
 * Time: 9:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class EvaluationPattern {

    protected ArrayList<Coordinate> orderedCoordinates;
    protected String name;
    protected EvaluationType evaluationType;
    protected Integer id;

    public EvaluationPattern(String name, ArrayList<Coordinate> orderedCoordinates, EvaluationType evaluationType) {
        this.name = name;
        this.orderedCoordinates = orderedCoordinates;
        this.evaluationType = evaluationType;
    }

    public ArrayList<Coordinate> getOrderedCoordinates() {
        return orderedCoordinates;
    }

    public String getName() {
        return name;
    }

    public EvaluationType getEvaluationType() {
        return evaluationType;
    }

    public Integer getId() {
        return id;
    }
}
