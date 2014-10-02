package com.akamon.slots.gamelogic;

import com.akamon.slots.math.IRandom;
import com.akamon.slots.model.Bet;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 10/3/14
 * Time: 12:34 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IGameLogicPlayer<T extends IGameState<?>, U extends IGameRoundParameters> {

    boolean isSimulationMode();
    void setSimulationMode(boolean isSimulationMode);
    IRandom getRNG();
    void setRNG(IRandom rng);
    GameRoundResult nextRoundResult(T gameState,U parameters);
    List<Integer> generateNextRngRanges(T gameState, U parameters);
}
