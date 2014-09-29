package com.akamon.slots.model;

import com.sun.corba.se.impl.interceptors.SlotTableStack;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/7/14
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class SymbolSet {

    protected HashSet<NaturalSymbol> naturalSymbols;
    protected HashMap<String,NaturalSymbol> naturalSymbolsByName;
    protected HashMap<String,Integer> allSymbolNamesToId;
    protected HashMap<Integer,Symbol> allSymbolsById;
    protected HashMap<String,SubstitutionScheme> substitutionSchemeByName;

    protected SubstitutionScheme currentSubstitutionScheme;
    protected SubstitutionScheme defaultSubstitutionScheme;

    protected String name;
    protected int id;

    private int autoIncrementSymbolId;

    public SymbolSet(String name) {
        this.name = name;
        this.naturalSymbols = new HashSet<NaturalSymbol>();
        this.naturalSymbolsByName =new HashMap<String, NaturalSymbol>();
        this.allSymbolNamesToId = new HashMap<String, Integer>();
        this.allSymbolsById = new HashMap<Integer, Symbol>();
        this.substitutionSchemeByName = new HashMap<String, SubstitutionScheme>();
        this.defaultSubstitutionScheme = new SubstitutionScheme(this,"default");
        this.currentSubstitutionScheme = defaultSubstitutionScheme;

        this.autoIncrementSymbolId = 0;
    }

    public NaturalSymbol getNaturalSymbolForName(String name) throws SlotModelException {
        if(naturalSymbolsByName.containsKey(name))
            return naturalSymbolsByName.get(name);
        else
            throw new SlotModelException("Symbol set does not contain natural symbol " + name);
    }

    public Symbol getSymbolForName(String name) throws SlotModelException  {
       if(allSymbolNamesToId.containsKey(name))
           return allSymbolsById.get(allSymbolNamesToId.get(name));
        else
           throw new SlotModelException("Symbol set does not contain symbol " + name);
    }

    public void addNaturalSymbol(String name) throws SlotModelException {
        if(allSymbolNamesToId.containsKey(name))
            throw new SlotModelException("Cannot add symbol with name " + name + ".  Symbol set already contains a symbol with that name");

        int id = autoIncrementSymbolId++;
        long bitMaskValue = (long)Math.pow(2,id);
        NaturalSymbol naturalSymbol = new NaturalSymbol(name,bitMaskValue,id,this);
        naturalSymbols.add(naturalSymbol);
        naturalSymbolsByName.put(name,naturalSymbol);
        allSymbolNamesToId.put(name,id);
        allSymbolsById.put(id,naturalSymbol);
    }

    public void addSymbolClassName(String name,boolean isExcludeSymbol) throws SlotModelException {
        if(allSymbolNamesToId.containsKey(name))
            throw new SlotModelException("Cannot add symbol with name " + name + ".  Symbol set already contains a symbol with that name");

        int id = autoIncrementSymbolId++;
        long bitMaskValue = -1;
        SymbolClass symbolClass = new SymbolClass(name,bitMaskValue,id,this);
        symbolClass.isExcludeSymbol = isExcludeSymbol;
        allSymbolNamesToId.put(name,id);
        allSymbolsById.put(id,symbolClass);
    }

    public void createSubstitutionScheme(String subSchemeName,boolean setAsDefault) throws SlotModelException {
        if (substitutionSchemeByName.containsKey(subSchemeName))
        {
            throw new SlotModelException("Cannot add substitution scheme with with name " + subSchemeName + ".  Symbol set already contains a substitution scheme with that name");
        }

        SubstitutionScheme subScheme = new SubstitutionScheme(this, subSchemeName);

        this.substitutionSchemeByName.put(subSchemeName,subScheme);
        if (setAsDefault)
        {
            defaultSubstitutionScheme = subScheme;
            this.currentSubstitutionScheme = subScheme;
        }
    }

    public void addSubstitution(String substitutionSchemeName,String symbolClassName,String includedSymbolName) throws SlotModelException {
        SubstitutionScheme substitutionScheme = this.substitutionSchemeByName.get(substitutionSchemeName);
        if(substitutionScheme == null)
            throw new SlotModelException("Substitution scheme " + substitutionSchemeName + " does not exist");

        substitutionScheme.addSymbolSubstitution(symbolClassName,includedSymbolName);
    }

    public void addSymbolClassName(String name) throws SlotModelException{
        this.addSymbolClassName(name,false);
    }

    public boolean isMatch(Symbol moreInclusive, Symbol lessInclusive) {
        return currentSubstitutionScheme.isMatch(moreInclusive,lessInclusive);
    }

    public void setSubstitutionScheme(String substitutionSchemeName) throws SlotModelException {
        SubstitutionScheme scheme = substitutionSchemeByName.get(substitutionSchemeName);
        if(scheme == null)
            throw new SlotModelException("No such substitution scheme: " + substitutionSchemeName);
        else
            currentSubstitutionScheme = scheme;

    }

    public int getIdForSymbol(String name) {
        return allSymbolNamesToId.get(name);
    }

    public void setSubstitutionSchemeToDefault() {
        this.currentSubstitutionScheme = defaultSubstitutionScheme;
    }
}
