package com.akamon.slots.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/9/14
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReelGridModel {

    protected ArrayList<Reel> reels;
    protected String name;
    protected Integer id;
    protected int maxXCoordinate;
    protected int maxYCoordinate;
    protected Set<Coordinate> allValidCoordinates;

    protected HashMap<Coordinate,ReelOffsetPair> reelPopulationMap;
    protected HashMap<String,Reel> reelsByName;

    public ReelGridModel(String name) {
        this.name = name;
        this.reels = new ArrayList<Reel>();
        this.reelPopulationMap = new HashMap<Coordinate, ReelOffsetPair>();
        this.maxXCoordinate = 0;
        this.maxYCoordinate = 0;
        this.allValidCoordinates = new HashSet<Coordinate>();
        this.reelsByName = new HashMap<String, Reel>();
    }

    public void addReel(Reel reel) throws SlotModelException {
        if(reelsByName.containsKey(reel.name)) {
            throw new SlotModelException("Cannot add reel to reel grid " + name + ":  reel grid already contains a reel named " + reel.name);
        }
        else {
            reels.add(reel);
            reel.reelIndex = reels.size()-1;
            reelsByName.put(reel.name,reel);
        }
    }

    public Reel getReelByName(String name) {
        return reelsByName.get(name);
    }

    public Reel getReelByIndex(int index) {
        return reels.get(index);
    }

    public void setReelPopulationOffset(Coordinate coordinate,String reelName, int offset) throws SlotModelException {
        if(!reelsByName.containsKey(reelName)) {
            throw new SlotModelException("Reel grid does not contain reel with name " + reelName);
        }
        if(reelPopulationMap.containsKey(coordinate)) {
            throw new SlotModelException("Reel population mapping already contains coordinate " + coordinate.toString());
        }

        Reel reel = reelsByName.get(reelName);
        allValidCoordinates.add(coordinate);
        ReelOffsetPair offsetPair = new ReelOffsetPair(reel,offset);
        reelPopulationMap.put(coordinate,offsetPair);
        if(coordinate.x > maxXCoordinate)
            maxXCoordinate = coordinate.x;
        if(coordinate.y > maxYCoordinate)
            maxYCoordinate = coordinate.y;
    }

    public int getRngOffsetForCoordinate(Coordinate coordinate) {
        return this.reelPopulationMap.get(coordinate).rngOffset;
    }

    public int getMaxXCoordinate() {
        return maxXCoordinate;
    }

    public int getMaxYCoordinate() {
        return maxYCoordinate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Coordinate> getAllValidCoordinates() {
        return allValidCoordinates;
    }

    public Reel getReelForCoordinate(Coordinate coord) {
        return this.reelPopulationMap.get(coord).reel;
    }

    private class ReelOffsetPair {

        protected Reel reel;
        protected int rngOffset;

        private ReelOffsetPair(Reel reel, int rngOffset) {
            this.reel = reel;
            this.rngOffset = rngOffset;
        }
    }
}
