package com.akamon.slots.xmlmodel;

import com.akamon.slots.model.*;
import com.akamon.slots.model.WinCombination;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/30/14
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameConfigLoaderTest {

    @Test
    public void TestParseSymbolSetContainsAllNaturalSymbols() throws SlotModelException {
        XmlGameConfigLoader gameConfigLoader = new XmlGameConfigLoader();
        SymbolSet xmlSymbolSet = Mock.GenerateMockXmlSymbolSet();
        com.akamon.slots.model.SymbolSet modelSymbolSet = gameConfigLoader.ParseSymbolSet(xmlSymbolSet);

        Assert.assertNotNull(modelSymbolSet.getNaturalSymbolForName("WILD1"));
        Assert.assertNotNull(modelSymbolSet.getNaturalSymbolForName("WILD2"));
        for(int i = 1; i <= 7; i++)
        {
            Assert.assertNotNull(modelSymbolSet.getNaturalSymbolForName("S" + i));
        }
    }

    @Test
    public void TestParseSymbolSetContainsAllSymbolClasses() throws SlotModelException {
        XmlGameConfigLoader gameConfigLoader = new XmlGameConfigLoader();
        SymbolSet xmlSymbolSet = Mock.GenerateMockXmlSymbolSet();
        com.akamon.slots.model.SymbolSet modelSymbolSet = gameConfigLoader.ParseSymbolSet(xmlSymbolSet);

        for (int i = 1; i <= 7; i++)
        {
            Assert.assertNotNull(modelSymbolSet.getSymbolForName("W" + 1));
            boolean exceptionHit = false;
            try
            {
                modelSymbolSet.getNaturalSymbolForName("W" + 1);
            }
            catch (com.akamon.slots.model.SlotModelException e)
            {
                exceptionHit = true;
            }
            Assert.assertTrue(exceptionHit);
        }
    }

    @Test
    public void TestDefaultSubstitutionScheme() throws SlotModelException {
        XmlGameConfigLoader gameConfigLoader = new XmlGameConfigLoader();
        SymbolSet xmlSymbolSet = Mock.GenerateMockXmlSymbolSet();
        com.akamon.slots.model.SymbolSet modelSymbolSet = gameConfigLoader.ParseSymbolSet(xmlSymbolSet);

        for (int i = 1; i <= 7; i++)
        {
            com.akamon.slots.model.NaturalSymbol wild1 = modelSymbolSet.getNaturalSymbolForName("WILD1");
            com.akamon.slots.model.NaturalSymbol wild2 = modelSymbolSet.getNaturalSymbolForName("WILD2");
            com.akamon.slots.model.NaturalSymbol naturalSymbol = modelSymbolSet.getNaturalSymbolForName("S" + i);

            com.akamon.slots.model.Symbol includeSymbol = modelSymbolSet.getSymbolForName("W" + i);
            com.akamon.slots.model.Symbol excludeSymbol = modelSymbolSet.getSymbolForName("X" + i);

            Assert.assertTrue(includeSymbol.isMatch(wild1));
            Assert.assertFalse(includeSymbol.isMatch(wild2));
            Assert.assertTrue(includeSymbol.isMatch(naturalSymbol));

            Assert.assertFalse(excludeSymbol.isMatch(wild1));
            Assert.assertFalse(excludeSymbol.isMatch(naturalSymbol));
        }
    }

    @Test
    public void TestParseReelGridAttributes() throws SlotModelException {
        XmlGameConfigLoader loader = new XmlGameConfigLoader();
        com.akamon.slots.model.GameConfig modelGameConfig = new com.akamon.slots.model.GameConfig();
        SymbolSet mockXmlSymbolSet = Mock.GenerateMockXmlSymbolSet();
        modelGameConfig.addSymbolSet(loader.ParseSymbolSet(mockXmlSymbolSet));
        ReelGrid xmlReelGrid = Mock.GenerateMockXmlReelGrid("BaseGameGrid");
        com.akamon.slots.model.ReelGridModel modelReelGrid = loader.ParseReelGridModel(xmlReelGrid, modelGameConfig);

        Assert.assertEquals(5, modelReelGrid.getReels().size());
        Assert.assertEquals(4, modelReelGrid.getMaxXCoordinate());
        Assert.assertEquals(null, modelReelGrid.getId());
        Assert.assertEquals(2, modelReelGrid.getMaxYCoordinate());
        Assert.assertEquals("BaseGameGrid", modelReelGrid.getName());
    }

    @Test
    public void TestReelGridParsedReelsCorrectly() throws SlotModelException {
        XmlGameConfigLoader loader = new XmlGameConfigLoader();
        com.akamon.slots.model.GameConfig modelGameConfig = new com.akamon.slots.model.GameConfig();
        SymbolSet mockXmlSymbolSet = Mock.GenerateMockXmlSymbolSet();
        modelGameConfig.addSymbolSet(loader.ParseSymbolSet(mockXmlSymbolSet));
        ReelGrid xmlReelGrid = Mock.GenerateMockXmlReelGrid("BaseGameGrid");
        com.akamon.slots.model.ReelGridModel modelReelGrid = loader.ParseReelGridModel(xmlReelGrid, modelGameConfig);

        for (int i = 0; i < 5; i++)
        {
            com.akamon.slots.model.Reel modelReel = modelReelGrid.getReels().get(i);
            Reel xmlReel = xmlReelGrid.getReel().get(i);

            Assert.assertEquals(xmlReel.name, modelReel.getName());
            Assert.assertEquals(xmlReel.getItem().size(), modelReel.size());

            for (int j = 0; j < xmlReel.getItem().size(); j++)
            {
                Assert.assertEquals(xmlReel.getItem().get(j).value, modelReel.getByIndex(j).getName());
                Assert.assertEquals(xmlReel.getItem().get(j).weight, modelReel.getWeightForIndex(j));
            }
        }
    }

    @Test
    public void TestParseEvalPatternsCorrectly() throws SlotModelException {
        XmlGameConfigLoader loader = new XmlGameConfigLoader();
        GameConfigData xmlGameConfig = new GameConfigData();
        ArrayList<EvaluationPattern> xmlEvalPatterns = Mock.GenerateMockEvaluationPatterns(false);
        xmlGameConfig.evaluationPatternList = new GameConfigData.EvaluationPatternList();
        xmlGameConfig.evaluationPatternList.evaluationPattern = xmlEvalPatterns;

        com.akamon.slots.model.GameConfig modelGameConfig = new com.akamon.slots.model.GameConfig();
        loader.ParseEvaluationPatterns(xmlGameConfig, modelGameConfig);

        for(EvaluationPattern xmlEvalPattern : xmlEvalPatterns)
        {
            com.akamon.slots.model.EvaluationPattern modelEvalPattern = modelGameConfig.getEvaluationPattern(xmlEvalPattern.name);
            Assert.assertEquals(xmlEvalPattern.name, modelEvalPattern.getName());
            Assert.assertEquals(xmlEvalPattern.getCoord().size(), modelEvalPattern.getOrderedCoordinates().size());

            for (int i = 0; i < xmlEvalPattern.coord.size(); i++)
            {
                Assert.assertEquals(xmlEvalPattern.getCoord().get(i).x, modelEvalPattern.getOrderedCoordinates().get(i).getX());
                Assert.assertEquals(xmlEvalPattern.getCoord().get(i).y, modelEvalPattern.getOrderedCoordinates().get(i).getY());
            }

            if (xmlEvalPattern.evaluationType.equals("Payline"))
                Assert.assertEquals(com.akamon.slots.model.EvaluationType.Payline, modelEvalPattern.getEvaluationType());
            else if (xmlEvalPattern.evaluationType.equals("ScatterAny"))
                Assert.assertEquals(com.akamon.slots.model.EvaluationType.ScatterAny, modelEvalPattern.getEvaluationType());
            else if (xmlEvalPattern.evaluationType.equals("Ways"))
                Assert.assertEquals(com.akamon.slots.model.EvaluationType.Ways, modelEvalPattern.getEvaluationType());
            else
                Assert.fail();
        }
    }

    @Test(expected = com.akamon.slots.model.SlotModelException.class)
    public void TestDuplicatePaylinesCausesException() throws SlotModelException {
        XmlGameConfigLoader loader = new XmlGameConfigLoader();
        GameConfigData xmlGameConfig = new GameConfigData();
        ArrayList<EvaluationPattern> xmlEvalPatterns = Mock.GenerateMockEvaluationPatterns(true);
        xmlGameConfig.evaluationPatternList = new GameConfigData.EvaluationPatternList();
        xmlGameConfig.evaluationPatternList.evaluationPattern = xmlEvalPatterns;

        com.akamon.slots.model.GameConfig modelGameConfig = new com.akamon.slots.model.GameConfig();
        loader.ParseEvaluationPatterns(xmlGameConfig, modelGameConfig);
    }

    @Test
    public void TestParseSequentialWinCombinationLR() throws SlotModelException {
        com.akamon.slots.model.GameConfig modelGameConfig = Mock.GenerateModelGameConfig();

        com.akamon.slots.model.WinCombinationSet modelWinCombinationSet = modelGameConfig.getWinCombinationSet("LinePaysLR");

        Assert.assertEquals("LinePaysLR", modelWinCombinationSet.getName());
        Assert.assertEquals(28, modelWinCombinationSet.getWinCombinations().size());

        HashMap<String, com.akamon.slots.model.WinCombination> winCombinationsByName = new HashMap<String, WinCombination>();
        for (int i = 0; i < modelWinCombinationSet.getWinCombinations().size(); i++)
        {
            winCombinationsByName.put(modelWinCombinationSet.getWinCombinations().get(i).getName(), modelWinCombinationSet.getWinCombinations().get(i));
        }
        for (int j = 0; j < 7; j++)
        {
            String symbolName = "W" + (j + 1);
            for (int symCount = 5; symCount >= 2; symCount--)
            {
                String expectedName = symCount + " " + symbolName + " line LR";
                com.akamon.slots.model.WinCombination winCombination = winCombinationsByName.get(expectedName);
                Assert.assertEquals(winCombination.getBasePay().intValue(), winCombination.getSortPriority());
                Assert.assertEquals(com.akamon.slots.model.PayMultiplicationType.BetMult, winCombination.getPayMultiplicationType());
                Assert.assertEquals(winCombination.getSymbolWinElements().size() * 100, winCombination.getBasePay().intValue());
                Assert.assertEquals(symCount * 100, winCombination.getBasePay().intValue());
                for (int index = 0; index < symCount; index++)
                {
                    com.akamon.slots.model.SymbolWinElement element = winCombination.getSymbolWinElements().get(index);
                    Assert.assertEquals(modelGameConfig.getSymbolSet("primary").getSymbolForName(symbolName), element.getSymbol());
                    Assert.assertEquals(index, element.getIndex().intValue());
                    Assert.assertNull(element.getCount());
                }
            }
        }
    }

    @Test
    public void TestParseSequentialWinCombinationRL() throws SlotModelException {
        com.akamon.slots.model.GameConfig modelGameConfig = Mock.GenerateModelGameConfig();

        com.akamon.slots.model.WinCombinationSet modelWinCombinationSet = modelGameConfig.getWinCombinationSet("LinePaysRL");

        Assert.assertEquals("LinePaysRL", modelWinCombinationSet.getName());
        Assert.assertEquals(21, modelWinCombinationSet.getWinCombinations().size());

        HashMap<String, com.akamon.slots.model.WinCombination> winCombinationsByName = new HashMap<String, WinCombination>();
        for (int i = 0; i < modelWinCombinationSet.getWinCombinations().size(); i++)
        {
            winCombinationsByName.put(modelWinCombinationSet.getWinCombinations().get(i).getName(), modelWinCombinationSet.getWinCombinations().get(i));
        }
        for (int j = 0; j < 7; j++)
        {
            String symbolName = "W" + (j + 1);
            for (int symCount = 4; symCount >= 2; symCount--)
            {
                String expectedName = symCount + " " + symbolName + " line RL";
                com.akamon.slots.model.WinCombination winCombination = winCombinationsByName.get(expectedName);
                Assert.assertEquals(winCombination.getBasePay().intValue(), winCombination.getSortPriority());
                Assert.assertEquals(com.akamon.slots.model.PayMultiplicationType.BetMult, winCombination.getPayMultiplicationType());
                Assert.assertEquals(winCombination.getSymbolWinElements().size() * 100, winCombination.getBasePay().intValue());
                Assert.assertEquals(symCount * 100, winCombination.getBasePay().intValue());
                for (int index = 0; index < symCount; index++)
                {
                    com.akamon.slots.model.SymbolWinElement element = winCombination.getSymbolWinElements().get(index);
                    Assert.assertEquals(modelGameConfig.getSymbolSet("primary").getSymbolForName(symbolName), element.getSymbol());
                    Assert.assertEquals(4-index, element.getIndex().intValue());
                    Assert.assertNull(element.getCount());
                }
            }
        }
    }

    @Test
    public void TestCountWinCombination() throws SlotModelException {
        com.akamon.slots.model.GameConfig modelGameConfig = Mock.GenerateModelGameConfig();

        com.akamon.slots.model.WinCombinationSet modelWinCombinationSet = modelGameConfig.getWinCombinationSet("ScatterAnyPays");

        Assert.assertEquals("ScatterAnyPays", modelWinCombinationSet.getName());
        Assert.assertEquals(4, modelWinCombinationSet.getWinCombinations().size());

        HashMap<String, com.akamon.slots.model.WinCombination> winCombinationsByName = new HashMap<String, WinCombination>();
        for (int i = 0; i < modelWinCombinationSet.getWinCombinations().size(); i++)
        {
            winCombinationsByName.put(modelWinCombinationSet.getWinCombinations().get(i).getName(), modelWinCombinationSet.getWinCombinations().get(i));
        }
        String symbolName = "WILD2";
        for (int symCount = 5; symCount >= 2; symCount--)
        {
            String expectedName = symCount + " scattered " + symbolName;

            com.akamon.slots.model.WinCombination winCombination = winCombinationsByName.get(expectedName);
            if (symCount == 2)
            {
                Assert.assertEquals(winCombination.getBasePay().intValue(), winCombination.getSortPriority());
                Assert.assertEquals(com.akamon.slots.model.PayMultiplicationType.TotalBet, winCombination.getPayMultiplicationType());
                Assert.assertEquals(symCount * 100, winCombination.getBasePay().intValue());
            }
            else
            {
                Assert.assertNull(winCombination.getBasePay());
                Assert.assertEquals(com.akamon.slots.model.PayMultiplicationType.None, winCombination.getPayMultiplicationType());
                Assert.assertEquals(symCount * 100, winCombination.getSortPriority());
            }

            Assert.assertEquals(1, winCombination.getSymbolWinElements().size());
            com.akamon.slots.model.SymbolWinElement element = winCombination.getSymbolWinElements().get(0);
            Assert.assertEquals(modelGameConfig.getSymbolSet("primary").getSymbolForName(symbolName), element.getSymbol());
            Assert.assertEquals(symCount, element.getCount().intValue());
            Assert.assertNull(element.getIndex());
        }
    }

    @Test
    public void TestParseTriggers() throws SlotModelException {
        com.akamon.slots.model.GameConfig modelGameConfig = Mock.GenerateModelGameConfig();

        com.akamon.slots.model.WinCombinationSet modelWinCombinationSet = modelGameConfig.getWinCombinationSet("ScatterAnyPays");

        for (int i = 0; i < modelWinCombinationSet.getWinCombinations().size(); i++)
        {
            com.akamon.slots.model.WinCombination winCombination = modelWinCombinationSet.getWinCombinations().get(i);
            int symbolCount = winCombination.getSymbolWinElements().get(0).getCount().intValue();
            List<com.akamon.slots.model.Trigger> triggers = winCombination.getTriggers();
            if (symbolCount == 2)
            {
                Assert.assertNull(triggers);
            }
            else
            {
                Assert.assertEquals(2, triggers.size());
                Assert.assertEquals("FreeSpins", triggers.get(0).getName());
                Assert.assertEquals(2,triggers.get(0).getArguments().size());
                Assert.assertEquals((10 * (symbolCount - 2)) + "", triggers.get(0).getArguments().get("freespins"));
                Assert.assertEquals((symbolCount - 2)+"", triggers.get(0).getArguments().get("wild"));
                Assert.assertEquals("progressive", triggers.get(1).getName());
                Assert.assertEquals(0, triggers.get(1).getArguments().size());
            }
        }
    }

    @Test
    public void TestParseBetClassWithAll() throws SlotModelException {
        BetClass xmlBetClass = new BetClass();
        xmlBetClass.basebet = 40;
        xmlBetClass.betMultList = "all";

       XmlGameConfigLoader loader = new XmlGameConfigLoader();
        com.akamon.slots.model.BetClass modelBetClass = loader.ParseBetClass(xmlBetClass);

        Assert.assertEquals(1, modelBetClass.getBetMultipliers().size());
        Assert.assertTrue(modelBetClass.getBetMultipliers().contains(com.akamon.slots.model.BetClass.ALL_BET_MULTIPLIERS));
        Assert.assertEquals(xmlBetClass.basebet, modelBetClass.getBaseBet());
    }

    @Test
    public void TestParseBetClassWithItemizedBets() throws SlotModelException {
        BetClass xmlBetClass = new BetClass();
        xmlBetClass.basebet = 40;
        xmlBetClass.betMultList = "1,2,3,4,5,6,7,8,9,10";
        XmlGameConfigLoader loader = new XmlGameConfigLoader();
        com.akamon.slots.model.BetClass modelBetClass = loader.ParseBetClass(xmlBetClass);

        Assert.assertEquals(10, modelBetClass.getBetMultipliers().size());
        for (int i = 1; i <= 10; i++ )
            Assert.assertTrue(modelBetClass.getBetMultipliers().contains(i));
        Assert.assertEquals(xmlBetClass.basebet, modelBetClass.getBaseBet());
    }

    @Test
    public void TestParseBetClassWithSingleBetMult() throws SlotModelException {
        BetClass xmlBetClass = new BetClass();
        xmlBetClass.basebet = 40;
        xmlBetClass.betMultList = "10";
        XmlGameConfigLoader loader = new XmlGameConfigLoader();
        com.akamon.slots.model.BetClass modelBetClass = loader.ParseBetClass(xmlBetClass);

        Assert.assertEquals(1, modelBetClass.getBetMultipliers().size());

        Assert.assertTrue(modelBetClass.getBetMultipliers().contains(10));
        Assert.assertEquals(xmlBetClass.basebet, modelBetClass.getBaseBet());
    }

    @Test
    public void TestParseBetEvaluationMapping() throws SlotModelException {
        com.akamon.slots.model.GameConfig modelGameConfig = Mock.GenerateModelGameConfig();

        com.akamon.slots.model.BetEvaluationMap baseBetEvalMap = modelGameConfig.getBetEvaluationMap("BaseGameBetEvalMap");
        com.akamon.slots.model.BetEvaluationMap freeSpinsBetEvalMap = modelGameConfig.getBetEvaluationMap("FreeSpinsBetEvalMap");

        Assert.assertEquals(2, baseBetEvalMap.getBetEvaluationPairings().size());
        Assert.assertEquals(3, baseBetEvalMap.getBetEvaluationPairings().get(0).getBetClass().getBaseBet());
        Assert.assertEquals(5, baseBetEvalMap.getBetEvaluationPairings().get(1).getBetClass().getBaseBet());

        Assert.assertTrue(baseBetEvalMap.getBetEvaluationPairings().get(0).getBetClass().getBetMultipliers().contains(com.akamon.slots.model.BetClass.ALL_BET_MULTIPLIERS));
        Assert.assertTrue(baseBetEvalMap.getBetEvaluationPairings().get(1).getBetClass().getBetMultipliers().contains(com.akamon.slots.model.BetClass.ALL_BET_MULTIPLIERS));

        Assert.assertEquals(1, baseBetEvalMap.getBetEvaluationPairings().get(0).getReelGridEvaluationMapping().size());
        Assert.assertTrue(baseBetEvalMap.getBetEvaluationPairings().get(0).getReelGridEvaluationMapping().containsKey(modelGameConfig.getReelGridModel("BaseGameGrid")));

        List<com.akamon.slots.model.EvaluationPatternWinMapping> baseEvalPatternWinMappings0 = baseBetEvalMap.getBetEvaluationPairings().get(0).getReelGridEvaluationMapping().get(modelGameConfig.getReelGridModel("BaseGameGrid"));
        Assert.assertEquals(2, baseEvalPatternWinMappings0.size());
        Assert.assertSame(modelGameConfig.getEvaluationPatternSet("Lines"), baseEvalPatternWinMappings0.get(0).getEvaluationPatternSet());
        Assert.assertSame(modelGameConfig.getWinCombinationSet("LinePaysLR"), baseEvalPatternWinMappings0.get(0).getWinCombinationSets().get(0));
        Assert.assertSame(modelGameConfig.getWinCombinationSet("LinePaysRL"), baseEvalPatternWinMappings0.get(0).getWinCombinationSets().get(1));
        Assert.assertEquals(2, baseEvalPatternWinMappings0.get(0).getWinCombinationSets().size());

        Assert.assertSame(modelGameConfig.getEvaluationPatternSet("Scatter"), baseEvalPatternWinMappings0.get(1).getEvaluationPatternSet());
        Assert.assertSame(modelGameConfig.getWinCombinationSet("ScatterAnyPays"), baseEvalPatternWinMappings0.get(1).getWinCombinationSets().get(0));
        Assert.assertEquals(1, baseEvalPatternWinMappings0.get(1).getWinCombinationSets().size());

        List<com.akamon.slots.model.EvaluationPatternWinMapping> baseEvalPatternWinMappings1 = baseBetEvalMap.getBetEvaluationPairings().get(1).getReelGridEvaluationMapping().get(modelGameConfig.getReelGridModel("BaseGameGrid"));
        Assert.assertEquals(2, baseEvalPatternWinMappings1.size());
        Assert.assertSame(modelGameConfig.getEvaluationPatternSet("Lines"), baseEvalPatternWinMappings1.get(0).getEvaluationPatternSet());
        Assert.assertSame(modelGameConfig.getWinCombinationSet("LinePaysLR"), baseEvalPatternWinMappings1.get(0).getWinCombinationSets().get(0));
        Assert.assertSame(modelGameConfig.getWinCombinationSet("LinePaysRL"), baseEvalPatternWinMappings1.get(0).getWinCombinationSets().get(1));
        Assert.assertEquals(2, baseEvalPatternWinMappings1.get(0).getWinCombinationSets().size());

        Assert.assertSame(modelGameConfig.getEvaluationPatternSet("Scatter"), baseEvalPatternWinMappings1.get(1).getEvaluationPatternSet());
        Assert.assertSame(modelGameConfig.getWinCombinationSet("ScatterAnyPays"), baseEvalPatternWinMappings1.get(1).getWinCombinationSets().get(0));
        Assert.assertEquals(1, baseEvalPatternWinMappings1.get(1).getWinCombinationSets().size());

        List<com.akamon.slots.model.EvaluationPatternWinMapping> freeSpinsEvalPatternWinMappings0 = freeSpinsBetEvalMap.getBetEvaluationPairings().get(0).getReelGridEvaluationMapping().get(modelGameConfig.getReelGridModel("FreeSpinsGrid"));
        Assert.assertEquals(1, freeSpinsEvalPatternWinMappings0.size());
        Assert.assertSame(modelGameConfig.getEvaluationPatternSet("Lines"), freeSpinsEvalPatternWinMappings0.get(0).getEvaluationPatternSet());
        Assert.assertSame(modelGameConfig.getWinCombinationSet("LinePaysLR"), freeSpinsEvalPatternWinMappings0.get(0).getWinCombinationSets().get(0));
        Assert.assertSame(modelGameConfig.getWinCombinationSet("LinePaysRL"), freeSpinsEvalPatternWinMappings0.get(0).getWinCombinationSets().get(1));
        Assert.assertEquals(2, freeSpinsEvalPatternWinMappings0.get(0).getWinCombinationSets().size());

        List<com.akamon.slots.model.EvaluationPatternWinMapping> freeSpinsEvalPatternWinMappings1 = freeSpinsBetEvalMap.getBetEvaluationPairings().get(1).getReelGridEvaluationMapping().get(modelGameConfig.getReelGridModel("FreeSpinsGrid"));
        Assert.assertEquals(2, freeSpinsEvalPatternWinMappings1.size());
        Assert.assertSame(modelGameConfig.getEvaluationPatternSet("Lines"), freeSpinsEvalPatternWinMappings1.get(0).getEvaluationPatternSet());
        Assert.assertSame(modelGameConfig.getWinCombinationSet("LinePaysLR"), freeSpinsEvalPatternWinMappings1.get(0).getWinCombinationSets().get(0));
        Assert.assertSame(modelGameConfig.getWinCombinationSet("LinePaysRL"), freeSpinsEvalPatternWinMappings1.get(0).getWinCombinationSets().get(1));
        Assert.assertEquals(2, freeSpinsEvalPatternWinMappings1.get(0).getWinCombinationSets().size());

        Assert.assertSame(modelGameConfig.getEvaluationPatternSet("Ways"), freeSpinsEvalPatternWinMappings1.get(1).getEvaluationPatternSet());
        Assert.assertSame(modelGameConfig.getWinCombinationSet("LinePaysLR"), freeSpinsEvalPatternWinMappings1.get(1).getWinCombinationSets().get(0));
        Assert.assertEquals(1, freeSpinsEvalPatternWinMappings1.get(1).getWinCombinationSets().size());

    }
}
