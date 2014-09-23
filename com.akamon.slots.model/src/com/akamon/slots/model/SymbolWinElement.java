package com.akamon.slots.model;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/23/14
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class SymbolWinElement {

    protected Symbol symbol;
    protected Integer count;
    protected Integer index;

    public SymbolWinElement(Symbol symbol, Integer index, Integer count) {
        this.symbol = symbol;
        this.index = index;
        this.count = count;
    }
}
