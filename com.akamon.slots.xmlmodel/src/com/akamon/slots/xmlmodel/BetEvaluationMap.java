
package com.akamon.slots.xmlmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BetEvaluationMap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BetEvaluationMap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BetEvaluationKVP" type="{http://www.akamon.com/slots/gameconfigdata.xsd}BetEvaluationKVP" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BetEvaluationMap", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", propOrder = {
    "betEvaluationKVP"
})
public class BetEvaluationMap {

    @XmlElement(name = "BetEvaluationKVP", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
    protected List<BetEvaluationKVP> betEvaluationKVP;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the betEvaluationKVP property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the betEvaluationKVP property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBetEvaluationKVP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BetEvaluationKVP }
     * 
     * 
     */
    public List<BetEvaluationKVP> getBetEvaluationKVP() {
        if (betEvaluationKVP == null) {
            betEvaluationKVP = new ArrayList<BetEvaluationKVP>();
        }
        return this.betEvaluationKVP;
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

}
