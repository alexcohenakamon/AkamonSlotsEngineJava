package com.akamon.slots.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/23/14
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class WinCombination {

    protected ArrayList<SymbolWinElement> symbolWinElements;
    protected ArrayList<Trigger> triggers;

    protected Integer basePay;
    protected int sortPriority;
    protected String name;
    protected int id;
    protected PayMultiplicationType payMultiplicationType;

    public WinCombination(String name, Integer basePay, int sortPriority, PayMultiplicationType payMultiplicationType, ArrayList<SymbolWinElement> symbolWinElements, ArrayList<Trigger> triggers) {
        this.name = name;
        this.basePay = basePay;
        this.sortPriority = sortPriority;
        this.payMultiplicationType = payMultiplicationType;
        this.symbolWinElements = symbolWinElements;
        this.triggers = triggers;
        this.id = 0;
    }

    public WinCombination(String name, Integer basePay, int sortPriority, PayMultiplicationType payMultiplicationType, ArrayList<SymbolWinElement> symbolWinElements, ArrayList<Trigger> triggers,int id) {
        this(name,basePay,sortPriority,payMultiplicationType,symbolWinElements,triggers);
        this.id = id;
    }

    public ArrayList<SymbolWinElement> getSymbolWinElements() {
        return symbolWinElements;
    }

    public void setSymbolWinElements(ArrayList<SymbolWinElement> symbolWinElements) {
        this.symbolWinElements = symbolWinElements;
    }

    public ArrayList<Trigger> getTriggers() {
        return triggers;
    }

    public void setTriggers(ArrayList<Trigger> triggers) {
        this.triggers = triggers;
    }

    public Integer getBasePay() {
        return basePay;
    }

    public void setBasePay(Integer basePay) {
        this.basePay = basePay;
    }

    public int getSortPriority() {
        return sortPriority;
    }

    public void setSortPriority(int sortPriority) {
        this.sortPriority = sortPriority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PayMultiplicationType getPayMultiplicationType() {
        return payMultiplicationType;
    }

    public void setPayMultiplicationType(PayMultiplicationType payMultiplicationType) {
        this.payMultiplicationType = payMultiplicationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
