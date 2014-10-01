package com.akamon.slots.gamelogic;

import com.akamon.slots.model.Trigger;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 10/2/14
 * Time: 12:15 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ITriggerMergeHandler {

    public Trigger getMergedTrigger(Trigger a, Trigger b);
}
