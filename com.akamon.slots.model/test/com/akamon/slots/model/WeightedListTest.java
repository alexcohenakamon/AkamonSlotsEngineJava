package com.akamon.slots.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/27/14
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class WeightedListTest {

    @Test
    public void testWeightedListAttributes() {
        WeightedList<Integer> weightedList = generateMockWeightedList();
        Assert.assertEquals(10, weightedList.getTotalWeight());
        Assert.assertEquals("Name", weightedList.getName());
        Assert.assertEquals(4, weightedList.size());
    }

    @Test
    public void testGetItemByIndex() {
        WeightedList<Integer> weightedList = generateMockWeightedList();
        Assert.assertEquals(1, weightedList.getByIndex(0).intValue());
        Assert.assertEquals(2, weightedList.getByIndex(1).intValue());
        Assert.assertEquals(3, weightedList.getByIndex(2).intValue());
        Assert.assertEquals(4, weightedList.getByIndex(3).intValue());
    }

    @Test
    public void testGetItemByCircularIndex() {
        WeightedList<Integer> weightedList = generateMockWeightedList();
        Assert.assertEquals(3, weightedList.getItemByCircularIndex(-2).intValue());
        Assert.assertEquals(4, weightedList.getItemByCircularIndex(-1).intValue());
        Assert.assertEquals(1, weightedList.getItemByCircularIndex(4).intValue());
        Assert.assertEquals(2, weightedList.getItemByCircularIndex(5).intValue());
    }

    @Test
    public void testGetByRange() {
        WeightedList<Integer> weightedList = generateMockWeightedList();
        for (int range = 0; range < weightedList.getTotalWeight(); range++)
        {
            Integer value = weightedList.getByRange(range);
            Integer expectedValue = null;
            if (range == 0)
                expectedValue = 1;
            else if (range >= 1 && range < 4)
                expectedValue = 2;
            else if (range >= 4 && range < 5)
                expectedValue = 3;
            else if (range >= 5 && range < 10)
                expectedValue = 4;

            Assert.assertNotNull(expectedValue);
            Assert.assertEquals(expectedValue.intValue(), value.intValue());
        }
    }

    @Test
    public void testGetIndexByRange() {
        WeightedList<Integer> weightedList = generateMockWeightedList();
        for (int range = 0; range < weightedList.getTotalWeight(); range++)
        {
            int value = weightedList.getIndexForRange(range);
            Integer expectedValue = null;
            if (range == 0)
                expectedValue = 0;
            else if (range >= 1 && range < 4)
                expectedValue = 1;
            else if (range >= 4 && range < 5)
                expectedValue = 2;
            else if (range >= 5 && range < 10)
                expectedValue = 3;

            Assert.assertNotNull(expectedValue);
            Assert.assertEquals(expectedValue.intValue(), value);
        }
    }

    @Test
    public void testWeightByIndex() {
        WeightedList<Integer> weightedList = generateMockWeightedList();
        Assert.assertEquals(1, weightedList.getWeightForIndex(0));
        Assert.assertEquals(3, weightedList.getWeightForIndex(1));
        Assert.assertEquals(1, weightedList.getWeightForIndex(2));
        Assert.assertEquals(5, weightedList.getWeightForIndex(3));
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        WeightedList<Integer> weightedList = generateMockWeightedList();
        WeightedList<Integer> clone = (WeightedList<Integer>) weightedList.clone();

        Assert.assertEquals(weightedList.size(), clone.size());
        Assert.assertEquals(weightedList.getTotalWeight(), clone.getTotalWeight());

        for (int i = 0; i < weightedList.size(); i++)
        {
            Assert.assertEquals(weightedList.getWeightForIndex(i), clone.getWeightForIndex(i));
            Assert.assertEquals(weightedList.getByIndex(i), clone.getByIndex(i));
        }

    }

    protected WeightedList<Integer> generateMockWeightedList() {
        WeightedList<Integer> weightedList = new WeightedList<Integer>("Name");
        weightedList.add(1,1);
        weightedList.add(2,3);
        weightedList.add(3,1);
        weightedList.add(4,5);
        return weightedList;
    }
}
