package com.akamon.slots.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/23/14
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class WinCombinationSet {
    protected String name;
    protected Integer id;
    protected ArrayList<WinCombination> winCombinations;

    public WinCombinationSet(String name) {
        this.name = name;
        this.winCombinations = new ArrayList<WinCombination>();
    }

    public WinCombinationSet(String name,Collection<WinCombination> winCombinationsCollection) throws SlotModelException {
        this(name);
        HashSet<String> winCombinationNames = new HashSet<String>();

        for(WinCombination winCombination : winCombinationsCollection) {
            if(winCombinationNames.contains(winCombination.name)) {
                throw new SlotModelException("Duplicate win combination names: " + winCombination.name);
            }
            this.winCombinations.add(winCombination);
            winCombinationNames.add(winCombination.name);
        }

        for(int i = 0; i < winCombinations.size()-1; i++) {
            for(int j = i+1; j < winCombinations.size(); j++) {
                if(winCombinations.get(i).sortPriority < winCombinations.get(j).sortPriority) {
                    WinCombination tempI = winCombinations.get(i);
                    WinCombination tempJ = winCombinations.get(j);
                    winCombinations.set(i,tempJ);
                    winCombinations.set(j,tempI);
                }
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWinCombinations(ArrayList<WinCombination> winCombinations) {
        this.winCombinations = winCombinations;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public ArrayList<WinCombination> getWinCombinations() {
        return winCombinations;
    }
}
