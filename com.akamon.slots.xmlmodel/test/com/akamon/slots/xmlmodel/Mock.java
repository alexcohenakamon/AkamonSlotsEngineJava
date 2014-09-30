package com.akamon.slots.xmlmodel;

import com.akamon.slots.model.GameConfig;
import com.akamon.slots.model.SlotModelException;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/29/14
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Mock {

    public static BetClass GenerateMockBetClass(int baseBet, String multiplierList)
    {
        BetClass betClass = new BetClass();
        betClass.basebet = baseBet;
        betClass.betMultList = multiplierList;
        return betClass;
    }

    public static GameConfig GenerateModelGameConfig() throws SlotModelException {
        XmlGameConfigLoader loader = new XmlGameConfigLoader();
        GameConfigData xmlGameConfig = new GameConfigData();
        SymbolSet xmlMockSymbolSet = GenerateMockXmlSymbolSet();
        xmlGameConfig.symbolSetsList = new GameConfigData.SymbolSetsList();
        xmlGameConfig.symbolSetsList.symbolSet = new ArrayList<SymbolSet>();
        xmlGameConfig.symbolSetsList.symbolSet.add(xmlMockSymbolSet);

        xmlGameConfig.winCombinationSetList = new GameConfigData.WinCombinationSetList();
        xmlGameConfig.winCombinationSetList.winCombinationSet = new ArrayList<WinCombinationSet>();
        xmlGameConfig.winCombinationSetList.winCombinationSet.add(GenerateMockLineWinCombinationSetLR());
        xmlGameConfig.winCombinationSetList.winCombinationSet.add(GenerateMockLineWinCombinationSetRL());
        xmlGameConfig.winCombinationSetList.winCombinationSet.add(GenerateMockScatterWinCombinationSet());

        xmlGameConfig.reelGridsList = new GameConfigData.ReelGridsList();
        xmlGameConfig.reelGridsList.reelGrid = new ArrayList<ReelGrid>();
        xmlGameConfig.reelGridsList.reelGrid.add(GenerateMockXmlReelGrid("BaseGameGrid"));
        xmlGameConfig.reelGridsList.reelGrid.add(GenerateMockXmlReelGrid("FreeSpinsGrid"));

        xmlGameConfig.evaluationPatternList = new GameConfigData.EvaluationPatternList();
        xmlGameConfig.evaluationPatternList.evaluationPattern = GenerateMockEvaluationPatterns(false);
        GenerateMockEvalPatternSetList(xmlGameConfig);

        GenerateMockBetEvaluationMapList(xmlGameConfig);

        GameConfig modelGameConfig = new GameConfig();
        loader.ParseConfig(modelGameConfig, xmlGameConfig);
        return modelGameConfig;
    }

    public static void GenerateMockBetEvaluationMapList(GameConfigData xmlGameConfig)
    {
        xmlGameConfig.betEvaluationMapList = new GameConfigData.BetEvaluationMapList();
        xmlGameConfig.betEvaluationMapList.betEvaluationMap = new ArrayList<BetEvaluationMap>();

        BetEvaluationMap baseGameBetEvalMap = new BetEvaluationMap();
        xmlGameConfig.betEvaluationMapList.betEvaluationMap.add(baseGameBetEvalMap);


        baseGameBetEvalMap.name = "BaseGameBetEvalMap";
        baseGameBetEvalMap.betEvaluationKVP = new ArrayList<BetEvaluationKVP>();
        BetEvaluationKVP baseGameKvp0 = new BetEvaluationKVP();
        baseGameBetEvalMap.betEvaluationKVP.add(baseGameKvp0);
        baseGameKvp0.betClass = GenerateMockBetClass(3, "*");
        baseGameKvp0.reelGridMapping = new ArrayList<BetEvaluationKVP.ReelGridMapping>();
        BetEvaluationKVP.ReelGridMapping reelGridMapping = new BetEvaluationKVP.ReelGridMapping();
        baseGameKvp0.reelGridMapping.add(reelGridMapping);
        reelGridMapping.reelGrid = "BaseGameGrid";
        reelGridMapping.evaluationPatternWinKVP = new ArrayList<EvaluationPatternWinKVP>();

        EvaluationPatternWinKVP evalPatternWinKVP = new EvaluationPatternWinKVP();
        reelGridMapping.evaluationPatternWinKVP.add(evalPatternWinKVP);
        evalPatternWinKVP.evaluationPatternSetName = "Lines";
        evalPatternWinKVP.winCombinationSetUsed = new ArrayList<EvaluationPatternWinKVP.WinCombinationSetUsed>();
        evalPatternWinKVP.winCombinationSetUsed.add(new EvaluationPatternWinKVP.WinCombinationSetUsed());
        evalPatternWinKVP.winCombinationSetUsed.add(new EvaluationPatternWinKVP.WinCombinationSetUsed());
        evalPatternWinKVP.winCombinationSetUsed.get(0).winCombinationSetName = "LinePaysLR";
        evalPatternWinKVP.winCombinationSetUsed.get(1).winCombinationSetName = "LinePaysRL";

        evalPatternWinKVP = new EvaluationPatternWinKVP();
        reelGridMapping.evaluationPatternWinKVP.add(evalPatternWinKVP);
        evalPatternWinKVP.evaluationPatternSetName = "Scatter";
        evalPatternWinKVP.winCombinationSetUsed = new ArrayList<EvaluationPatternWinKVP.WinCombinationSetUsed>();
        evalPatternWinKVP.winCombinationSetUsed.add(new EvaluationPatternWinKVP.WinCombinationSetUsed());
        evalPatternWinKVP.winCombinationSetUsed.get(0).winCombinationSetName = "ScatterAnyPays";

        BetEvaluationKVP baseGameKvp1 = new BetEvaluationKVP();
        baseGameBetEvalMap.betEvaluationKVP.add(baseGameKvp1);
        baseGameKvp1.betClass = GenerateMockBetClass(5, "*");
        baseGameKvp1.reelGridMapping = new ArrayList<BetEvaluationKVP.ReelGridMapping>();
        reelGridMapping = new BetEvaluationKVP.ReelGridMapping();
        baseGameKvp1.reelGridMapping.add(reelGridMapping);
        reelGridMapping.reelGrid = "BaseGameGrid";
        reelGridMapping.evaluationPatternWinKVP = new ArrayList<EvaluationPatternWinKVP>();

        evalPatternWinKVP = new EvaluationPatternWinKVP();
        reelGridMapping.evaluationPatternWinKVP.add(evalPatternWinKVP);
        evalPatternWinKVP.evaluationPatternSetName = "Lines";
        evalPatternWinKVP.winCombinationSetUsed = new ArrayList<EvaluationPatternWinKVP.WinCombinationSetUsed>();
        evalPatternWinKVP.winCombinationSetUsed.add(new EvaluationPatternWinKVP.WinCombinationSetUsed());
        evalPatternWinKVP.winCombinationSetUsed.add(new EvaluationPatternWinKVP.WinCombinationSetUsed());
        evalPatternWinKVP.winCombinationSetUsed.get(0).winCombinationSetName = "LinePaysLR";
        evalPatternWinKVP.winCombinationSetUsed.get(1).winCombinationSetName = "LinePaysRL";

        evalPatternWinKVP = new EvaluationPatternWinKVP();
        reelGridMapping.evaluationPatternWinKVP.add(evalPatternWinKVP);
        evalPatternWinKVP.evaluationPatternSetName = "Scatter";
        evalPatternWinKVP.winCombinationSetUsed = new ArrayList<EvaluationPatternWinKVP.WinCombinationSetUsed>();
        evalPatternWinKVP.winCombinationSetUsed.add(new EvaluationPatternWinKVP.WinCombinationSetUsed());
        evalPatternWinKVP.winCombinationSetUsed.get(0).winCombinationSetName = "ScatterAnyPays";

        BetEvaluationMap freeSpinsBetEvalMap = new BetEvaluationMap();
        xmlGameConfig.betEvaluationMapList.betEvaluationMap.add(freeSpinsBetEvalMap);

        freeSpinsBetEvalMap.name = "FreeSpinsBetEvalMap";
        freeSpinsBetEvalMap.betEvaluationKVP = new ArrayList<BetEvaluationKVP>();
        BetEvaluationKVP freeSpinsKvp0 = new BetEvaluationKVP();
        freeSpinsBetEvalMap.betEvaluationKVP.add(freeSpinsKvp0);
        freeSpinsKvp0.betClass = GenerateMockBetClass(3, "*");
        freeSpinsKvp0.reelGridMapping = new ArrayList<BetEvaluationKVP.ReelGridMapping>();
        reelGridMapping = new BetEvaluationKVP.ReelGridMapping();
        freeSpinsKvp0.reelGridMapping.add(reelGridMapping);
        reelGridMapping.reelGrid = "FreeSpinsGrid";
        reelGridMapping.evaluationPatternWinKVP = new ArrayList<EvaluationPatternWinKVP>();

        evalPatternWinKVP = new EvaluationPatternWinKVP();
        reelGridMapping.evaluationPatternWinKVP.add(evalPatternWinKVP);
        evalPatternWinKVP.evaluationPatternSetName = "Lines";
        evalPatternWinKVP.winCombinationSetUsed = new ArrayList<EvaluationPatternWinKVP.WinCombinationSetUsed>();
        evalPatternWinKVP.winCombinationSetUsed.add(new EvaluationPatternWinKVP.WinCombinationSetUsed());
        evalPatternWinKVP.winCombinationSetUsed.add(new EvaluationPatternWinKVP.WinCombinationSetUsed());
        evalPatternWinKVP.winCombinationSetUsed.get(0).winCombinationSetName = "LinePaysLR";
        evalPatternWinKVP.winCombinationSetUsed.get(1).winCombinationSetName = "LinePaysRL";

        BetEvaluationKVP freeSpinsKvp1 = new BetEvaluationKVP();
        freeSpinsBetEvalMap.betEvaluationKVP.add(freeSpinsKvp1);
        freeSpinsKvp1.betClass = GenerateMockBetClass(5, "*");
        freeSpinsKvp1.reelGridMapping = new ArrayList<BetEvaluationKVP.ReelGridMapping>();
        reelGridMapping = new BetEvaluationKVP.ReelGridMapping();
        freeSpinsKvp1.reelGridMapping.add(reelGridMapping);
        reelGridMapping.reelGrid = "FreeSpinsGrid";
        reelGridMapping.evaluationPatternWinKVP = new ArrayList<EvaluationPatternWinKVP>();

        evalPatternWinKVP = new EvaluationPatternWinKVP();
        reelGridMapping.evaluationPatternWinKVP.add(evalPatternWinKVP);
        evalPatternWinKVP.evaluationPatternSetName = "Lines";
        evalPatternWinKVP.winCombinationSetUsed = new ArrayList<EvaluationPatternWinKVP.WinCombinationSetUsed>();
        evalPatternWinKVP.winCombinationSetUsed.add(new EvaluationPatternWinKVP.WinCombinationSetUsed());
        evalPatternWinKVP.winCombinationSetUsed.add(new EvaluationPatternWinKVP.WinCombinationSetUsed());
        evalPatternWinKVP.winCombinationSetUsed.get(0).winCombinationSetName = "LinePaysLR";
        evalPatternWinKVP.winCombinationSetUsed.get(1).winCombinationSetName = "LinePaysRL";

        evalPatternWinKVP = new EvaluationPatternWinKVP();
        reelGridMapping.evaluationPatternWinKVP.add(evalPatternWinKVP);
        evalPatternWinKVP.evaluationPatternSetName = "Ways";
        evalPatternWinKVP.winCombinationSetUsed = new ArrayList<EvaluationPatternWinKVP.WinCombinationSetUsed>();
        evalPatternWinKVP.winCombinationSetUsed.add(new EvaluationPatternWinKVP.WinCombinationSetUsed());
        evalPatternWinKVP.winCombinationSetUsed.get(0).winCombinationSetName = "LinePaysLR";
    }

    private static void GenerateMockEvalPatternSetList(GameConfigData xmlGameConfig)
    {
        xmlGameConfig.evaluationPatternSetList = new GameConfigData.EvaluationPatternSetList();
        xmlGameConfig.evaluationPatternSetList.evaluationPatternSet = new ArrayList<EvaluationPatternSet>();
        EvaluationPatternSet evaluationPatternSet0 = new EvaluationPatternSet();
        evaluationPatternSet0.name = "Lines";
        evaluationPatternSet0.includeEvaluationPattern = new ArrayList<EvaluationPatternSet.IncludeEvaluationPattern>();
        for (int i = 0; i < 3; i++)
        {
            EvaluationPatternSet.IncludeEvaluationPattern includeEvaluationPattern = new EvaluationPatternSet.IncludeEvaluationPattern();
            includeEvaluationPattern.evaluationPatternName = "Line " + (i+1);
            evaluationPatternSet0.includeEvaluationPattern.add(includeEvaluationPattern);
        }

        xmlGameConfig.evaluationPatternSetList.evaluationPatternSet.add(evaluationPatternSet0);

        EvaluationPatternSet evaluationPatternSet1 = new EvaluationPatternSet();
        evaluationPatternSet1.name = "Scatter";
        evaluationPatternSet1.includeEvaluationPattern = new ArrayList<EvaluationPatternSet.IncludeEvaluationPattern>();
        EvaluationPatternSet.IncludeEvaluationPattern scatterIncludePattern = new EvaluationPatternSet.IncludeEvaluationPattern();
        scatterIncludePattern.evaluationPatternName = "Scatter";
        evaluationPatternSet1.includeEvaluationPattern.add(scatterIncludePattern);
        xmlGameConfig.evaluationPatternSetList.evaluationPatternSet.add(evaluationPatternSet1);

        EvaluationPatternSet evaluationPatternSet2 = new EvaluationPatternSet();
        evaluationPatternSet2.name = "Ways";
        evaluationPatternSet2.includeEvaluationPattern = new ArrayList<EvaluationPatternSet.IncludeEvaluationPattern>();
        EvaluationPatternSet.IncludeEvaluationPattern waysIncludePattern = new EvaluationPatternSet.IncludeEvaluationPattern();
        waysIncludePattern.evaluationPatternName = "Ways";
        evaluationPatternSet2.includeEvaluationPattern.add(waysIncludePattern);
        xmlGameConfig.evaluationPatternSetList.evaluationPatternSet.add(evaluationPatternSet2);

    }

    public static WinCombinationSet GenerateMockLineWinCombinationSetLR()
    {
        WinCombinationSet xmlWinCombset = new WinCombinationSet();
        xmlWinCombset.symbolSetUsed = "primary";
        xmlWinCombset.name = "LinePaysLR";

        List<WinCombination> winCombinations = new ArrayList<WinCombination>();
        for (int symIndex = 1; symIndex <= 7; symIndex++)
        {
            for(int count = 5; count >= 2; count--)
                winCombinations.add(GenerateMockWinSequentialCombination(count, "W" + symIndex, true));
        }
        xmlWinCombset.winCombination = winCombinations;

        return xmlWinCombset;
    }

    public static WinCombinationSet GenerateMockLineWinCombinationSetRL()
    {
        WinCombinationSet xmlWinCombset = new WinCombinationSet();
        xmlWinCombset.symbolSetUsed = "primary";
        xmlWinCombset.name = "LinePaysRL";

        List<WinCombination> winCombinations = new ArrayList<WinCombination>();
        for (int symIndex = 1; symIndex <= 7; symIndex++)
        {
            for (int count = 4; count >= 2; count--)
                winCombinations.add(GenerateMockWinSequentialCombination(count, "W" + symIndex, false));
        }
        xmlWinCombset.winCombination = winCombinations;

        return xmlWinCombset;
    }

    public static WinCombinationSet GenerateMockScatterWinCombinationSet()
    {
        WinCombinationSet xmlWinCombSet = new WinCombinationSet();
        xmlWinCombSet.symbolSetUsed = "primary";
        xmlWinCombSet.name = "ScatterAnyPays";

        List<WinCombination> winCombinations = new ArrayList<WinCombination>();
        for (int count = 5; count >= 2; count--)
        {
            WinCombination scatterWinCombination = new WinCombination();
            scatterWinCombination.name = count + " scattered WILD2";
            if (count > 2) {
                scatterWinCombination.payMultiplicationType = "None";
                scatterWinCombination.basepay = null;
                scatterWinCombination.sortpriority = count * 100;
                scatterWinCombination.trigger = new ArrayList<Trigger>();
                Trigger trigger1 = new Trigger();
                trigger1.name = "FreeSpins";
                trigger1.arg = new ArrayList<Trigger.Arg>();
                Trigger.Arg arg1 = new Trigger.Arg();
                arg1.name = "freespins";
                arg1.value = (10 * (count - 2))+"";
                Trigger.Arg arg2 = new Trigger.Arg();
                arg2.name = "wild";
                arg2.value = (count - 2)+"";

                trigger1.arg.add(arg1);
                trigger1.arg.add(arg2);

                Trigger trigger2 = new Trigger();
                trigger2.name = "progressive";

                scatterWinCombination.trigger.add(trigger1);
                scatterWinCombination.trigger.add(trigger2);
            }
            else {
                scatterWinCombination.payMultiplicationType = "TotalBet";
                scatterWinCombination.basepay = count * 100;
                scatterWinCombination.sortpriority = null;

            }
            scatterWinCombination.symbolWinElement = new ArrayList<SymbolWinElement>();
            SymbolWinElement symbolWinElement = new SymbolWinElement();
            symbolWinElement.count = count;
            symbolWinElement.symbol = "WILD2";
            scatterWinCombination.symbolWinElement.add(symbolWinElement);
            winCombinations.add(scatterWinCombination);
        }
        xmlWinCombSet.winCombination = winCombinations;
        return xmlWinCombSet;
    }

    public static WinCombination GenerateMockWinSequentialCombination(int count, String symName,boolean isLR) {
        return GenerateMockWinSequentialCombination(count, symName, isLR,false,false,false,false);
    }

    public static WinCombination GenerateMockWinSequentialCombination(int count, String symName,boolean isLR, boolean sortPriorAndBasePayNull, boolean sortPriorLessThanBasePay, boolean hasBothIndexAndCount, boolean bothIndexAndCountNull)
    {
        WinCombination winCombination = new WinCombination();

        if (sortPriorAndBasePayNull)
        {
            winCombination.basepay = null;
        }
        else if (sortPriorLessThanBasePay)
        {
            winCombination.basepay = count * 100;
            winCombination.sortpriority = winCombination.basepay - 1;
        }
        else
        {
            winCombination.basepay = count * 100;
            winCombination.sortpriority = null;
        }


        winCombination.name = count + " " + symName + " line" + (isLR ? " LR" : " RL");
        winCombination.payMultiplicationType = "BetMult";

        winCombination.trigger = null;
        winCombination.symbolWinElement = new ArrayList<SymbolWinElement>();
        for (int i = 0; i < count; i++)
        {
            int index = i;
            if(!isLR) {
                index = 4-i;
            }
            SymbolWinElement symbolWinElement = new SymbolWinElement();
            if (hasBothIndexAndCount)
            {
                symbolWinElement.count = 1;
                symbolWinElement.index = index;
            }
            else if (bothIndexAndCountNull)
            {
                symbolWinElement.index = null;
                symbolWinElement.count = null;
            }
            else
            {
                symbolWinElement.index = index;
                symbolWinElement.count = null;
            }
            symbolWinElement.symbol = symName;
            winCombination.symbolWinElement.add(symbolWinElement);
        }


        return winCombination;
    }

    public static ArrayList<EvaluationPattern> GenerateMockEvaluationPatterns(boolean duplicateLines)
    {
        ArrayList<EvaluationPattern> evalPatterns = new ArrayList<EvaluationPattern>();
        List<Coord> coords1 = new ArrayList<Coord>();
        List<Coord> coords2 = new ArrayList<Coord>();
        List<Coord> coords3 = new ArrayList<Coord>();

        List<Coord> coordsAll = new ArrayList<Coord>();

        for (int x = 0; x < 5; x++)
        {
            Coord coord1 = new Coord();
            coord1.x = x;
            coord1.y = 1;
            coords1.add(coord1);

            Coord coord2 = new Coord();
            coord2.x = x;
            coord2.y = 0;
            coords2.add(coord2);

            Coord coord3 = new Coord();
            coord3.x = x;
            if (duplicateLines)
                coord3.y = 0;
            else
                coord3.y = 2;
            coords3.add(coord3);

            coordsAll.add(coord2);
            coordsAll.add(coord1);
            coordsAll.add(coord3);
        }

        EvaluationPattern evaluationPattern1 = new EvaluationPattern();
        evaluationPattern1.name = "Line 1";
        evaluationPattern1.evaluationType ="Payline";
        evaluationPattern1.coord = coords1;
        evalPatterns.add(evaluationPattern1);

        EvaluationPattern evaluationPattern2 = new EvaluationPattern();
        evaluationPattern2.name = "Line 2";
        evaluationPattern2.evaluationType ="Payline";
        evaluationPattern2.coord = coords2;
        evalPatterns.add(evaluationPattern2);

        EvaluationPattern evaluationPattern3 = new EvaluationPattern();
        evaluationPattern3.name = "Line 3";
        evaluationPattern3.evaluationType ="Payline";
        evaluationPattern3.coord = coords3;
        evalPatterns.add(evaluationPattern3);

        EvaluationPattern evaluationPatternAll = new EvaluationPattern();
        evaluationPatternAll.name = "Scatter";
        evaluationPatternAll.evaluationType ="ScatterAny";
        evaluationPatternAll.coord = coordsAll;
        evalPatterns.add(evaluationPatternAll);

        EvaluationPattern evaluationPatternWays = new EvaluationPattern();
        evaluationPatternWays.name = "Ways";
        evaluationPatternWays.evaluationType ="Ways";
        evaluationPatternWays.coord = coordsAll;
        evalPatterns.add(evaluationPatternWays);

        return evalPatterns;
    }

    public static Reel GenerateMockXmlReel(int index)
    {
        Reel xmlReel = new Reel();
        List<WeightedList.Item> items = new ArrayList<WeightedList.Item>();
        for (int i = 0; i < 5 + index; i++)
        {
            WeightedList.Item item = new WeightedList.Item();
            item.index = items.size();
            item.value = "WILD1";
            item.weight = i % 3 + 1;
            items.add(item);

            item = new WeightedList.Item();
            item.index = items.size();
            item.value = "WILD2";
            item.weight = i % 3 + 1;
            items.add(item);

        }

        for (int i = 1; i <= 7; i++)
        {
            WeightedList.Item item = new WeightedList.Item();
            item.index = items.size();
            item.value = "S" + i;
            item.weight = i % 3 + 1;
            items.add(item);
        }
        xmlReel.name = "R" + (index + 1);
        xmlReel.item = items;
        return xmlReel;
    }

    public static ReelGrid GenerateMockXmlReelGrid(String name)
    {
        ReelGrid xmlReelGrid = new ReelGrid();
        List<Reel> xmlReels = new ArrayList<Reel>();
        for (int i = 0; i < 5; i++)
        {
            xmlReels.add(GenerateMockXmlReel(i));
        }
        xmlReelGrid.reel = xmlReels;

        xmlReelGrid.name = name;
        xmlReelGrid.symbolSet = "primary";

        List<ReelGrid.GridMappingList.GridMapping> xmlGridMappings = new ArrayList<ReelGrid.GridMappingList.GridMapping>();
        for (int x = 0; x < 5; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                ReelGrid.GridMappingList.GridMapping gridMapping = new ReelGrid.GridMappingList.GridMapping();
                Coord coord = new Coord();
                coord.x = x;
                coord.y = y;
                gridMapping.coord = coord;
                gridMapping.reel = "R" + (x + 1);
                gridMapping.offset = y - 1;
                xmlGridMappings.add(gridMapping);
            }
        }
        xmlReelGrid.gridMappingList = new ReelGrid.GridMappingList();
        xmlReelGrid.gridMappingList.gridMapping = xmlGridMappings;
        return xmlReelGrid;
    }


    public static SymbolSet GenerateMockXmlSymbolSet()
    {
        SymbolSet xmlSymbolSet = new SymbolSet();
        xmlSymbolSet.name = "primary";
        ArrayList<NaturalSymbol> xmlNaturalSymbols = new ArrayList<NaturalSymbol>();
        NaturalSymbol wild1 = new NaturalSymbol();
        wild1.name = "WILD1";
        xmlNaturalSymbols.add(wild1);

        NaturalSymbol wild2 = new NaturalSymbol();
        wild2.name = "WILD2";
        xmlNaturalSymbols.add(wild2);
        for (int i = 1; i <= 7; i++)
        {
            NaturalSymbol sym_i = new NaturalSymbol();
            sym_i.name = "S" + i;
            xmlNaturalSymbols.add(sym_i);
        }
        xmlSymbolSet.naturalSymbol = xmlNaturalSymbols;

        ArrayList<SymbolClassPlaceHolder> xmlSymbolClassPlaceholders = new ArrayList<SymbolClassPlaceHolder>();
        for (int i = 1; i <= 7; i++)
        {
            SymbolClassPlaceHolder include_i = new SymbolClassPlaceHolder();
            include_i.name = "W" + i;
            include_i.type = "Include";
            SymbolClassPlaceHolder exclude_i = new SymbolClassPlaceHolder();
            exclude_i.name = "X" + i;
            exclude_i.type = "Exclude";
            xmlSymbolClassPlaceholders.add(include_i);
            xmlSymbolClassPlaceholders.add(exclude_i);
        }
        xmlSymbolSet.symbolClassName = xmlSymbolClassPlaceholders;
        xmlSymbolSet.substitutionScheme = GenerateMockSubstitutionSchemes();
        return xmlSymbolSet;
    }

    public static List<SubstitutionScheme> GenerateMockSubstitutionSchemes()
    {
        ArrayList<SubstitutionScheme> substitutionSchemes = new ArrayList<SubstitutionScheme>();
        SubstitutionScheme defaultSubScheme = new SubstitutionScheme();
        defaultSubScheme.name = "Primary";
        defaultSubScheme._default = true;

        SubstitutionScheme secondardySubScheme = new SubstitutionScheme();
        secondardySubScheme.name = "Secondary";
        secondardySubScheme._default = null;

        List<SymbolClass> defaultSymbols = new ArrayList<SymbolClass>();

        for (int i = 1; i <= 7; i++)
        {
            SymbolClass defaultIncludeSymbolClass = new SymbolClass();
            defaultIncludeSymbolClass.name = "W" + i;
            defaultIncludeSymbolClass.componentSymbol = new ArrayList<SymbolClass.ComponentSymbol>();
            SymbolClass.ComponentSymbol componentSymbol1 = new SymbolClass.ComponentSymbol();
            componentSymbol1.symbolname = "WILD1";

            defaultIncludeSymbolClass.componentSymbol.add(componentSymbol1);

            SymbolClass.ComponentSymbol componentSymbol2 = new SymbolClass.ComponentSymbol();
            componentSymbol2.symbolname = "S" + i;
            defaultIncludeSymbolClass.componentSymbol.add(componentSymbol2);

            defaultSymbols.add(defaultIncludeSymbolClass);

            SymbolClass defaultExcludeSymbolClass = new SymbolClass();
            defaultExcludeSymbolClass.name = "X" + i;
            defaultExcludeSymbolClass.componentSymbol = new ArrayList<SymbolClass.ComponentSymbol>();
            defaultExcludeSymbolClass.componentSymbol.add(componentSymbol1);
            defaultExcludeSymbolClass.componentSymbol.add(componentSymbol2);

            defaultSymbols.add(defaultExcludeSymbolClass);

        }
        defaultSubScheme.symbol = defaultSymbols;

        List<SymbolClass> secondarySymbols = new ArrayList<SymbolClass>();

        for (int i = 1; i <= 7; i++)
        {
            SymbolClass defaultIncludeSymbolClass = new SymbolClass();
            defaultIncludeSymbolClass.name = "W" + i;
            defaultIncludeSymbolClass.componentSymbol = new ArrayList<SymbolClass.ComponentSymbol>();
            SymbolClass.ComponentSymbol componentSymbol1 = new SymbolClass.ComponentSymbol();
            componentSymbol1.symbolname = "WILD1";

            defaultIncludeSymbolClass.componentSymbol.add(componentSymbol1);

            SymbolClass.ComponentSymbol componentSymbol2 = new SymbolClass.ComponentSymbol();
            componentSymbol2.symbolname = "S" + i;
            defaultIncludeSymbolClass.componentSymbol.add(componentSymbol2);

            SymbolClass.ComponentSymbol componentSymbol3 = new SymbolClass.ComponentSymbol();
            componentSymbol3.symbolname = "WILD2";
            defaultIncludeSymbolClass.componentSymbol.add(componentSymbol3);

            secondarySymbols.add(defaultIncludeSymbolClass);

            SymbolClass defaultExcludeSymbolClass = new SymbolClass();
            defaultExcludeSymbolClass.name = "X" + i;
            defaultExcludeSymbolClass.componentSymbol = new ArrayList<SymbolClass.ComponentSymbol>();
            defaultExcludeSymbolClass.componentSymbol.add(componentSymbol1);
            defaultExcludeSymbolClass.componentSymbol.add(componentSymbol2);
            defaultExcludeSymbolClass.componentSymbol.add(componentSymbol3);

            secondarySymbols.add(defaultExcludeSymbolClass);
        }
        secondardySubScheme.symbol = secondarySymbols;
        substitutionSchemes.add(defaultSubScheme);
        substitutionSchemes.add(secondardySubScheme);
        return substitutionSchemes;
    }
}
