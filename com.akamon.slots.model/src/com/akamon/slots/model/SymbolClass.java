package com.akamon.slots.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/8/14
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class SymbolClass extends Symbol {

    protected ArrayList<NaturalSymbol> componentSymbols;
    protected boolean isExcludeSymbol;

    public SymbolClass() {

    }

    protected SymbolClass(String name,long bitMaskValue,int id, SymbolSet symbolSet) {
        super(name,bitMaskValue,id,symbolSet);
        this.componentSymbols = new ArrayList<NaturalSymbol>();
    }

    @Override
    public boolean isMatch(Symbol lessInclusive) {
        return super.isMatch(lessInclusive)^isExcludeSymbol;
    }

    public void addComponentSymbol(NaturalSymbol symbol) {
        componentSymbols.add(symbol);
        bitMaskValue = bitMaskValue | symbol.bitMaskValue;
    }

    @Override
    public String toString() {
        return "SymbolClass{" +
                "componentSymbols=" + componentSymbols +
                ", isExcludeSymbol=" + isExcludeSymbol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SymbolClass)) return false;
        if (!super.equals(o)) return false;

        SymbolClass that = (SymbolClass) o;

        if (isExcludeSymbol != that.isExcludeSymbol) return false;
        if (componentSymbols != null ? !componentSymbols.equals(that.componentSymbols) : that.componentSymbols != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (componentSymbols != null ? componentSymbols.hashCode() : 0);
        result = 31 * result + (isExcludeSymbol ? 1 : 0);
        return result;
    }
}
