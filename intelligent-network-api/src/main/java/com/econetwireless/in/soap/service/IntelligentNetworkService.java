package com.econetwireless.in.soap.service;

import com.econetwireless.in.soap.messages.BalanceResponse;
import com.econetwireless.in.soap.messages.CreditRequest;
import com.econetwireless.in.soap.messages.CreditResponse;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by tnyamakura on 17/3/2017.
 */
// Modified by tnyakama 04/05/18 (see issues log). 

@Service
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface IntelligentNetworkService {
    @Bean
    BalanceResponse enquireBalance(@WebParam(name = "partnerCode") String partnerCode, @WebParam(name = "msisdn") String msisdn);
    @Bean
    CreditResponse  creditSubscriberAccount(@WebParam(name = "creditRequest") CreditRequest creditRequest);
}