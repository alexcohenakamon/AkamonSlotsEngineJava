
package com.akamon.slots.xmlmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BetClass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BetClass">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="basebet" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="betMultList" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BetClass", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
public class BetClass {

    @XmlAttribute(name = "basebet", required = true)
    protected int basebet;
    @XmlAttribute(name = "betMultList", required = true)
    protected String betMultList;

    /**
     * Gets the value of the basebet property.
     * 
     */
    public int getBasebet() {
        return basebet;
    }

    /**
     * Sets the value of the basebet property.
     * 
     */
    public void setBasebet(int value) {
        this.basebet = value;
    }

    /**
     * Gets the value of the betMultList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBetMultList() {
        return betMultList;
    }

    /**
     * Sets the value of the betMultList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBetMultList(String value) {
        this.betMultList = value;
    }

}
