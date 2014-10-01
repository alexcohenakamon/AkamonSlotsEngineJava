package com.akamon.slots.gamelogic;

import com.akamon.slots.model.Trigger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 10/1/14
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameRoundResult {

    protected int win;
    protected ArrayList<ReelGridEvalResult> reelGridEvalResults;
    protected ArrayList<WinResult> nonReelWinResults;

    public GameRoundResult() {
        this.win = 0;
        this.reelGridEvalResults = new ArrayList<ReelGridEvalResult>();
        this.nonReelWinResults = new ArrayList<WinResult>();
    }

    public void addReelGridResult(ReelGridEvalResult reelGridEvalResult) {
        win += reelGridEvalResult.win;
        this.reelGridEvalResults.add(reelGridEvalResult);

    }

    public void addNonReelWinResult(WinResult winResult) {
        this.nonReelWinResults.add(winResult);
        win += winResult.getWin();
    }

    public Map<String,Trigger> getAllTriggers(ITriggerMergeHandler handler) {
        HashMap<String,Trigger> triggers = null;
        if(reelGridEvalResults != null) {
            for(ReelGridEvalResult reelGridEvalResult : reelGridEvalResults) {
                for(PatternSetEvalResult patternSetEvalResult : reelGridEvalResult.patternSetEvalResults) {
                    for(PatternEvalResult patternEvalResult : patternSetEvalResult.patternEvalResults) {
                        for(WinResult winResult : patternEvalResult.WinResults) {
                            if(winResult.getTriggers() != null) {
                                if(triggers != null) {
                                    triggers = new HashMap<String, Trigger>();
                                }
                                for(Trigger trigger : winResult.Triggers) {
                                    if(triggers.containsKey(trigger.getName())) {
                                        if(handler != null) {
                                            Trigger mergedTrigger = handler.getMergedTrigger(trigger,triggers.get(trigger.getName()));
                                            triggers.put(trigger.getName(),mergedTrigger);
                                        }
                                        else {
                                            triggers.put(trigger.getName(),trigger);
                                        }
                                    }
                                    else
                                        triggers.put(trigger.getName(),trigger);
                                }
                            }
                        }
                    }
                }
            }
        }

        if(this.nonReelWinResults != null) {
            for(WinResult winResult : nonReelWinResults) {
                for(Trigger trigger : winResult.Triggers) {
                    if(triggers.containsKey(trigger.getName())) {
                        if(handler != null) {
                            Trigger mergedTrigger = handler.getMergedTrigger(trigger,triggers.get(trigger.getName()));
                            triggers.put(trigger.getName(),mergedTrigger);
                        }
                        else {
                            triggers.put(trigger.getName(),trigger);
                        }
                    }
                    else
                        triggers.put(trigger.getName(),trigger);
                }
            }
        }
        return triggers;
    }

    public void multiplyPay(int multiplier) {
        if(multiplier == 1)
            return;
        this.win *= multiplier;

        for(WinResult winResult : this.nonReelWinResults) {
            winResult.Win *= multiplier;
        }

        for(ReelGridEvalResult reelGridEvalResult : this.reelGridEvalResults) {
            reelGridEvalResult.win *= multiplier;
            for(PatternSetEvalResult patternSetEvalResult : reelGridEvalResult.patternSetEvalResults) {
                patternSetEvalResult.win *= multiplier;
                for(PatternEvalResult patternEvalResult : patternSetEvalResult.patternEvalResults) {
                    patternEvalResult.Win *= multiplier;
                    for(WinResult winResult : patternEvalResult.WinResults) {
                        winResult.Win *= multiplier;
                    }
                }
            }
        }

    }
}
