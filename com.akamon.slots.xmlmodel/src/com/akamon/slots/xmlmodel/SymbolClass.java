
package com.akamon.slots.xmlmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SymbolClass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SymbolClass">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.akamon.com/slots/gameconfigdata.xsd}Symbol">
 *       &lt;sequence>
 *         &lt;element name="ComponentSymbol" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="symbolname" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SymbolClass", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", propOrder = {
    "componentSymbol"
})
public class SymbolClass
    extends Symbol
{

    @XmlElement(name = "ComponentSymbol", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected List<SymbolClass.ComponentSymbol> componentSymbol;

    /**
     * Gets the value of the componentSymbol property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the componentSymbol property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComponentSymbol().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SymbolClass.ComponentSymbol }
     * 
     * 
     */
    public List<SymbolClass.ComponentSymbol> getComponentSymbol() {
        if (componentSymbol == null) {
            componentSymbol = new ArrayList<SymbolClass.ComponentSymbol>();
        }
        return this.componentSymbol;
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
     *       &lt;attribute name="symbolname" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ComponentSymbol {

        @XmlAttribute(name = "symbolname", required = true)
        protected String symbolname;

        /**
         * Gets the value of the symbolname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSymbolname() {
            return symbolname;
        }

        /**
         * Sets the value of the symbolname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSymbolname(String value) {
            this.symbolname = value;
        }

    }

}
