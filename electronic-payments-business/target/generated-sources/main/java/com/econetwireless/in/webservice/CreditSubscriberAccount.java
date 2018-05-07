
package com.econetwireless.in.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for creditSubscriberAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="creditSubscriberAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="creditRequest" type="{http://service.soap.in.econetwireless.com/}creditRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creditSubscriberAccount", propOrder = {
    "creditRequest"
})
public class CreditSubscriberAccount {

    protected CreditRequest creditRequest;

    /**
     * Gets the value of the creditRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CreditRequest }
     *     
     */
    public CreditRequest getCreditRequest() {
        return creditRequest;
    }

    /**
     * Sets the value of the creditRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditRequest }
     *     
     */
    public void setCreditRequest(CreditRequest value) {
        this.creditRequest = value;
    }

}
