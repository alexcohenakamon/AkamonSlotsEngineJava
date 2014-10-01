package com.akamon.slots.gamelogic;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 10/2/14
 * Time: 12:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReelGridEvalResult {
    protected int win;
    protected Integer reelGridId;
    protected ArrayList<PatternSetEvalResult> patternSetEvalResults;

    public ReelGridEvalResult(int win, Integer reelGridId, ArrayList<PatternSetEvalResult> patternSetEvalResults) {
        this.win = win;
        this.reelGridId = reelGridId;
        this.patternSetEvalResults = patternSetEvalResults;
    }

    public ReelGridEvalResult(Integer reelGridId) {
        this(0,reelGridId,new ArrayList<PatternSetEvalResult>());
    }

    public void addPatternSetEvalResult(PatternSetEvalResult patternSetEvalResult) {
        this.win += patternSetEvalResult.win;
        this.patternSetEvalResults.add(patternSetEvalResult);
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public Integer getReelGridId() {
        return reelGridId;
    }

    public void setReelGridId(Integer reelGridId) {
        this.reelGridId = reelGridId;
    }

    public ArrayList<PatternSetEvalResult> getPatternSetEvalResults() {
        return patternSetEvalResults;
    }

    public void setPatternSetEvalResults(ArrayList<PatternSetEvalResult> patternSetEvalResults) {
        this.patternSetEvalResults = patternSetEvalResults;
    }
}
