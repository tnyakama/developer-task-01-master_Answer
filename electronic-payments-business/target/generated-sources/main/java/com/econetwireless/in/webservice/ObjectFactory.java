
package com.econetwireless.in.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.econetwireless.in.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreditSubscriberAccountResponse_QNAME = new QName("http://service.soap.in.econetwireless.com/", "creditSubscriberAccountResponse");
    private final static QName _EnquireBalanceResponse_QNAME = new QName("http://service.soap.in.econetwireless.com/", "enquireBalanceResponse");
    private final static QName _EnquireBalance_QNAME = new QName("http://service.soap.in.econetwireless.com/", "enquireBalance");
    private final static QName _CreditSubscriberAccount_QNAME = new QName("http://service.soap.in.econetwireless.com/", "creditSubscriberAccount");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.econetwireless.in.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnquireBalance }
     * 
     */
    public EnquireBalance createEnquireBalance() {
        return new EnquireBalance();
    }

    /**
     * Create an instance of {@link EnquireBalanceResponse }
     * 
     */
    public EnquireBalanceResponse createEnquireBalanceResponse() {
        return new EnquireBalanceResponse();
    }

    /**
     * Create an instance of {@link CreditSubscriberAccountResponse }
     * 
     */
    public CreditSubscriberAccountResponse createCreditSubscriberAccountResponse() {
        return new CreditSubscriberAccountResponse();
    }

    /**
     * Create an instance of {@link CreditSubscriberAccount }
     * 
     */
    public CreditSubscriberAccount createCreditSubscriberAccount() {
        return new CreditSubscriberAccount();
    }

    /**
     * Create an instance of {@link CreditRequest }
     * 
     */
    public CreditRequest createCreditRequest() {
        return new CreditRequest();
    }

    /**
     * Create an instance of {@link BalanceResponse }
     * 
     */
    public BalanceResponse createBalanceResponse() {
        return new BalanceResponse();
    }

    /**
     * Create an instance of {@link CreditResponse }
     * 
     */
    public CreditResponse createCreditResponse() {
        return new CreditResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditSubscriberAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.in.econetwireless.com/", name = "creditSubscriberAccountResponse")
    public JAXBElement<CreditSubscriberAccountResponse> createCreditSubscriberAccountResponse(CreditSubscriberAccountResponse value) {
        return new JAXBElement<CreditSubscriberAccountResponse>(_CreditSubscriberAccountResponse_QNAME, CreditSubscriberAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnquireBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.in.econetwireless.com/", name = "enquireBalanceResponse")
    public JAXBElement<EnquireBalanceResponse> createEnquireBalanceResponse(EnquireBalanceResponse value) {
        return new JAXBElement<EnquireBalanceResponse>(_EnquireBalanceResponse_QNAME, EnquireBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnquireBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.in.econetwireless.com/", name = "enquireBalance")
    public JAXBElement<EnquireBalance> createEnquireBalance(EnquireBalance value) {
        return new JAXBElement<EnquireBalance>(_EnquireBalance_QNAME, EnquireBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditSubscriberAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.in.econetwireless.com/", name = "creditSubscriberAccount")
    public JAXBElement<CreditSubscriberAccount> createCreditSubscriberAccount(CreditSubscriberAccount value) {
        return new JAXBElement<CreditSubscriberAccount>(_CreditSubscriberAccount_QNAME, CreditSubscriberAccount.class, null, value);
    }

}
