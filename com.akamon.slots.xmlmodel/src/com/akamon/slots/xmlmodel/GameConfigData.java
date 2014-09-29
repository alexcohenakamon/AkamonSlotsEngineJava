
package com.akamon.slots.xmlmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GameConfigData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GameConfigData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SymbolSetsList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SymbolSet" type="{http://www.akamon.com/slots/gameconfigdata.xsd}SymbolSet" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ReelGridsList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ReelGrid" type="{http://www.akamon.com/slots/gameconfigdata.xsd}ReelGrid" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="WinCombinationSetList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="WinCombinationSet" type="{http://www.akamon.com/slots/gameconfigdata.xsd}WinCombinationSet" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EvaluationPatternList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="EvaluationPattern" type="{http://www.akamon.com/slots/gameconfigdata.xsd}EvaluationPattern" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EvaluationPatternSetList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="EvaluationPatternSet" type="{http://www.akamon.com/slots/gameconfigdata.xsd}EvaluationPatternSet" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BetEvaluationMapList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BetEvaluationMap" type="{http://www.akamon.com/slots/gameconfigdata.xsd}BetEvaluationMap" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="WeightedLists">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="WeightedList" type="{http://www.akamon.com/slots/gameconfigdata.xsd}WeightedList" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="RTP" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VersionName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DateCreated" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GameConfigData", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", propOrder = {
    "symbolSetsList",
    "reelGridsList",
    "winCombinationSetList",
    "evaluationPatternList",
    "evaluationPatternSetList",
    "betEvaluationMapList",
    "weightedLists"
})
public class GameConfigData {

