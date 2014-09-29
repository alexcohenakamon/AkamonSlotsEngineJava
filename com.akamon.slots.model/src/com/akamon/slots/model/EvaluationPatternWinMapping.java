package com.akamon.slots.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/23/14
 * Time: 10:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class EvaluationPatternWinMapping {

    protected EvaluationPatternSet evaluationPatternSet;
    protected ArrayList<WinCombinationSet> winCombinationSets;

    public EvaluationPatternWinMapping(EvaluationPatternSet evaluationPatternSet, ArrayList<WinCombinationSet> winCombinationSets) {
        this.evaluationPatternSet = evaluationPatternSet;
        this.winCombinationSets = winCombinationSets;
    }

    public EvaluationPatternWinMapping() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void setEvaluationPatternSet(EvaluationPatternSet evaluationPatternSet) {
        this.evaluationPatternSet = evaluationPatternSet;
    }

    public void setWinCombinationSets(ArrayList<WinCombinationSet> winCombinationSets) {
        this.winCombinationSets = winCombinationSets;
    }

    public EvaluationPatternSet getEvaluationPatternSet() {
        return evaluationPatternSet;
    }

    public ArrayList<WinCombinationSet> getWinCombinationSets() {
        return winCombinationSets;
    }
}
