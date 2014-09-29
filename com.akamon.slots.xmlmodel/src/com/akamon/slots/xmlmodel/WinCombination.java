
package com.akamon.slots.xmlmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WinCombination complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WinCombination">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SymbolWinElement" type="{http://www.akamon.com/slots/gameconfigdata.xsd}SymbolWinElement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Trigger" type="{http://www.akamon.com/slots/gameconfigdata.xsd}Trigger" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="basepay" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="sortpriority" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="payMultiplicationType" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="BetMult"/>
 *             &lt;enumeration value="TotalBet"/>
 *             &lt;enumeration value="None"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WinCombination", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", propOrder = {
    "symbolWinElement",
    "trigger"
})
public class WinCombination {

    @XmlElement(name = "SymbolWinElement", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
    protected List<SymbolWinElement> symbolWinElement;
    @XmlElement(name = "Trigger", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
    protected List<Trigger> trigger;
    @XmlAttribute(name = "basepay")
    protected Integer basepay;
    @XmlAttribute(name = "sortpriority")
    protected Integer sortpriority;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "payMultiplicationType", required = true)
    protected String payMultiplicationType;

    /**
     * Gets the value of the symbolWinElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the symbolWinElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSymbolWinElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SymbolWinElement }
     * 
     * 
     */
    public List<SymbolWinElement> getSymbolWinElement() {
        if (symbolWinElement == null) {
            symbolWinElement = new ArrayList<SymbolWinElement>();
        }
        return this.symbolWinElement;
    }

    /**
     * Gets the value of the trigger property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trigger property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrigger().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Trigger }
     * 
     * 
     */
    public List<Trigger> getTrigger() {
        if (trigger == null) {
            trigger = new ArrayList<Trigger>();
        }
        return this.trigger;
    }

    /**
     * Gets the value of the basepay property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBasepay() {
        return basepay;
    }

    /**
     * Sets the value of the basepay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBasepay(Integer value) {
        this.basepay = value;
    }

    /**
     * Gets the value of the sortpriority property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSortpriority() {
        return sortpriority;
    }

    /**
     * Sets the value of the sortpriority property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSortpriority(Integer value) {
        this.sortpriority = value;
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
     * Gets the value of the payMultiplicationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayMultiplicationType() {
        return payMultiplicationType;
    }

    /**
     * Sets the value of the payMultiplicationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayMultiplicationType(String value) {
        this.payMultiplicationType = value;
    }

}
