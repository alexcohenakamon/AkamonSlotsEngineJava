package com.akamon.slots.model;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/7/14
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class BetClass {

    public static final int ALL_BET_MULTIPLIERS = Integer.MIN_VALUE;

    private int baseBet;
    private HashSet<Integer> betMultipliers;

    public BetClass(int baseBet, HashSet<Integer> betMultipliers) {
        this.baseBet = baseBet;
        this.betMultipliers = betMultipliers;
    }

    public BetClass(int baseBet) {
        this.baseBet = baseBet;
        this.betMultipliers = new HashSet<Integer>();
        this.betMultipliers.add(ALL_BET_MULTIPLIERS);
    }

    public boolean doesBetMatchBetClass(Bet bet) {
        if(bet.baseBet == this.baseBet) {
            if(this.betMultipliers.contains(ALL_BET_MULTIPLIERS) || betMultipliers.contains(bet.betMultiplier))
                return true;
            else
                return false;
        }
        else
            return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BetClass)) return false;

        BetClass betClass = (BetClass) o;

        if (baseBet != betClass.baseBet) return false;
        if (!betMultipliers.equals(betClass.betMultipliers)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = baseBet;
        result = 31 * result + betMultipliers.hashCode();
        return result;
    }
}
