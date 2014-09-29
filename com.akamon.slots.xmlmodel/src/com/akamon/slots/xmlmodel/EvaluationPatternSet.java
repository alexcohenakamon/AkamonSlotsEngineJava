
package com.akamon.slots.xmlmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EvaluationPatternSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EvaluationPatternSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IncludeEvaluationPattern" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="EvaluationPatternName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvaluationPatternSet", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", propOrder = {
    "includeEvaluationPattern"
})
public class EvaluationPatternSet {

    @XmlElement(name = "IncludeEvaluationPattern", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
    protected List<EvaluationPatternSet.IncludeEvaluationPattern> includeEvaluationPattern;
    @XmlAttribute(name = "name", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String name;

    /**
     * Gets the value of the includeEvaluationPattern property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includeEvaluationPattern property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludeEvaluationPattern().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EvaluationPatternSet.IncludeEvaluationPattern }
     * 
     * 
     */
    public List<EvaluationPatternSet.IncludeEvaluationPattern> getIncludeEvaluationPattern() {
        if (includeEvaluationPattern == null) {
            includeEvaluationPattern = new ArrayList<EvaluationPatternSet.IncludeEvaluationPattern>();
        }
        return this.includeEvaluationPattern;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     *       &lt;attribute name="EvaluationPatternName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class IncludeEvaluationPattern {

        @XmlAttribute(name = "EvaluationPatternName", required = true)
        protected String evaluationPatternName;

        /**
         * Gets the value of the evaluationPatternName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEvaluationPatternName() {
            return evaluationPatternName;
        }

        /**
         * Sets the value of the evaluationPatternName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEvaluationPatternName(String value) {
            this.evaluationPatternName = value;
        }

    }

}
