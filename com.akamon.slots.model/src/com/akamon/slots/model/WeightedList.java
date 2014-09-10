package com.akamon.slots.model;

import com.akamon.slots.math.IRandom;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/9/14
 * Time: 9:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class WeightedList<T> {

    protected HashMap<Integer,Integer> indexByRange;
    protected HashMap<Integer,Integer> maxRangesByIndex;
    protected ArrayList<WeightedListItem> itemsByIndex;
    protected int totalWeight;
    protected String name;

    public WeightedList(String name) {
        this.indexByRange = new HashMap<Integer, Integer>();
        this.maxRangesByIndex = new HashMap<Integer, Integer>();
        this.itemsByIndex = new ArrayList<WeightedListItem>();
        this.totalWeight = 0;
        this.name = name;
    }

    public void add(T item, int weight) {
        itemsByIndex.add(new WeightedListItem(item,weight));
        maxRangesByIndex.put(itemsByIndex.size()-1,totalWeight+weight-1);

        for(int i = 0; i < weight; i++) {
            int rangeIndex = totalWeight;
            indexByRange.put(rangeIndex,itemsByIndex.size()-1);
            totalWeight++;
        }
    }

    public T nextItem(IRandom rng) {
        return getByRange(rng.nextInt(totalWeight));
    }

    public int getIndexForRange(int range) {
        return indexByRange.get(range);
    }

    public T getItemByCircularIndex(int index) {
        int c_index = index;
        while(c_index < 0)
            c_index += itemsByIndex.size();
        return getByIndex(c_index);
    }

    public T getByIndex(int index) {
        return itemsByIndex.get(index).item;
    }

    public T getByRange(int range) {
        return itemsByIndex.get(indexByRange.get(range)).item;
    }

    public int getWeightForIndex(int index) {
        return itemsByIndex.get(index).weight;
    }

    public int size() {
        return this.itemsByIndex.size();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        WeightedList<T> clone = new WeightedList<T>(this.name + "_clone");
        for(WeightedListItem item : this.itemsByIndex) {
            clone.add(item.item,item.weight);
        }
        return clone;
    }

    protected class WeightedListItem {
        protected T item;
        protected int weight;

        public WeightedListItem(T item, int weight) {
            this.item = item;
            this.weight = weight;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
