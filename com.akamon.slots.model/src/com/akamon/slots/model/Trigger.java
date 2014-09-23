package com.akamon.slots.model;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/23/14
 * Time: 10:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Trigger {

    protected HashMap<String,String> arguments;
    protected String name;

    public Trigger(String name) {
        this.name = name;
        this.arguments = new HashMap<String, String>();
    }

    public HashMap<String, String> getArguments() {
        return arguments;
    }

    public String getName() {
        return name;
    }
}
