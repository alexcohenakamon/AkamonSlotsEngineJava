
package com.akamon.slots.xmlmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReelGrid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReelGrid">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GridMappingList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="GridMapping" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Coord" type="{http://www.akamon.com/slots/gameconfigdata.xsd}Coord"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="Reel" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="offset" type="{http://www.w3.org/2001/XMLSchema}int" default="0" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Reel" type="{http://www.akamon.com/slots/gameconfigdata.xsd}Reel" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SymbolSet" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReelGrid", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", propOrder = {
    "gridMappingList",
    "reel"
})
public class ReelGrid {

    @XmlElement(name = "GridMappingList", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected ReelGrid.GridMappingList gridMappingList;
    @XmlElement(name = "Reel", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
    protected List<Reel> reel;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "SymbolSet", required = true)
    protected String symbolSet;

    /**
     * Gets the value of the gridMappingList property.
     * 
     * @return
     *     possible object is
     *     {@link ReelGrid.GridMappingList }
     *     
     */
    public ReelGrid.GridMappingList getGridMappingList() {
        return gridMappingList;
    }

    /**
     * Sets the value of the gridMappingList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReelGrid.GridMappingList }
     *     
     */
    public void setGridMappingList(ReelGrid.GridMappingList value) {
        this.gridMappingList = value;
    }

    /**
     * Gets the value of the reel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reel }
     * 
     * 
     */
    public List<Reel> getReel() {
        if (reel == null) {
            reel = new ArrayList<Reel>();
        }
        return this.reel;
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
     * Gets the value of the symbolSet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbolSet() {
        return symbolSet;
    }

    /**
     * Sets the value of the symbolSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbolSet(String value) {
        this.symbolSet = value;
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
     *         &lt;element name="GridMapping" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Coord" type="{http://www.akamon.com/slots/gameconfigdata.xsd}Coord"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Reel" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="offset" type="{http://www.w3.org/2001/XMLSchema}int" default="0" />
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
    @XmlType(name = "", propOrder = {
        "gridMapping"
    })
    public static class GridMappingList {

        @XmlElement(name = "GridMapping", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd")
        protected List<ReelGrid.GridMappingList.GridMapping> gridMapping;

        /**
         * Gets the value of the gridMapping property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the gridMapping property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGridMapping().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ReelGrid.GridMappingList.GridMapping }
         * 
         * 
         */
        public List<ReelGrid.GridMappingList.GridMapping> getGridMapping() {
            if (gridMapping == null) {
                gridMapping = new ArrayList<ReelGrid.GridMappingList.GridMapping>();
            }
            return this.gridMapping;
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
         *         &lt;element name="Coord" type="{http://www.akamon.com/slots/gameconfigdata.xsd}Coord"/>
         *       &lt;/sequence>
         *       &lt;attribute name="Reel" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="offset" type="{http://www.w3.org/2001/XMLSchema}int" default="0" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "coord"
        })
        public static class GridMapping {

            @XmlElement(name = "Coord", namespace = "http://www.akamon.com/slots/gameconfigdata.xsd", required = true)
            protected Coord coord;
            @XmlAttribute(name = "Reel", required = true)
            protected String reel;
            @XmlAttribute(name = "offset")
            protected Integer offset;

            /**
             * Gets the value of the coord property.
             * 
             * @return
             *     possible object is
             *     {@link Coord }
             *     
             */
            public Coord getCoord() {
                return coord;
            }

            /**
             * Sets the value of the coord property.
             * 
             * @param value
             *     allowed object is
             *     {@link Coord }
             *     
             */
            public void setCoord(Coord value) {
                this.coord = value;
            }

            /**
             * Gets the value of the reel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReel() {
                return reel;
            }

            /**
             * Sets the value of the reel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReel(String value) {
                this.reel = value;
            }

            /**
             * Gets the value of the offset property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public int getOffset() {
                if (offset == null) {
                    return  0;
                } else {
                    return offset;
                }
            }

            /**
             * Sets the value of the offset property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setOffset(Integer value) {
                this.offset = value;
            }

        }

    }

}
