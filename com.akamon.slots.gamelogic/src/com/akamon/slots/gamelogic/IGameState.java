package com.akamon.slots.gamelogic;

import com.akamon.slots.model.Bet;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 10/1/14
 * Time: 11:42 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IGameState<T extends IGameStateFlag> {

    public T getStateFlagNextRound();
    public T setStateFlagNextRound();
    public T getBaseGameStateFlag();

    public Bet getLastPlacedMainGameBet();
    public List<GameRoundResult> getLastGameRoundResults();

    public IPopulationMap getPopulationStateByName(String name);
    public IPopulationMap getPopulationStateById(int id);

    public int getTotalWinFromCurrentGameCycle();
    public int getTotalWinFromCurrentRound();
}
