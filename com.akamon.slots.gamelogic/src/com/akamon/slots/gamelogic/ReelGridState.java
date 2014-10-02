package com.akamon.slots.gamelogic;

import com.akamon.slots.model.Coordinate;
import com.akamon.slots.model.NaturalSymbol;
import com.akamon.slots.model.Reel;
import com.akamon.slots.model.ReelGridModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 10/2/14
 * Time: 12:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReelGridState implements IPopulationMap {

    protected ReelGridModel reelGridModel;
    protected ArrayList<Integer> currentRangeValues;
    protected ArrayList<Integer> currentStopIndexes;
    protected NaturalSymbol[][] currentSymbolPopulation;


    public ReelGridState(ReelGridModel reelGridModel) {
        this.reelGridModel = reelGridModel;
        this.currentRangeValues = new ArrayList<Integer>();
        this.currentStopIndexes = new ArrayList<Integer>();
        for(int i = 0; i < reelGridModel.getReels().size(); i++) {
            currentRangeValues.add(0);
            currentStopIndexes.add(0);
        }
        this.currentSymbolPopulation = new NaturalSymbol[reelGridModel.getMaxXCoordinate()+1][reelGridModel.getMaxYCoordinate()+1];
    }

    @Override
    public Integer getPopulationMapId() {
        return reelGridModel.getId();
    }

    @Override
    public void populate(List<Integer> rangeValues) {
        for(int i = 0; i < reelGridModel.getReels().size(); i++) {
            currentRangeValues.set(i,rangeValues.get(i));
        }

        for(Coordinate coordinate : reelGridModel.getAllValidCoordinates()) {
            Reel reel = reelGridModel.getReelForCoordinate(coordinate);
            int stopIndex = reel.getIndexForRange(rangeValues.get(reel.getReelIndex()));
            currentStopIndexes.set(reel.getReelIndex(),stopIndex);
            currentSymbolPopulation[coordinate.getX()][coordinate.getY()] = reel.getItemByCircularIndex(stopIndex + reelGridModel.getRngOffsetForCoordinate(coordinate));
        }
    }

    @Override
    public NaturalSymbol get(int x, int y) {
        return currentSymbolPopulation[x][y];
    }

    @Override
    public NaturalSymbol get(Coordinate coordinate) {
        return get(coordinate.getX(),coordinate.getY());
    }

    @Override
    public Set<Coordinate> getAllValidCoordinates() {
        return reelGridModel.getAllValidCoordinates();
    }
}
