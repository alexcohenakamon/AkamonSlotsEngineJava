package com.akamon.slots.model;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/9/14
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Reel extends WeightedList<NaturalSymbol> {

    protected SymbolSet symbolSet;
    protected Integer reelIndex;

    public Reel(String name,SymbolSet symbolSet) {
        super(name);

        this.symbolSet = symbolSet;
        this.reelIndex = null;
    }


    public void addSymbolToEnd(String symbolName,int weight) throws SlotModelException {
        this.add(symbolSet.getNaturalSymbolForName(symbolName),weight);
    }

    public SymbolSet getSymbolSet() {
        return symbolSet;
    }

    public Integer getReelIndex() {
        return reelIndex;
    }

    public void setReelIndex(Integer reelIndex) {
        this.reelIndex = reelIndex;
    }
}
