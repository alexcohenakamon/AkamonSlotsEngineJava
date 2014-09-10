package com.akamon.slots.model;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/7/14
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Symbol {

    protected String name;
    protected SymbolSet symbolSet;
    protected long bitMaskValue;
    protected int id;

    public Symbol() {

    }

    protected Symbol(String name, long bitMaskValue,int id, SymbolSet symbolSet) {
        this.name = name;
        this.bitMaskValue = bitMaskValue;
        this.id = id;
        this.symbolSet = symbolSet;
    }

    public boolean isMatch(Symbol lessInclusive) {
        return symbolSet.isMatch(this,lessInclusive);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public long getBitMaskValue() {
        return bitMaskValue;
    }

    public SymbolSet getSymbolSet() {
        return symbolSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symbol)) return false;

        Symbol symbol = (Symbol) o;

        if (bitMaskValue != symbol.bitMaskValue) return false;
        if (id != symbol.id) return false;
        if (name != null ? !name.equals(symbol.name) : symbol.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (int) (bitMaskValue ^ (bitMaskValue >>> 32));
        result = 31 * result + id;
        return result;
    }
}
