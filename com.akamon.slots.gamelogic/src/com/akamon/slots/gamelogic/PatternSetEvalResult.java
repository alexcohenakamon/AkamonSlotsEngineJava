package com.akamon.slots.gamelogic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 10/2/14
 * Time: 12:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class PatternSetEvalResult {
    protected int win;
    protected Integer evaluationPatternSetId;
    protected List<PatternEvalResult> patternEvalResults;

    public PatternSetEvalResult(int win, Integer evaluationPatternSetId, List<PatternEvalResult> patternEvalResults) {
        this.win = win;
        this.evaluationPatternSetId = evaluationPatternSetId;
        this.patternEvalResults = patternEvalResults;
    }

    public PatternSetEvalResult(Integer evaluationPatternSetId) {
        this(0,evaluationPatternSetId,new ArrayList<PatternEvalResult>());
    }

    public void addPatternEvalResult(PatternEvalResult patternEvalResult) {
        this.win += patternEvalResult.Win;
        this.patternEvalResults.add(patternEvalResult);
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public Integer getEvaluationPatternSetId() {
        return evaluationPatternSetId;
    }

    public void setEvaluationPatternSetId(Integer evaluationPatternSetId) {
        this.evaluationPatternSetId = evaluationPatternSetId;
    }

    public List<PatternEvalResult> getPatternEvalResults() {
        return patternEvalResults;
    }

    public void setPatternEvalResults(List<PatternEvalResult> patternEvalResults) {
        this.patternEvalResults = patternEvalResults;
    }
}
