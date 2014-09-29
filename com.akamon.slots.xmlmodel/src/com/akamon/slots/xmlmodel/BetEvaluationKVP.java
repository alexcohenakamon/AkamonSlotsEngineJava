
package com.akamon.slots.xmlmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BetEvaluationKVP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BetEvaluationKVP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BetClass" type="{http://www.akamon.com/slots/gameconfigdata.xsd}BetClass"/>
 *         &lt;element name="ReelGridMapping" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="EvaluationPatternWinKVP" type="{http://www.akamon.com/slots/gameconfigdata.xsd}EvaluationPatternWinKVP" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="ReelGrid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BetEvaluationKVP", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", propOrder = {
    "betClass",
    "reelGridMapping"
})
public class BetEvaluationKVP {

    @XmlElement(name = "BetClass", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected BetClass betClass;
    @XmlElement(name = "ReelGridMapping", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected List<BetEvaluationKVP.ReelGridMapping> reelGridMapping;

    /**
     * Gets the value of the betClass property.
     * 
     * @return
     *     possible object is
     *     {@link BetClass }
     *     
     */
    public BetClass getBetClass() {
        return betClass;
    }

    /**
     * Sets the value of the betClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link BetClass }
     *     
     */
    public void setBetClass(BetClass value) {
        this.betClass = value;
    }

    /**
     * Gets the value of the reelGridMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reelGridMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReelGridMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BetEvaluationKVP.ReelGridMapping }
     * 
     * 
     */
    public List<BetEvaluationKVP.ReelGridMapping> getReelGridMapping() {
        if (reelGridMapping == null) {
            reelGridMapping = new ArrayList<BetEvaluationKVP.ReelGridMapping>();
        }
        return this.reelGridMapping;
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
     *         &lt;element name="EvaluationPatternWinKVP" type="{http://www.akamon.com/slots/gameconfigdata.xsd}EvaluationPatternWinKVP" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="ReelGrid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "evaluationPatternWinKVP"
    })
    public static class ReelGridMapping {

        @XmlElement(name = "EvaluationPatternWinKVP", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
        protected List<EvaluationPatternWinKVP> evaluationPatternWinKVP;
        @XmlAttribute(name = "ReelGrid", required = true)
        protected String reelGrid;

        /**
         * Gets the value of the evaluationPatternWinKVP property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the evaluationPatternWinKVP property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEvaluationPatternWinKVP().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EvaluationPatternWinKVP }
         * 
         * 
         */
        public List<EvaluationPatternWinKVP> getEvaluationPatternWinKVP() {
            if (evaluationPatternWinKVP == null) {
                evaluationPatternWinKVP = new ArrayList<EvaluationPatternWinKVP>();
            }
            return this.evaluationPatternWinKVP;
        }

        /**
         * Gets the value of the reelGrid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReelGrid() {
            return reelGrid;
        }

        /**
         * Sets the value of the reelGrid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReelGrid(String value) {
            this.reelGrid = value;
        }

    }

}