    @XmlElement(name = "SymbolSetsList", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected GameConfigData.SymbolSetsList symbolSetsList;
    @XmlElement(name = "ReelGridsList", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected GameConfigData.ReelGridsList reelGridsList;
    @XmlElement(name = "WinCombinationSetList", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected GameConfigData.WinCombinationSetList winCombinationSetList;
    @XmlElement(name = "EvaluationPatternList", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected GameConfigData.EvaluationPatternList evaluationPatternList;
    @XmlElement(name = "EvaluationPatternSetList", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected GameConfigData.EvaluationPatternSetList evaluationPatternSetList;
    @XmlElement(name = "BetEvaluationMapList", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected GameConfigData.BetEvaluationMapList betEvaluationMapList;
    @XmlElement(name = "WeightedLists", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected GameConfigData.WeightedLists weightedLists;
    @XmlAttribute(name = "RTP", required = true)
    protected String rtp;
    @XmlAttribute(name = "VersionName", required = true)
    protected String versionName;
    @XmlAttribute(name = "DateCreated", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreated;

    /**
     * Gets the value of the symbolSetsList property.
     * 
     * @return
     *     possible object is
     *     {@link GameConfigData.SymbolSetsList }
     *     
     */
    public GameConfigData.SymbolSetsList getSymbolSetsList() {
        return symbolSetsList;
    }

    /**
     * Sets the value of the symbolSetsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GameConfigData.SymbolSetsList }
     *     
     */
    public void setSymbolSetsList(GameConfigData.SymbolSetsList value) {
        this.symbolSetsList = value;
    }

    /**
     * Gets the value of the reelGridsList property.
     * 
     * @return
     *     possible object is
     *     {@link GameConfigData.ReelGridsList }
     *     
     */
    public GameConfigData.ReelGridsList getReelGridsList() {
        return reelGridsList;
    }

    /**
     * Sets the value of the reelGridsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GameConfigData.ReelGridsList }
     *     
     */
    public void setReelGridsList(GameConfigData.ReelGridsList value) {
        this.reelGridsList = value;
    }

    /**
     * Gets the value of the winCombinationSetList property.
     * 
     * @return
     *     possible object is
     *     {@link GameConfigData.WinCombinationSetList }
     *     
     */
    public GameConfigData.WinCombinationSetList getWinCombinationSetList() {
        return winCombinationSetList;
    }

    /**
     * Sets the value of the winCombinationSetList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GameConfigData.WinCombinationSetList }
     *     
     */
    public void setWinCombinationSetList(GameConfigData.WinCombinationSetList value) {
        this.winCombinationSetList = value;
    }

    /**
     * Gets the value of the evaluationPatternList property.
     * 
     * @return
     *     possible object is
     *     {@link GameConfigData.EvaluationPatternList }
     *     
     */
    public GameConfigData.EvaluationPatternList getEvaluationPatternList() {
        return evaluationPatternList;
    }

    /**
     * Sets the value of the evaluationPatternList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GameConfigData.EvaluationPatternList }
     *     
     */
    public void setEvaluationPatternList(GameConfigData.EvaluationPatternList value) {
        this.evaluationPatternList = value;
    }

    /**
     * Gets the value of the evaluationPatternSetList property.
     * 
     * @return
     *     possible object is
     *     {@link GameConfigData.EvaluationPatternSetList }
     *     
     */
    public GameConfigData.EvaluationPatternSetList getEvaluationPatternSetList() {
        return evaluationPatternSetList;
    }

    /**
     * Sets the value of the evaluationPatternSetList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GameConfigData.EvaluationPatternSetList }
     *     
     */
    public void setEvaluationPatternSetList(GameConfigData.EvaluationPatternSetList value) {
        this.evaluationPatternSetList = value;
    }

    /**
     * Gets the value of the betEvaluationMapList property.
     * 
     * @return
     *     possible object is
     *     {@link GameConfigData.BetEvaluationMapList }
     *     
     */
    public GameConfigData.BetEvaluationMapList getBetEvaluationMapList() {
        return betEvaluationMapList;
    }

    /**
     * Sets the value of the betEvaluationMapList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GameConfigData.BetEvaluationMapList }
     *     
     */
    public void setBetEvaluationMapList(GameConfigData.BetEvaluationMapList value) {
        this.betEvaluationMapList = value;
    }

    /**
     * Gets the value of the weightedLists property.
     * 
     * @return
     *     possible object is
     *     {@link GameConfigData.WeightedLists }
     *     
     */
    public GameConfigData.WeightedLists getWeightedLists() {
        return weightedLists;
    }

    /**
     * Sets the value of the weightedLists property.
     * 
     * @param value
     *     allowed object is
     *     {@link GameConfigData.WeightedLists }
     *     
     */
    public void setWeightedLists(GameConfigData.WeightedLists value) {
        this.weightedLists = value;
    }

    /**
     * Gets the value of the rtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRTP() {
        return rtp;
    }

    /**
     * Sets the value of the rtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRTP(String value) {
        this.rtp = value;
    }

    /**
     * Gets the value of the versionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionName() {
        return versionName;
    }

    /**
     * Sets the value of the versionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionName(String value) {
        this.versionName = value;
    }

    /**
     * Gets the value of the dateCreated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the value of the dateCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreated(XMLGregorianCalendar value) {
        this.dateCreated = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BetEvaluationMap" type="{http://www.akamon.com/slots/gameconfigdata.xsd}BetEvaluationMap" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "betEvaluationMap"
    })
    public static class BetEvaluationMapList {

        @XmlElement(name = "BetEvaluationMap", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
        protected List<BetEvaluationMap> betEvaluationMap;

        /**
         * Gets the value of the betEvaluationMap property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the betEvaluationMap property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBetEvaluationMap().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BetEvaluationMap }
         * 
         * 
         */
        public List<BetEvaluationMap> getBetEvaluationMap() {
            if (betEvaluationMap == null) {
                betEvaluationMap = new ArrayList<BetEvaluationMap>();
            }
            return this.betEvaluationMap;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="EvaluationPattern" type="{http://www.akamon.com/slots/gameconfigdata.xsd}EvaluationPattern" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "evaluationPattern"
    })
    public static class EvaluationPatternList {

        @XmlElement(name = "EvaluationPattern", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
        protected List<EvaluationPattern> evaluationPattern;

        /**
         * Gets the value of the evaluationPattern property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the evaluationPattern property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEvaluationPattern().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EvaluationPattern }
         * 
         * 
         */
        public List<EvaluationPattern> getEvaluationPattern() {
            if (evaluationPattern == null) {
                evaluationPattern = new ArrayList<EvaluationPattern>();
            }
            return this.evaluationPattern;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="EvaluationPatternSet" type="{http://www.akamon.com/slots/gameconfigdata.xsd}EvaluationPatternSet" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "evaluationPatternSet"
    })
    public static class EvaluationPatternSetList {

        @XmlElement(name = "EvaluationPatternSet", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
        protected List<EvaluationPatternSet> evaluationPatternSet;

        /**
         * Gets the value of the evaluationPatternSet property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the evaluationPatternSet property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEvaluationPatternSet().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EvaluationPatternSet }
         * 
         * 
         */
        public List<EvaluationPatternSet> getEvaluationPatternSet() {
            if (evaluationPatternSet == null) {
                evaluationPatternSet = new ArrayList<EvaluationPatternSet>();
            }
            return this.evaluationPatternSet;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ReelGrid" type="{http://www.akamon.com/slots/gameconfigdata.xsd}ReelGrid" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "reelGrid"
    })
    public static class ReelGridsList {

        @XmlElement(name = "ReelGrid", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
        protected List<ReelGrid> reelGrid;

        /**
         * Gets the value of the reelGrid property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the reelGrid property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReelGrid().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ReelGrid }
         * 
         * 
         */
        public List<ReelGrid> getReelGrid() {
            if (reelGrid == null) {
                reelGrid = new ArrayList<ReelGrid>();
            }
            return this.reelGrid;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="SymbolSet" type="{http://www.akamon.com/slots/gameconfigdata.xsd}SymbolSet" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "symbolSet"
    })
    public static class SymbolSetsList {

        @XmlElement(name = "SymbolSet", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
        protected List<SymbolSet> symbolSet;

        /**
         * Gets the value of the symbolSet property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the symbolSet property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSymbolSet().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SymbolSet }
         * 
         * 
         */
        public List<SymbolSet> getSymbolSet() {
            if (symbolSet == null) {
                symbolSet = new ArrayList<SymbolSet>();
            }
            return this.symbolSet;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="WeightedList" type="{http://www.akamon.com/slots/gameconfigdata.xsd}WeightedList" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "weightedList"
    })
    public static class WeightedLists {

        @XmlElement(name = "WeightedList", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
        protected List<WeightedList> weightedList;

        /**
         * Gets the value of the weightedList property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the weightedList property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWeightedList().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link WeightedList }
         * 
         * 
         */
        public List<WeightedList> getWeightedList() {
            if (weightedList == null) {
                weightedList = new ArrayList<WeightedList>();
            }
            return this.weightedList;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="WinCombinationSet" type="{http://www.akamon.com/slots/gameconfigdata.xsd}WinCombinationSet" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "winCombinationSet"
    })
    public static class WinCombinationSetList {

        @XmlElement(name = "WinCombinationSet", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
        protected List<WinCombinationSet> winCombinationSet;

        /**
         * Gets the value of the winCombinationSet property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the winCombinationSet property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWinCombinationSet().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link WinCombinationSet }
         * 
         * 
         */
        public List<WinCombinationSet> getWinCombinationSet() {
            if (winCombinationSet == null) {
                winCombinationSet = new ArrayList<WinCombinationSet>();
            }
            return this.winCombinationSet;
        }

    }

}
