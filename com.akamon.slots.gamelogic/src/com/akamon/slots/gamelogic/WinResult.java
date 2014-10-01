package com.akamon.slots.gamelogic;

import com.akamon.slots.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 10/1/14
 * Time: 11:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class WinResult {

    protected int Win;
    protected int Hits;
    protected WinCombination WinningCombination;
    protected List<Trigger> Triggers;
    protected List<Coordinate> WinningCoordinates;

    public WinResult(int win, int hits, WinCombination winningCombination, List<Trigger> Triggers)
    {
        this.Win = win;
        this.WinningCombination = winningCombination;
        this.Triggers = Triggers;
        this.Hits = hits;
        this.WinningCoordinates = null;
    }

    public WinResult(int win, int hits, WinCombination winningCombination)
    {
        this.Win = win;
        this.WinningCombination = winningCombination;
        this.Hits = hits;
        if (winningCombination.getTriggers() != null)
        {
            this.Triggers = new ArrayList<Trigger>();
            this.Triggers.addAll(winningCombination.getTriggers());
        }
        this.WinningCoordinates = null;
    }

    public WinResult(WinCombination winningCombination, int hits, Bet betOnInitiatingGame) throws GameLogicException {
        this.WinningCombination = winningCombination;
        this.WinningCoordinates = null;
        this.Hits = hits;
        if (winningCombination.getTriggers() != null)
        {
            this.Triggers = new ArrayList<Trigger>();
            this.Triggers.addAll(winningCombination.getTriggers());
        }
        if (winningCombination.getBasePay() != null)
        {
            if (winningCombination.getPayMultiplicationType() == PayMultiplicationType.BetMult)
            {
                this.Win = winningCombination.getBasePay().intValue() * betOnInitiatingGame.getBetMultiplier() * hits;
            }
            else if (winningCombination.getPayMultiplicationType() == PayMultiplicationType.TotalBet)
            {
                this.Win = winningCombination.getBasePay() * betOnInitiatingGame.getTotalBet() * hits;
            }
            else if (winningCombination.getPayMultiplicationType() == PayMultiplicationType.None)
            {
                this.Win = winningCombination.getBasePay() * hits;
            }
            else
            {
                throw new GameLogicException("Unsupported pay multiplication type: " + winningCombination.getPayMultiplicationType());
            }
        }
        else
        {
            this.Win = 0;
        }
    }

    public int getWin() {
        return Win;
    }

    public void setWin(int win) {
        Win = win;
    }

    public int getHits() {
        return Hits;
    }

    public void setHits(int hits) {
        Hits = hits;
    }

    public WinCombination getWinningCombination() {
        return WinningCombination;
    }

    public void setWinningCombination(WinCombination winningCombination) {
        WinningCombination = winningCombination;
    }

    public List<Trigger> getTriggers() {
        return Triggers;
    }

    public void setTriggers(List<Trigger> triggers) {
        Triggers = triggers;
    }

    public List<Coordinate> getWinningCoordinates() {
        return WinningCoordinates;
    }

    public void setWinningCoordinates(List<Coordinate> winningCoordinates) {
        WinningCoordinates = winningCoordinates;
    }
}
