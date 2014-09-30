package com.akamon.slots.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/23/14
 * Time: 9:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class EvaluationPatternSet {

    protected ArrayList<EvaluationPattern> evaluationPatterns;
    protected String name;
    protected Integer id;

    public EvaluationPatternSet(String name) {
        this.name = name;
        this.evaluationPatterns = new ArrayList<EvaluationPattern>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<EvaluationPattern> getEvaluationPatterns() {
        return evaluationPatterns;
    }

    public Integer getId() {
        return id;
    }
}
