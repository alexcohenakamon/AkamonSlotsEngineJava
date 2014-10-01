package com.akamon.slots.gamelogic;

import com.akamon.slots.model.Coordinate;
import com.akamon.slots.model.NaturalSymbol;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 10/1/14
 * Time: 11:49 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IPopulationMap {

    public Integer getPopulationMapId();
    public void populate(List<Integer> rangeValues);
    public NaturalSymbol get(int x, int y);
    public NaturalSymbol get(Coordinate coordinate);
    public Set<Coordinate> getAllValidCoordinates();
}
