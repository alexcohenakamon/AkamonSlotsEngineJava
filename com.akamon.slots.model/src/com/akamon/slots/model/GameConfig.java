package com.akamon.slots.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/23/14
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameConfig {

    protected HashMap<String,SymbolSet> symbolSetsByName;
    protected HashMap<String,ReelGridModel> reelGridsByName;
    protected HashMap<String,BetEvaluationMap> betEvaluationMapsByName;
    protected HashMap<String,WinCombinationSet> winCombinationSetsByName;
    protected HashMap<String,EvaluationPattern> evaluationPatternsByName;
    protected HashMap<String,EvaluationPatternSet> evaluationPatternSetsByName;
    protected HashMap<String,WeightedList<String>> weightedListsByName;

    protected HashMap<Integer,SymbolSet> symbolSetsById;
    protected HashMap<Integer,ReelGridModel> reelGridsById;
    protected HashMap<Integer,BetEvaluationMap> betEvaluationMapsById;
    protected HashMap<Integer,WinCombinationSet> winCombinationSetsById;
    protected HashMap<Integer,EvaluationPattern> evaluationPatternsById;
    protected HashMap<Integer,EvaluationPatternSet> evaluationPatternSetsById;

    public GameConfig() {
        this.symbolSetsByName = new HashMap<String, SymbolSet>();
        this.reelGridsByName = new HashMap<String, ReelGridModel>();
        this.betEvaluationMapsByName = new HashMap<String, BetEvaluationMap>();
        this.winCombinationSetsByName = new HashMap<String, WinCombinationSet>();
        this.evaluationPatternsByName = new HashMap<String, EvaluationPattern>();
        this.evaluationPatternSetsByName = new HashMap<String, EvaluationPatternSet>();
        this.weightedListsByName = new HashMap<String, WeightedList<String>>();

        this.symbolSetsById = new HashMap<Integer, SymbolSet>();
        this.reelGridsById = new HashMap<Integer, ReelGridModel>();
        this.betEvaluationMapsById = new HashMap<Integer, BetEvaluationMap>();
        this.winCombinationSetsById = new HashMap<Integer, WinCombinationSet>();
        this.evaluationPatternsById = new HashMap<Integer, EvaluationPattern>();
        this.evaluationPatternSetsById = new HashMap<Integer, EvaluationPatternSet>();
    }

    public Set<String> getAllReelGridNames() {
        return new HashSet<String>(this.reelGridsByName.keySet());
    }

    public SymbolSet getSymbolSet(String name) {
        if(symbolSetsByName.containsKey(name)) {
            return symbolSetsByName.get(name);
        }
        else
            throw new IndexOutOfBoundsException("Game config does not contain a symbol set with name " + name);
    }

    public EvaluationPattern getEvaluationPattern(String name)
    {
        if (evaluationPatternsByName.containsKey(name))
        {
            return evaluationPatternsByName.get(name);
        }
        else
            throw new IndexOutOfBoundsException("Game config does not contain an evaluation pattern with name " + name);
    }

    public EvaluationPatternSet getEvaluationPatternSet(String name)
    {
        if (evaluationPatternSetsByName.containsKey(name))
            return evaluationPatternSetsByName.get(name);
        else
            throw new IndexOutOfBoundsException("Game config does not contain an evaluation pattern set with name " + name);
    }

    public ReelGridModel getReelGridModel(String name)
    {
        if (reelGridsByName.containsKey(name))
            return reelGridsByName.get(name);
        else
            throw new IndexOutOfBoundsException("Game config does not contain a reel grid with name " + name);
    }

    public WinCombinationSet getWinCombinationSet(String name)
    {
        if (winCombinationSetsByName.containsKey(name))
            return winCombinationSetsByName.get(name);
        else throw new IndexOutOfBoundsException("Game config does not contain a win combination set with name " + name);
    }

    public BetEvaluationMap getBetEvaluationMap(String name)
    {
        if (betEvaluationMapsByName.containsKey(name))
            return betEvaluationMapsByName.get(name);
        else throw new IndexOutOfBoundsException("Game config does not contain a bet evaluation map with name " + name);
    }

    public void addSymbolSet(SymbolSet symbolSet)
    {
        if (symbolSetsByName.containsKey(symbolSet.name))
        {
            throw new IndexOutOfBoundsException("Game config already contains a symbol set with name " + symbolSet.name);
        }
        else
        {
            symbolSetsByName.put(symbolSet.name, symbolSet);
            int incremented_id = GetNextIncrementedInt(symbolSetsById.keySet());
            symbolSet.id = incremented_id;
            symbolSetsById.put(incremented_id, symbolSet);
        }
    }

    public void addReelGridModel(ReelGridModel reelGridModel) throws SlotModelException {
        if (reelGridsByName.containsKey(reelGridModel.name))
        {
            throw new SlotModelException("Game config already contains a reel grid with name " + reelGridModel.name);
        }
        else
        {
            reelGridsByName.put(reelGridModel.name, reelGridModel);
            int id = GetNextIncrementedInt(reelGridsById.keySet());
            reelGridModel.id = id;
            reelGridsById.put(id, reelGridModel);
        }
    }

    public void addBetEvaluationMap(BetEvaluationMap betEvaluationMap) throws SlotModelException {
        if (betEvaluationMapsByName.containsKey(betEvaluationMap.name))
        {
            throw new SlotModelException("Game config already contains a bet evaluation map with name " + betEvaluationMap.name);
        }
        else
        {
            betEvaluationMapsByName.put(betEvaluationMap.name, betEvaluationMap);
            int id = GetNextIncrementedInt(betEvaluationMapsById.keySet());
            betEvaluationMap.id = id;
            betEvaluationMapsById.put(id, betEvaluationMap);
        }
    }

    public void addEvaluationPattern(EvaluationPattern evalPattern) throws SlotModelException {
        if (evaluationPatternsByName.containsKey(evalPattern.name))
        {
            throw new SlotModelException("Game config already contains an evaluation pattern with name " + evalPattern.name);
        }
        else
        {
            evaluationPatternsByName.put(evalPattern.name, evalPattern);
            int id = GetNextIncrementedInt(evaluationPatternsById.keySet());
            evalPattern.id = id;
            evaluationPatternsById.put(id, evalPattern);
        }
    }

    public void addEvaluationPatternSet(EvaluationPatternSet evalPatternSet) throws SlotModelException {
        if (evaluationPatternSetsByName.containsKey(evalPatternSet.name))
        {
            throw new SlotModelException("Game config already contains an eval pattern set with name " + evalPatternSet.name);
        }
        else
        {
            for(EvaluationPattern evalPattern : evalPatternSet.evaluationPatterns)
            {
                if (!evaluationPatternsByName.containsKey(evalPattern.name))
                {
                    throw new SlotModelException("Game config does not contain an eval pattern with name " + evalPattern.name);
                }
                else if (evaluationPatternsByName.get(evalPattern.name) != evalPattern)
                {
                    throw new SlotModelException("eval pattern with name " + evalPattern.name + " in game config does not map to same eval pattern");
                }

            }

            evaluationPatternSetsByName.put(evalPatternSet.name, evalPatternSet);
            int id = GetNextIncrementedInt(evaluationPatternSetsById.keySet());
            evalPatternSet.id = id;
            evaluationPatternSetsById.put(id, evalPatternSet);

        }
    }

    public void addWinCombinationSet(WinCombinationSet winCombinationSet) throws SlotModelException {
        if (winCombinationSetsByName.containsKey(winCombinationSet.name))
        {
            throw new SlotModelException("Game config already contains a win combination set with name " + winCombinationSet.name);
        }
        else
        {
            winCombinationSetsByName.put(winCombinationSet.name, winCombinationSet);
            int id = GetNextIncrementedInt(winCombinationSetsById.keySet());
            winCombinationSet.id = id;
            winCombinationSetsById.put(id, winCombinationSet);
        }
    }

    public void addWeightedList(WeightedList<String> weightedList) throws SlotModelException {
        if (weightedListsByName.containsKey(weightedList.name))
        {
            throw new SlotModelException("Game config already contains a weighted list with name " + weightedList.name);
        }
        else
        {
            weightedListsByName.put(weightedList.name, weightedList);

        }
    }

    private int GetNextIncrementedInt(Collection<Integer> values)
    {
        int id = 1;
        for(int value : values)
        {
            if (value >= id)
                id = value + 1;
        }
        return id;
    }
}

