package com.akamon.slots.model;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/7/14
 * Time: 10:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bet {

    protected int baseBet;
    protected int betMultiplier;
    protected int totalBet;

    public Bet(int baseBet, int betMultiplier) {
        this.baseBet = baseBet;
        this.betMultiplier = betMultiplier;
        this.totalBet = baseBet*betMultiplier;
    }

    public int getBaseBet() {
        return baseBet;
    }

    public int getBetMultiplier() {
        return betMultiplier;
    }

    public int getTotalBet() {
        return this.totalBet;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "baseBet=" + baseBet +
                ", betMultiplier=" + betMultiplier +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bet)) return false;

        Bet bet = (Bet) o;

        if (baseBet != bet.baseBet) return false;
        if (betMultiplier != bet.betMultiplier) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = baseBet;
        result = 31 * result + betMultiplier;
        return result;
    }
}
