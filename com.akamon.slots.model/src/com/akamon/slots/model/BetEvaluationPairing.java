package com.akamon.slots.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/23/14
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class BetEvaluationPairing {

    protected BetClass betClass;
    protected HashMap<ReelGridModel,ArrayList<EvaluationPatternWinMapping>> reelGridEvaluationMapping;

    public BetEvaluationPairing(BetClass betClass, HashMap<ReelGridModel, ArrayList<EvaluationPatternWinMapping>> reelGridEvaluationMapping) {
        this.betClass = betClass;
        this.reelGridEvaluationMapping = reelGridEvaluationMapping;
    }

    public BetClass getBetClass() {
        return betClass;
    }

    public HashMap<ReelGridModel, ArrayList<EvaluationPatternWinMapping>> getReelGridEvaluationMapping() {
        return reelGridEvaluationMapping;
    }
}
