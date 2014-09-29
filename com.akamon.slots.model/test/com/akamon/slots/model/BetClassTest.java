package com.akamon.slots.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/27/14
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class BetClassTest {

    @Test
    public void TestMatchesAllBetMultipliers()
    {
        BetClass betClass = new BetClass(100);

        for (int testBetMult = 1; testBetMult <= 1000; testBetMult++)
        {
            Bet testBet = new Bet(100, testBetMult);
            Assert.assertTrue(betClass.doesBetMatchBetClass(testBet));
        }
    }

    @Test
    public void TestNotMatchWithAllBetMultipliers()
    {
        BetClass betClass = new BetClass(100);

        for (int testBetMult = 1; testBetMult <= 1000; testBetMult++)
        {
            Bet testBet = new Bet(50, testBetMult);
            Assert.assertFalse(betClass.doesBetMatchBetClass(testBet));
        }
    }

    @Test
    public void TestMatchSeveralMultipliers()
    {
        HashSet<Integer> betMults = new HashSet<Integer>();
        betMults.add(1);
        betMults.add(2);
        betMults.add(3);

        BetClass betClass = new BetClass(100, betMults);
        for (int testBetMult = 1; testBetMult <= 3; testBetMult++)
        {
            Bet testBet = new Bet(100, testBetMult);
            Assert.assertTrue(betClass.doesBetMatchBetClass(testBet));
        }
        for (int testBetMult = 4; testBetMult <= 1000; testBetMult++)
        {
            Bet testBet = new Bet(100, testBetMult);
            Assert.assertFalse(betClass.doesBetMatchBetClass(testBet));
        }
    }

    @Test
    public void TestNotMatchOnDifferentBaseBets()
    {
        HashSet<Integer> betMults = new HashSet<Integer>();
        betMults.add(1);
        betMults.add(2);
        betMults.add(3);

        BetClass betClass = new BetClass(100, betMults);
        for (int testBetMult = 1; testBetMult <= 3; testBetMult++)
        {
            Bet testBet = new Bet(100, testBetMult);
            Assert.assertTrue(betClass.doesBetMatchBetClass(testBet));
        }
        for (int testBetMult = 4; testBetMult <= 100; testBetMult++)
        {
            for (int testBaseBet = 1; testBaseBet <= 200; testBaseBet++)
            {
                if (testBaseBet != 100)
                {
                    Bet testBet = new Bet(testBaseBet, testBetMult);
                    Assert.assertFalse(betClass.doesBetMatchBetClass(testBet));
                }
            }
        }
    }
}
