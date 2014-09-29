package com.akamon.slots.xmlmodel;

import com.akamon.slots.model.*;

import javax.xml.bind.JAXBContext;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/27/14
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class XmlGameConfigLoader implements IGameConfigLoader {
    @Override
    public GameConfig loadConfig(InputStream inputStream) throws Exception {

        JAXBContext context = JAXBContext.newInstance(GameConfigData.class);
        javax.xml.bind.Unmarshaller um = context.createUnmarshaller();

        GameConfigData gameConfigData = (GameConfigData) um.unmarshal(inputStream);

        GameConfig modelGameConfig = new GameConfig();
        ParseConfig(modelGameConfig,gameConfigData);

        return modelGameConfig;
    }

    public void ParseConfig(GameConfig modelGameConfig, GameConfigData xmlGameConfig) throws SlotModelException {
        ParseSymbolSets(xmlGameConfig, modelGameConfig);
        ParseReelGrids(xmlGameConfig, modelGameConfig);
        ParseEvaluationPatterns(xmlGameConfig, modelGameConfig);
        ParseEvaluationPatternSets(xmlGameConfig, modelGameConfig);
        ParseWinCombinationSets(xmlGameConfig, modelGameConfig);
        ParseBetEvaluationMaps(xmlGameConfig, modelGameConfig);
        ParseWeightedLists(xmlGameConfig, modelGameConfig);
    }

    public void ParseWeightedLists(GameConfigData xmlGameConfigData, GameConfig modelGameConfig) throws SlotModelException {
        if (xmlGameConfigData.weightedLists != null && xmlGameConfigData.weightedLists.weightedList.size() > 0)
        {
            for(WeightedList xmlWeightedList : xmlGameConfigData.weightedLists.weightedList)
            {
                com.akamon.slots.model.WeightedList<String> modelWeightedList = new com.akamon.slots.model.WeightedList<String>(xmlWeightedList.name);
                for(WeightedList.Item xmlItem : xmlWeightedList.item)
                {
                    modelWeightedList.add(xmlItem.value, xmlItem.weight);
                }
                modelGameConfig.addWeightedList(modelWeightedList);
            }
        }
    }

    public void ParseBetEvaluationMaps(GameConfigData xmlGameConfig, GameConfig modelGameConfig) throws SlotModelException {
        for (BetEvaluationMap xmlBetEvaluationMap : xmlGameConfig.betEvaluationMapList.betEvaluationMap)
        {
            String name = xmlBetEvaluationMap.name;
            com.akamon.slots.model.BetEvaluationMap modelBetEvaluationMap = new com.akamon.slots.model.BetEvaluationMap(name);
            for (BetEvaluationKVP xmlBetEvaluationKVP : xmlBetEvaluationMap.betEvaluationKVP)
            {
                com.akamon.slots.model.BetEvaluationPairing modelBetEvalKVP = ParseBetEvaluationKVP(xmlBetEvaluationKVP, modelGameConfig);
                modelBetEvaluationMap.addBetEvaluationPairing(modelBetEvalKVP);
            }
            modelGameConfig.addBetEvaluationMap(modelBetEvaluationMap);
        }
    }

    public void ParseWinCombinationSets(GameConfigData xmlGameConfig, GameConfig modelGameConfig) throws SlotModelException {
        for (WinCombinationSet xmlWinCombinationSet : xmlGameConfig.winCombinationSetList.winCombinationSet)
        {
            ArrayList<com.akamon.slots.model.WinCombination> modelWinCombinations = new ArrayList<com.akamon.slots.model.WinCombination>();
            com.akamon.slots.model.SymbolSet modelSymbolSet = modelGameConfig.getSymbolSet(xmlWinCombinationSet.symbolSetUsed);
            for (WinCombination xmlWinCombination : xmlWinCombinationSet.winCombination)
            {
                com.akamon.slots.model.WinCombination modelWinCombination = ParseWinCombination(xmlWinCombination, modelSymbolSet);
                modelWinCombinations.add(modelWinCombination);
            }

            com.akamon.slots.model.WinCombinationSet modelWinCombinationSet = new com.akamon.slots.model.WinCombinationSet(xmlWinCombinationSet.name, modelWinCombinations);
            modelGameConfig.addWinCombinationSet(modelWinCombinationSet);
        }
    }

    public void ParseEvaluationPatternSets(GameConfigData xmlGameConfig, GameConfig modelGameConfig) throws SlotModelException {
        for (EvaluationPatternSet xmlEvaluationPatternSet : xmlGameConfig.evaluationPatternSetList.evaluationPatternSet)
        {
            com.akamon.slots.model.EvaluationPatternSet modelEvalPatternSet = new com.akamon.slots.model.EvaluationPatternSet(xmlEvaluationPatternSet.name);
            for (EvaluationPatternSet.IncludeEvaluationPattern xmlEvalPatternIncluded : xmlEvaluationPatternSet.includeEvaluationPattern)
            {
                com.akamon.slots.model.EvaluationPattern modelEvalPattern = modelGameConfig.getEvaluationPattern(xmlEvalPatternIncluded.evaluationPatternName);
                modelEvalPatternSet.getEvaluationPatterns().add(modelEvalPattern);
            }

            modelGameConfig.addEvaluationPatternSet(modelEvalPatternSet);
        }
    }

    public void ParseEvaluationPatterns(GameConfigData xmlGameConfig, GameConfig modelGameConfig) throws SlotModelException {
        ArrayList<com.akamon.slots.model.EvaluationPattern> previouslyAddedPaylines = new ArrayList<com.akamon.slots.model.EvaluationPattern>();

        for (EvaluationPattern evalPattern : xmlGameConfig.evaluationPatternList.evaluationPattern)
        {
            ArrayList<com.akamon.slots.model.Coordinate> modelCoordinates = new ArrayList<com.akamon.slots.model.Coordinate>();
            String name = evalPattern.name;
            for (Coord xmlCoord : evalPattern.coord)
            {
                modelCoordinates.add(new com.akamon.slots.model.Coordinate(xmlCoord.x, xmlCoord.y));
            }

            com.akamon.slots.model.EvaluationType evalType;
            if (evalPattern.evaluationType.equals("Payline"))
            {

                if(ContainsEvalPatternWithAllSameCoordinates(previouslyAddedPaylines,modelCoordinates) != null)
                {
                    String otherEvalPatternName = ContainsEvalPatternWithAllSameCoordinates(previouslyAddedPaylines,modelCoordinates).getName();
                    throw new com.akamon.slots.model.SlotModelException("Duplicate paylines: " + otherEvalPatternName + " and " + name);
                }
                else
                {
                    evalType = com.akamon.slots.model.EvaluationType.Payline;
                }

            }
            else if (evalPattern.evaluationType.equals("ScatterAny"))
                evalType = com.akamon.slots.model.EvaluationType.ScatterAny;
            else if (evalPattern.evaluationType.equals("Ways"))
                evalType = com.akamon.slots.model.EvaluationType.Ways;
            else
                throw new com.akamon.slots.model.SlotModelException("Invalid evalution type: " + evalPattern.evaluationType);

            com.akamon.slots.model.EvaluationPattern modelEvaluationPattern = new com.akamon.slots.model.EvaluationPattern(name,modelCoordinates,evalType);
            modelGameConfig.addEvaluationPattern(modelEvaluationPattern);
            if (modelEvaluationPattern.getEvaluationType() == com.akamon.slots.model.EvaluationType.Payline)
                previouslyAddedPaylines.add(modelEvaluationPattern);
        }
    }

    private com.akamon.slots.model.EvaluationPattern ContainsEvalPatternWithAllSameCoordinates(List<com.akamon.slots.model.EvaluationPattern> previouslyAddedPaylines, List<com.akamon.slots.model.Coordinate> modelCoordinates) {
        for(com.akamon.slots.model.EvaluationPattern pattern : previouslyAddedPaylines) {
            if(CoordinatesMatchExactly(modelCoordinates,pattern))
                return pattern;
        }
        return null;
    }
    private static boolean CoordinatesMatchExactly(List<com.akamon.slots.model.Coordinate> modelCoordinates, com.akamon.slots.model.EvaluationPattern x)
    {
        boolean exactMatch = true;
        for (int i = 0; i < modelCoordinates.size(); i++)
        {
            if (modelCoordinates.get(i).getX() != x.getOrderedCoordinates().get(i).getX() || modelCoordinates.get(i).getY() != x.getOrderedCoordinates().get(i).getY())
            {
                exactMatch = false;
                break;
            }
        }
        return exactMatch;
    }

    public void ParseReelGrids(GameConfigData xmlGameConfig, GameConfig modelGameConfig) throws SlotModelException {
        for (ReelGrid xmlReelGrid : xmlGameConfig.reelGridsList.reelGrid)
        {
            com.akamon.slots.model.ReelGridModel modelReelGrid = ParseReelGridModel(xmlReelGrid, modelGameConfig);
            modelGameConfig.addReelGridModel(modelReelGrid);
        }
    }

    public void ParseSymbolSets(GameConfigData xmlGameConfig, GameConfig modelGameConfig) throws SlotModelException {
        for (BetEvaluationMap xmlBetEvaluationMap : xmlGameConfig.betEvaluationMapList.betEvaluationMap)
        {
            String name = xmlBetEvaluationMap.name;
            com.akamon.slots.model.BetEvaluationMap modelBetEvaluationMap = new com.akamon.slots.model.BetEvaluationMap(name);
            for(BetEvaluationKVP xmlBetEvaluationKVP : xmlBetEvaluationMap.betEvaluationKVP)
            {
                com.akamon.slots.model.BetEvaluationPairing modelBetEvalKVP = ParseBetEvaluationKVP(xmlBetEvaluationKVP, modelGameConfig);
                modelBetEvaluationMap.addBetEvaluationPairing(modelBetEvalKVP);
            }
            modelGameConfig.addBetEvaluationMap(modelBetEvaluationMap);
        }
    }

    protected com.akamon.slots.model.BetEvaluationPairing ParseBetEvaluationKVP(BetEvaluationKVP xmlBetEvaluationKVP, GameConfig modelGameConfig) throws SlotModelException {
        com.akamon.slots.model.BetClass modelBetClass = ParseBetClass(xmlBetEvaluationKVP.betClass);
        HashMap<com.akamon.slots.model.ReelGridModel, ArrayList<com.akamon.slots.model.EvaluationPatternWinMapping>> modelReelGridEvalMapping = new HashMap<com.akamon.slots.model.ReelGridModel, ArrayList<com.akamon.slots.model.EvaluationPatternWinMapping>>();

        for(BetEvaluationKVP.ReelGridMapping xmlReelGridMapping : xmlBetEvaluationKVP.reelGridMapping)
        {
            String reelGridName = xmlReelGridMapping.reelGrid;
            ArrayList<com.akamon.slots.model.EvaluationPatternWinMapping> modelEvalPatternWinMappings = new ArrayList<com.akamon.slots.model.EvaluationPatternWinMapping>();
            for(EvaluationPatternWinKVP xmlEvaluationPatternWinKVP : xmlReelGridMapping.evaluationPatternWinKVP)
            {
                com.akamon.slots.model.EvaluationPatternWinMapping modelEvalPatternWinMapping = ParseEvaluationPatternWinMapping(xmlEvaluationPatternWinKVP, modelGameConfig);
                modelEvalPatternWinMappings.add(modelEvalPatternWinMapping);
            }

            com.akamon.slots.model.ReelGridModel modelReelGrid = modelGameConfig.getReelGridModel(reelGridName);
            if (modelReelGridEvalMapping.containsKey(modelReelGrid))
                throw new com.akamon.slots.model.SlotModelException("Duplicate reel grid mapping");
            modelReelGridEvalMapping.put(modelReelGrid, modelEvalPatternWinMappings);
        }

        com.akamon.slots.model.BetEvaluationPairing modelBetEvaluationKVP = new com.akamon.slots.model.BetEvaluationPairing(modelBetClass, modelReelGridEvalMapping);
        return modelBetEvaluationKVP;
    }

    protected com.akamon.slots.model.EvaluationPatternWinMapping ParseEvaluationPatternWinMapping(EvaluationPatternWinKVP xmlEvaluationPatternWinKVP, com.akamon.slots.model.GameConfig modelGameConfig)
    {
        com.akamon.slots.model.EvaluationPatternWinMapping modelEvalPatternWinMapping = new com.akamon.slots.model.EvaluationPatternWinMapping();
        String evalPatternSetName = xmlEvaluationPatternWinKVP.evaluationPatternSetName;
        com.akamon.slots.model.EvaluationPatternSet modelEvalPatternSet = modelGameConfig.getEvaluationPatternSet(evalPatternSetName);

        ArrayList<com.akamon.slots.model.WinCombinationSet> modelWinCombinationSets = new ArrayList<com.akamon.slots.model.WinCombinationSet>();
        for(EvaluationPatternWinKVP.WinCombinationSetUsed xmlWinCombinationSetUsed : xmlEvaluationPatternWinKVP.winCombinationSetUsed)
        {
            String winCombinationSetName = xmlWinCombinationSetUsed.winCombinationSetName;
            com.akamon.slots.model.WinCombinationSet modelWinCombinationSet = modelGameConfig.getWinCombinationSet(winCombinationSetName);
            modelWinCombinationSets.add(modelWinCombinationSet);
        }
        modelEvalPatternWinMapping.setEvaluationPatternSet(modelEvalPatternSet);
        modelEvalPatternWinMapping.setWinCombinationSets(modelWinCombinationSets);

        return modelEvalPatternWinMapping;
    }

    protected com.akamon.slots.model.BetClass ParseBetClass(BetClass xmlBetClass) throws SlotModelException {
        int baseBet = xmlBetClass.basebet;
        String betMultList = xmlBetClass.betMultList;
        if (betMultList.equals("*") || betMultList.toUpperCase().equals("ALL"))
            return new com.akamon.slots.model.BetClass(baseBet);
        else
        {
            HashSet<Integer> betMults = new HashSet<Integer>();
            String[] splitBetMultList = betMultList.split(",");
            for (int i = 0; i < splitBetMultList.length; i++)
            {
                try
                {
                    int betMult = Integer.parseInt(splitBetMultList[i]);
                    if (betMults.contains(betMult))
                        throw new com.akamon.slots.model.SlotModelException("Bet class has duplicate bet multipliers: " + betMultList);
                    betMults.add(betMult);
                }
                catch (Exception e)
                {
                    throw new com.akamon.slots.model.SlotModelException("Invalid bet class value: " + splitBetMultList[i]);
                }
            }
            return new com.akamon.slots.model.BetClass(baseBet, betMults);
        }
    }

    protected com.akamon.slots.model.WinCombination ParseWinCombination(WinCombination xmlWinCombination, com.akamon.slots.model.SymbolSet modelSymbolSet) throws SlotModelException {
        String name = xmlWinCombination.name;
        Integer basePay = xmlWinCombination.basepay;
        Integer sortPriority = xmlWinCombination.sortpriority;

        if (basePay == null && sortPriority == null)
            throw new com.akamon.slots.model.SlotModelException("Invalid win combination: either base pay or sort priority must be specified (" + name + ")");
        else if (basePay != null && sortPriority != null && sortPriority.intValue() < basePay.intValue())
            throw new com.akamon.slots.model.SlotModelException("Invalid win combination: sort priority must be at least as high as base pay if both are specified (" + name + ")");
        else if (basePay != null && sortPriority == null)
            sortPriority = basePay;

        com.akamon.slots.model.PayMultiplicationType multiplicationType = com.akamon.slots.model.PayMultiplicationType.BetMult;
        if(xmlWinCombination.payMultiplicationType.equals("BetMult"))
            multiplicationType = com.akamon.slots.model.PayMultiplicationType.BetMult;
        else if(xmlWinCombination.payMultiplicationType.equals("TotalBet"))
            multiplicationType = com.akamon.slots.model.PayMultiplicationType.TotalBet;
        else if(xmlWinCombination.payMultiplicationType.equals("None"))
            multiplicationType = com.akamon.slots.model.PayMultiplicationType.None;
        else
            throw new com.akamon.slots.model.SlotModelException("Unsupported pay multiplication type:" + xmlWinCombination.payMultiplicationType.toString());


        ArrayList<com.akamon.slots.model.SymbolWinElement> modelSymbolWinElements = new ArrayList<com.akamon.slots.model.SymbolWinElement>();
        for(SymbolWinElement xmlSymbolWinElement : xmlWinCombination.symbolWinElement)
        {
            com.akamon.slots.model.Symbol symbol = modelSymbolSet.getSymbolForName(xmlSymbolWinElement.symbol);
            Integer index = xmlSymbolWinElement.index;
            Integer count = xmlSymbolWinElement.count;

            com.akamon.slots.model.SymbolWinElement modelSymbolWinElement = new com.akamon.slots.model.SymbolWinElement(symbol,index,count);
            modelSymbolWinElements.add(modelSymbolWinElement);
        }

        ArrayList<com.akamon.slots.model.Trigger> modelTriggers = null;
        if (xmlWinCombination.trigger != null && xmlWinCombination.trigger.size() > 0)
        {
            modelTriggers = new ArrayList<com.akamon.slots.model.Trigger>();
            for(Trigger xmlTrigger : xmlWinCombination.trigger)
            {
                com.akamon.slots.model.Trigger modelTrigger = new com.akamon.slots.model.Trigger(xmlTrigger.name);
                if(xmlTrigger.arg != null) {
                    for(Trigger.Arg xmlArg : xmlTrigger.arg)
                    {
                        modelTrigger.getArguments().put(xmlArg.name, xmlArg.value);
                    }
                }
                modelTriggers.add(modelTrigger);
            }
        }

        com.akamon.slots.model.WinCombination modelWinCombination = new com.akamon.slots.model.WinCombination(name, basePay, sortPriority.intValue(), multiplicationType, modelSymbolWinElements, modelTriggers);
        return modelWinCombination;
    }

    protected com.akamon.slots.model.ReelGridModel ParseReelGridModel(ReelGrid xmlReelGrid,GameConfig modelGameConfig) throws SlotModelException {
        com.akamon.slots.model.ReelGridModel modelReelGrid = new com.akamon.slots.model.ReelGridModel(xmlReelGrid.name);
        com.akamon.slots.model.SymbolSet modelSymbolSet = modelGameConfig.getSymbolSet(xmlReelGrid.symbolSet);

        for (int reelIndex = 0;reelIndex< xmlReelGrid.reel.size(); reelIndex++)
        {
            Reel xmlReel = xmlReelGrid.reel.get(reelIndex);
            com.akamon.slots.model.Reel modelReel = new com.akamon.slots.model.Reel(xmlReel.name, modelSymbolSet);
            for(WeightedList.Item item : xmlReel.item)
            {
                String symName = item.value;
                int weight = item.weight;
                modelReel.addSymbolToEnd(symName, weight);
            }
            modelReelGrid.addReel(modelReel);
        }

        for (ReelGrid.GridMappingList.GridMapping xmlGridMapping : xmlReelGrid.gridMappingList.gridMapping)
        {
            Coord xmlCoord = xmlGridMapping.coord;
            int offset = xmlGridMapping.offset;
            String reelName = xmlGridMapping.reel;
            modelReelGrid.setReelPopulationOffset(new com.akamon.slots.model.Coordinate(xmlCoord.x, xmlCoord.y), reelName, offset);
        }
        return modelReelGrid;
    }

    protected com.akamon.slots.model.SymbolSet ParseSymbolSet(SymbolSet xmlSymbolSet) throws SlotModelException {

        com.akamon.slots.model.SymbolSet modelSymbolSet = new com.akamon.slots.model.SymbolSet(xmlSymbolSet.name);

        for(NaturalSymbol xmlNaturalSymbol : xmlSymbolSet.getNaturalSymbol())
        {
            modelSymbolSet.addNaturalSymbol(xmlNaturalSymbol.name);
        }

        for(SymbolClassPlaceHolder xmlSymbolClassPlaceholder : xmlSymbolSet.symbolClassName)
        {
            modelSymbolSet.addSymbolClassName(xmlSymbolClassPlaceholder.name, xmlSymbolClassPlaceholder.type.equals("Exclude"));
        }

        for(SubstitutionScheme xmlSubScheme : xmlSymbolSet.substitutionScheme)
        {
            modelSymbolSet.createSubstitutionScheme(xmlSubScheme.name, xmlSubScheme._default != null && xmlSubScheme.isDefault());
            for (SymbolClass symbolClass : xmlSubScheme.getSymbol())
            {
                for(SymbolClass.ComponentSymbol component : symbolClass.componentSymbol)
                {
                    modelSymbolSet.addSubstitution(xmlSubScheme.name, symbolClass.name, component.symbolname);
                }
            }
        }

        return modelSymbolSet;
    }
}
