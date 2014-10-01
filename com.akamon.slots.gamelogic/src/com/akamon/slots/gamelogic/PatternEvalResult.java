package com.akamon.slots.gamelogic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 10/1/14
 * Time: 11:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class PatternEvalResult {
    protected int Win;
    protected Integer PatternId;
    protected List<WinResult> WinResults;

    public PatternEvalResult(int win, Integer patternId, List<WinResult> winResults)
    {
        this.Win = win;
        this.PatternId = patternId;
        this.WinResults = winResults;
    }

    public PatternEvalResult(Integer patternId)
    {
        this(0, patternId, new ArrayList<WinResult>());
    }

    public void addWinResult(WinResult winResult)
    {
        this.Win += winResult.Win;
        this.WinResults.add(winResult);
    }

    public int getWin() {
        return Win;
    }

    public void setWin(int win) {
        Win = win;
    }

    public List<WinResult> getWinResults() {
        return WinResults;
    }

    public void setWinResults(List<WinResult> winResults) {
        WinResults = winResults;
    }

    public Integer getPatternId() {
        return PatternId;
    }

    public void setPatternId(Integer patternId) {
        PatternId = patternId;
    }
}
