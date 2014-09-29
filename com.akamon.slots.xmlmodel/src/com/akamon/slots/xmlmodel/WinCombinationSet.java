
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
 * <p>Java class for WinCombinationSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WinCombinationSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WinCombination" type="{http://www.akamon.com/slots/gameconfigdata.xsd}WinCombination" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="SymbolSetUsed" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WinCombinationSet", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", propOrder = {
    "winCombination"
})
public class WinCombinationSet {

    @XmlElement(name = "WinCombination", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
    protected List<WinCombination> winCombination;
    @XmlAttribute(name = "name", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String name;
    @XmlAttribute(name = "SymbolSetUsed", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String symbolSetUsed;

    /**
     * Gets the value of the winCombination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the winCombination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWinCombination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WinCombination }
     * 
     * 
     */
    public List<WinCombination> getWinCombination() {
        if (winCombination == null) {
            winCombination = new ArrayList<WinCombination>();
        }
        return this.winCombination;
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
     * Gets the value of the symbolSetUsed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbolSetUsed() {
        return symbolSetUsed;
    }

    /**
     * Sets the value of the symbolSetUsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbolSetUsed(String value) {
        this.symbolSetUsed = value;
    }

}
