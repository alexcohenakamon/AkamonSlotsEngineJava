
package com.akamon.slots.xmlmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SymbolSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SymbolSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NaturalSymbol" type="{http://www.akamon.com/slots/gameconfigdata.xsd}NaturalSymbol" maxOccurs="63" minOccurs="0"/>
 *         &lt;element name="SymbolClassName" type="{http://www.akamon.com/slots/gameconfigdata.xsd}SymbolClassPlaceHolder" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SubstitutionScheme" type="{http://www.akamon.com/slots/gameconfigdata.xsd}SubstitutionScheme" maxOccurs="unbounded"/>
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
@XmlType(name = "SymbolSet", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", propOrder = {
    "naturalSymbol",
    "symbolClassName",
    "substitutionScheme"
})
public class SymbolSet {

    @XmlElement(name = "NaturalSymbol", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
    protected List<NaturalSymbol> naturalSymbol;
    @XmlElement(name = "SymbolClassName", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
    protected List<SymbolClassPlaceHolder> symbolClassName;
    @XmlElement(name = "SubstitutionScheme", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected List<SubstitutionScheme> substitutionScheme;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the naturalSymbol property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the naturalSymbol property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNaturalSymbol().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NaturalSymbol }
     * 
     * 
     */
    public List<NaturalSymbol> getNaturalSymbol() {
        if (naturalSymbol == null) {
            naturalSymbol = new ArrayList<NaturalSymbol>();
        }
        return this.naturalSymbol;
    }

    /**
     * Gets the value of the symbolClassName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the symbolClassName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSymbolClassName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SymbolClassPlaceHolder }
     * 
     * 
     */
    public List<SymbolClassPlaceHolder> getSymbolClassName() {
        if (symbolClassName == null) {
            symbolClassName = new ArrayList<SymbolClassPlaceHolder>();
        }
        return this.symbolClassName;
    }

    /**
     * Gets the value of the substitutionScheme property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the substitutionScheme property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubstitutionScheme().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubstitutionScheme }
     * 
     * 
     */
    public List<SubstitutionScheme> getSubstitutionScheme() {
        if (substitutionScheme == null) {
            substitutionScheme = new ArrayList<SubstitutionScheme>();
        }
        return this.substitutionScheme;
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
