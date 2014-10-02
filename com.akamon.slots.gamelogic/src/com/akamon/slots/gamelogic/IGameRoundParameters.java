package com.akamon.slots.gamelogic;

import com.akamon.slots.model.Bet;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 10/3/14
 * Time: 12:40 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IGameRoundParameters {
    Bet getBet();
    List<Integer> getForcedRngResults();

}
