package com.akamon.slots.gamelogic;

import com.akamon.slots.model.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 10/3/14
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class EvaluationModel {
    public GameRoundResult evaluateGameRoundResult(Bet bet, BetEvaluationMap map, IGameState gameState, boolean collectCoordinates) throws SlotModelException, GameLogicException {
        GameRoundResult gameRoundResult = null;

        HashMap<ReelGridModel,ArrayList<EvaluationPatternWinMapping>> betEvaluationKvp = map.getEvaluationMappingForBet(bet);
        for(ReelGridModel reelGridModel : betEvaluationKvp.keySet())
        {
            ReelGridEvalResult reelGridResult = evaluateReelGridEvalResult(bet, gameState.getPopulationStateById(reelGridModel.getId()), betEvaluationKvp.get(reelGridModel), collectCoordinates);
            if (reelGridResult != null)
            {
                if (gameRoundResult == null)
                    gameRoundResult = new GameRoundResult();

                gameRoundResult.addReelGridResult(reelGridResult);
            }
        }

        return gameRoundResult;
    }

    public ReelGridEvalResult evaluateReelGridEvalResult(Bet bet, IPopulationMap populationMap, ArrayList<EvaluationPatternWinMapping> evaluationPatternWinMappings, boolean collectCoordinates) throws GameLogicException {
        ReelGridEvalResult reelGridEvalResult = null;
        for (EvaluationPatternWinMapping evalPatternMapping : evaluationPatternWinMappings)
        {
            PatternSetEvalResult patternSetEvalResult = evaluatePatternSetEvalResult(bet, populationMap, evalPatternMapping, collectCoordinates);
            if (patternSetEvalResult != null)
            {
                if (reelGridEvalResult == null)
                    reelGridEvalResult = new ReelGridEvalResult(populationMap.getPopulationMapId());

                reelGridEvalResult.addPatternSetEvalResult(patternSetEvalResult);

            }
        }

        return reelGridEvalResult;
    }

    public PatternSetEvalResult evaluatePatternSetEvalResult(Bet bet, IPopulationMap populationMap, EvaluationPatternWinMapping evalPatternMapping, boolean collectCoordinates) throws GameLogicException {
        PatternSetEvalResult patternSetEvalResult = null;
        for (EvaluationPattern evalPattern : evalPatternMapping.getEvaluationPatternSet().getEvaluationPatterns())
        {
            PatternEvalResult patternEvalResult = evaluatePatternEvalResult(bet, populationMap, evalPattern, evalPatternMapping.getWinCombinationSets(), collectCoordinates);
            if (patternEvalResult != null)
            {
                if (patternSetEvalResult == null)
                {
                    patternSetEvalResult = new PatternSetEvalResult(evalPatternMapping.getEvaluationPatternSet().getId());
                }
                patternSetEvalResult.addPatternEvalResult(patternEvalResult);
            }
        }
        return patternSetEvalResult;
    }

    public PatternEvalResult evaluatePatternEvalResult(Bet bet, IPopulationMap populationMap, EvaluationPattern evalPattern, ArrayList<WinCombinationSet> winCombinationSets, boolean collectCoordinates) throws GameLogicException {
        PatternEvalResult patternEvalResult = null;

        for (WinCombinationSet winCombinationSet : winCombinationSets)
        {
            WinResult winResult = null;
            if (evalPattern.getEvaluationType() == EvaluationType.Payline)
            {
                winResult = evaluateLineWinResult(bet, populationMap, evalPattern, winCombinationSet, collectCoordinates);
            }
            else if (evalPattern.getEvaluationType() == EvaluationType.ScatterAny)
            {
                winResult = evaluateScatterAnyWinResult(bet, populationMap, evalPattern, winCombinationSet, collectCoordinates);
            }
            else if (evalPattern.getEvaluationType() == EvaluationType.Ways)
            {
                winResult = evaluateWaysWinResult(bet, populationMap, evalPattern, winCombinationSet, collectCoordinates);
            }
            else
            {
                throw new GameLogicException("Unsupported evaluation type: " + evalPattern.getEvaluationType().toString());
            }
            if (winResult != null)
            {
                if (patternEvalResult == null)
                {
                    patternEvalResult = new PatternEvalResult(evalPattern.getId());
                }
                patternEvalResult.addWinResult(winResult);
            }
        }

        return patternEvalResult;
    }

    public WinResult evaluateWaysWinResult(Bet bet, IPopulationMap reelGridState, EvaluationPattern evalPattern, WinCombinationSet winCombinationSet, boolean collectCoordinates) {
       throw new UnsupportedOperationException("Not implemented yet");
    }

    public WinResult evaluateScatterAnyWinResult(Bet bet, IPopulationMap populationMap, EvaluationPattern evalPattern, WinCombinationSet winCombinationSet, boolean collectCoordinates) throws GameLogicException {
        WinResult winResult = null;
        List<Coordinate> coords = null;

        for (WinCombination winCombination : winCombinationSet.getWinCombinations())
        {
            int count = 0;
            SymbolWinElement symWinElement = winCombination.getSymbolWinElements().get(0);
            for (Coordinate coord : populationMap.getAllValidCoordinates())
            {
                NaturalSymbol natSymbol = populationMap.get(coord);
                boolean isMatch = symWinElement.getSymbol().isMatch(natSymbol);
                if(isMatch)
                {
                    count++;
                }
            }
            if (count == symWinElement.getCount())
            {
                winResult = new WinResult(winCombination, 1, bet);
                if (collectCoordinates)
                {
                    coords = new ArrayList<Coordinate>();
                    for (Coordinate coord : populationMap.getAllValidCoordinates())
                    {
                        if (symWinElement.getSymbol().isMatch(populationMap.get(coord)))
                        {
                            coords.add(coord);
                        }
                    }
                    winResult.WinningCoordinates = coords;
                }
                break;
            }
        }

        return winResult;
    }

    public WinResult evaluateLineWinResult(Bet bet, IPopulationMap populationMap, EvaluationPattern evalPattern, WinCombinationSet winCombinationSet, boolean collectCoordinates) throws GameLogicException {
        WinResult winResult = null;
        List<Coordinate> coords = null;

        for (WinCombination winCombination : winCombinationSet.getWinCombinations())
        {
            int hits = getLineHits(populationMap, evalPattern, winCombination);
            if (hits != 0)
            {
                winResult = new WinResult(winCombination, hits, bet);

                if (collectCoordinates)
                {
                    coords = new ArrayList<Coordinate>();
                    for (SymbolWinElement symWinElement : winCombination.getSymbolWinElements())
                    {
                        Coordinate coord = evalPattern.getOrderedCoordinates().get(symWinElement.getIndex());
                        coords.add(coord);
                    }
                    winResult.WinningCoordinates = coords;
                }

                break;
            }
        }

        return winResult;
    }

    public int getLineHits(IPopulationMap populationMap, EvaluationPattern evalPattern, WinCombination winCombination) {
        int hits = 1;

        for (int i = 0; i < winCombination.getSymbolWinElements().size(); i++)
        {
            SymbolWinElement symWinElement = winCombination.getSymbolWinElements().get(i);
            NaturalSymbol symObserved = populationMap.get(evalPattern.getOrderedCoordinates().get(symWinElement.getIndex()));
            if (!symWinElement.getSymbol().isMatch(symObserved))
            {
                hits = 0;
                break;
            }
        }

        return hits;
    }
}
