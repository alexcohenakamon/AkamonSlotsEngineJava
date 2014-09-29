package com.akamon.slots.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/27/14
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReelGridModelTest {

    @Test
    public void testReelGridAttributes() throws SlotModelException {
        ReelGridModel mockReelGrid = GenerateMockDependentReelGrid();
        Assert.assertEquals(5, mockReelGrid.reels.size());
        Assert.assertEquals(4, mockReelGrid.maxXCoordinate);
        Assert.assertEquals(2, mockReelGrid.maxYCoordinate);
        Assert.assertEquals("Mock reel grid", mockReelGrid.name);

        Assert.assertEquals(15, mockReelGrid.getAllValidCoordinates().size());
        for (int x = 0; x < 5; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                Coordinate coord = new Coordinate(x, y);
                Assert.assertTrue(mockReelGrid.getAllValidCoordinates().contains(coord));
                Assert.assertEquals(y - 1, mockReelGrid.getRngOffsetForCoordinate(coord));
                Assert.assertSame(mockReelGrid.reels.get(x), mockReelGrid.getReelForCoordinate(coord));
            }
        }
    }

    public static ReelGridModel GenerateMockDependentReelGrid() throws SlotModelException {
        SymbolSet mockSymbolSet = SymbolSetTest.GenerateMockSymbolSet();
        ReelGridModel mockReelGrid = new ReelGridModel("Mock reel grid");

        for (int i = 0; i < 5; i++)
        {
            Reel mockReel = generateMockReel("R" + (i + 1), mockSymbolSet, i);
            mockReelGrid.addReel(mockReel);
        }

        for (int x = 0; x < 5; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                Coordinate coord = new Coordinate(x, y);
                int offset = y - 1;
                String reelName = "R" + (x + 1);
                mockReelGrid.setReelPopulationOffset(coord, reelName, offset);
            }
        }

        return mockReelGrid;
    }
    public static Reel generateMockReel(String name,SymbolSet symbolSet,int index) throws SlotModelException {
        Reel reel = new Reel(name, symbolSet);
        for (int i = 0; i < index + 5; i++)
        {
            reel.addSymbolToEnd("WILD1", 1);
        }
        reel.addSymbolToEnd("WILD2", 1);
        for (int i = 1; i <= 7; i++)
        {
            reel.addSymbolToEnd("S" + i, i);
        }
        return reel;
    }
}
