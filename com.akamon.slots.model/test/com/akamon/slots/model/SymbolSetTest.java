package com.akamon.slots.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/27/14
 * Time: 12:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class SymbolSetTest {


    @Test
    public void testAddNaturalSymbol() throws SlotModelException {
        SymbolSet target = GenerateMockSymbolSet();
        for(int i = 1; i <= 7; i++) {
            String natSymName = "S"+ i;
            Assert.assertNotNull(target.getSymbolForName(natSymName));
            Assert.assertNotNull(target.getNaturalSymbolForName(natSymName));
            Assert.assertSame(target.getSymbolForName(natSymName), target.getNaturalSymbolForName(natSymName));
        }
    }

    @Test
    public void testNaturalSymbolMatchesSelf() throws SlotModelException {
        SymbolSet symbolSet = GenerateMockSymbolSet();
        for (int i = 1; i <= 7; i++)
        {
            NaturalSymbol natSymbol = symbolSet.getNaturalSymbolForName("S" + i);
            Assert.assertTrue(natSymbol.isMatch(natSymbol));
        }
    }

    @Test
    public void testPrimarySubscheme() throws SlotModelException {
        SymbolSet symbolSet = GenerateMockSymbolSet();
        for (int i = 1; i <= 7; i++)
        {
            Symbol includeSymbol = symbolSet.getSymbolForName("W" + i);
            Symbol excludeSymbol = symbolSet.getSymbolForName("X" + i);
            NaturalSymbol wild1 = symbolSet.getNaturalSymbolForName("WILD1");
            NaturalSymbol wild2 = symbolSet.getNaturalSymbolForName("WILD2");
            NaturalSymbol s_i = symbolSet.getNaturalSymbolForName("S" + i);

            Assert.assertTrue(includeSymbol.name, includeSymbol.isMatch(wild1));
            Assert.assertTrue(includeSymbol.isMatch(s_i));
            Assert.assertFalse(includeSymbol.isMatch(wild2));
            Assert.assertFalse(excludeSymbol.isMatch(wild1));
            Assert.assertFalse(excludeSymbol.isMatch(s_i));
            Assert.assertTrue(excludeSymbol.isMatch(wild2));
            for (int j = 1; j <= 7; j++)
            {
                if (j != i)
                {
                    NaturalSymbol s_j = symbolSet.getNaturalSymbolForName("S" + j);
                    Assert.assertFalse(includeSymbol.isMatch(s_j));
                    Assert.assertTrue(excludeSymbol.isMatch(s_j));
                }
            }
        }
    }

    @Test
    public void testSecondaryScheme() throws SlotModelException {
        SymbolSet symbolSet = GenerateMockSymbolSet();
        symbolSet.setSubstitutionScheme("Secondary");
        for (int i = 1; i <= 7; i++)
        {
            Symbol symbol = symbolSet.getSymbolForName("W" + i);
            NaturalSymbol wild1 = symbolSet.getNaturalSymbolForName("WILD1");
            NaturalSymbol wild2 = symbolSet.getNaturalSymbolForName("WILD2");
            NaturalSymbol s_i = symbolSet.getNaturalSymbolForName("S" + i);

            Assert.assertTrue(symbol.isMatch(wild1));
            Assert.assertTrue(symbol.isMatch(s_i));
            Assert.assertTrue(symbol.isMatch(wild2));
            for (int j = 1; j <= 7; j++)
            {
                if (j != i)
                {
                    NaturalSymbol s_j = symbolSet.getNaturalSymbolForName("S" + j);
                    Assert.assertFalse(symbol.isMatch(s_j));
                }
            }
        }
    }

    @Test
    public void testSetToDefaultSubstitution() throws SlotModelException {
        SymbolSet symbolSet = GenerateMockSymbolSet();
        symbolSet.setSubstitutionScheme("Secondary");
        symbolSet.setSubstitutionSchemeToDefault();
        for (int i = 1; i <= 7; i++)
        {
            Symbol symbol = symbolSet.getSymbolForName("W" + i);
            NaturalSymbol wild1 = symbolSet.getNaturalSymbolForName("WILD1");
            NaturalSymbol wild2 = symbolSet.getNaturalSymbolForName("WILD2");
            NaturalSymbol s_i = symbolSet.getNaturalSymbolForName("S" + i);

            Assert.assertTrue(symbol.isMatch(wild1));
            Assert.assertTrue(symbol.isMatch(s_i));
            Assert.assertFalse(symbol.isMatch(wild2));
            for (int j = 1; j <= 7; j++)
            {
                if (j != i)
                {
                    NaturalSymbol s_j = symbolSet.getNaturalSymbolForName("S" + j);
                    Assert.assertFalse(symbol.isMatch(s_j));
                }
            }
        }
    }

    public static SymbolSet GenerateMockSymbolSet() throws SlotModelException {
        SymbolSet symbolSet = new SymbolSet("Mock Symbol set");
        symbolSet.addNaturalSymbol("WILD1");
        symbolSet.addNaturalSymbol("WILD2");
        for (int i = 1; i <= 7; i++)
        {
            symbolSet.addNaturalSymbol("S" + i);
        }
        for (int i = 1; i <= 7; i++)
        {
            symbolSet.addSymbolClassName("W" + i);
            symbolSet.addSymbolClassName("X" + i, true);
        }

        symbolSet.createSubstitutionScheme("Primary", true);
        symbolSet.createSubstitutionScheme("Secondary", false);

        for (int i = 1; i <= 7; i++)
        {
            symbolSet.addSubstitution("Primary", "W" + i, "WILD1");
            symbolSet.addSubstitution("Primary", "W" + i, "S" + i);
            symbolSet.addSubstitution("Primary", "X" + i, "WILD1");
            symbolSet.addSubstitution("Primary", "X" + i, "S" + i);

            symbolSet.addSubstitution("Secondary", "W" + i, "WILD1");
            symbolSet.addSubstitution("Secondary", "W" + i, "WILD2");
            symbolSet.addSubstitution("Secondary", "W" + i, "S" + i);
            symbolSet.addSubstitution("Secondary", "X" + i, "WILD1");
            symbolSet.addSubstitution("Secondary", "X" + i, "WILD2");
            symbolSet.addSubstitution("Secondary", "X" + i, "S" + i);
        }
        return symbolSet;
    }
}
