
package com.akamon.slots.xmlmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EvaluationPatternWinKVP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EvaluationPatternWinKVP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WinCombinationSetUsed" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="WinCombinationSetName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="EvaluationPatternSetName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvaluationPatternWinKVP", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", propOrder = {
    "winCombinationSetUsed"
})
public class EvaluationPatternWinKVP {

    @XmlElement(name = "WinCombinationSetUsed", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected List<EvaluationPatternWinKVP.WinCombinationSetUsed> winCombinationSetUsed;
    @XmlAttribute(name = "EvaluationPatternSetName", required = true)
    protected String evaluationPatternSetName;

    /**
     * Gets the value of the winCombinationSetUsed property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the winCombinationSetUsed property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWinCombinationSetUsed().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EvaluationPatternWinKVP.WinCombinationSetUsed }
     * 
     * 
     */
    public List<EvaluationPatternWinKVP.WinCombinationSetUsed> getWinCombinationSetUsed() {
        if (winCombinationSetUsed == null) {
            winCombinationSetUsed = new ArrayList<EvaluationPatternWinKVP.WinCombinationSetUsed>();
        }
        return this.winCombinationSetUsed;
    }

    /**
     * Gets the value of the evaluationPatternSetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvaluationPatternSetName() {
        return evaluationPatternSetName;
    }

    /**
     * Sets the value of the evaluationPatternSetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvaluationPatternSetName(String value) {
        this.evaluationPatternSetName = value;
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
     *       &lt;attribute name="WinCombinationSetName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class WinCombinationSetUsed {

        @XmlAttribute(name = "WinCombinationSetName", required = true)
        protected String winCombinationSetName;

        /**
         * Gets the value of the winCombinationSetName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWinCombinationSetName() {
            return winCombinationSetName;
        }

        /**
         * Sets the value of the winCombinationSetName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWinCombinationSetName(String value) {
            this.winCombinationSetName = value;
        }

    }

}
