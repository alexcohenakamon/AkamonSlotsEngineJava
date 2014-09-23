package com.akamon.slots.model;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/23/14
 * Time: 10:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class BetEvaluationMap {

    protected String name;
    protected Integer id;
    protected ArrayList<BetEvaluationPairing> betEvaluationPairings;

    public BetEvaluationMap(String name) {
        this.name = name;
        this.betEvaluationPairings = new ArrayList<BetEvaluationPairing>();
    }

    public void addBetEvaluationPairing(BetEvaluationPairing pairing) {
        this.betEvaluationPairings.add(pairing);
    }

    public HashMap<ReelGridModel,ArrayList<EvaluationPatternWinMapping>> getEvaluationMappingForBet(Bet bet) throws SlotModelException {
        HashMap<ReelGridModel,ArrayList<EvaluationPatternWinMapping>> reelGridMappings = null;

        for(int i = 0; i < betEvaluationPairings.size(); i++) {
            if(betEvaluationPairings.get(i).betClass.doesBetMatchBetClass(bet)) {
                reelGridMappings = betEvaluationPairings.get(i).reelGridEvaluationMapping;
                break;
            }
        }
        if(reelGridMappings == null)
            throw new IndexOutOfBoundsException("No mapping found for bet " + bet.toString());

        return reelGridMappings;
    }
}
