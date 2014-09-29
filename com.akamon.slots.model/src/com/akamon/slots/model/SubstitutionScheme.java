package com.akamon.slots.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/8/14
 * Time: 7:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubstitutionScheme {

    protected HashMap<Integer,SymbolClass> symbolsById;
    protected String name;
    protected SymbolSet symbolSet;

    public SubstitutionScheme() {

    }

    protected SubstitutionScheme(SymbolSet symbolSet,String name){
        this.symbolSet = symbolSet;
        this.symbolsById = new HashMap<Integer, SymbolClass>();
        this.name = name;

        for (String symName : symbolSet.allSymbolNamesToId.keySet())
        {
            SymbolClass symbolClass = new SymbolClass(symName, 0, symbolSet.allSymbolNamesToId.get(symName), symbolSet);
            if (symbolSet.naturalSymbolsByName.containsKey(symName))
            {
                NaturalSymbol natSymbol = symbolSet.naturalSymbolsByName.get(symName);
                symbolClass.addComponentSymbol(natSymbol);
            }

            symbolsById.put(symbolSet.allSymbolNamesToId.get(symName),symbolClass);
        }
    }

    public SymbolClass getSubstitutionSymbol(Symbol symbol) {
        return symbolsById.get(symbol.id);
    }

    public void addSymbolSubstitution(String symbolClassName, String naturalSymbolIncluded) {
        SymbolClass subSymbol = symbolsById.get(symbolSet.allSymbolNamesToId.get(symbolClassName));
        NaturalSymbol naturalSymbol = symbolSet.naturalSymbolsByName.get(naturalSymbolIncluded);
        if (!subSymbol.componentSymbols.contains(naturalSymbol))
        {
            subSymbol.addComponentSymbol(naturalSymbol);
        }
    }

    public String getName() {
        return name;
    }

    public SymbolSet getSymbolSet() {
        return symbolSet;
    }

    public boolean isMatch(Symbol moreInclusive, Symbol lessInclusive) {
        return simpleIsMatch(moreInclusive,lessInclusive);
    }

    private boolean simpleIsMatch(Symbol moreInclusive,Symbol lessInclusive) {
        long moreInclusiveBitMaskValue = getSubstitutionSymbol(moreInclusive).bitMaskValue;
        return (moreInclusiveBitMaskValue | lessInclusive.bitMaskValue) == moreInclusiveBitMaskValue;
    }

}
