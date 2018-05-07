package com.econetwireless.epay.business.integrations.impl;

import com.econetwireless.epay.business.integrations.api.ChargingPlatform;
import com.econetwireless.epay.business.utils.MessageConverters;
import com.econetwireless.in.soap.messages.CreditRequest;
//import com.econetwireless.in.webservice.CreditRequest;
//import com.econetwireless.in.webservice.IntelligentNetworkService;
import com.econetwireless.in.soap.service.IntelligentNetworkService;
import com.econetwireless.utils.pojo.INBalanceResponse;
import com.econetwireless.utils.pojo.INCreditRequest;
import com.econetwireless.utils.pojo.INCreditResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * Created by tnyamakura on 17/3/2017.
 * Modified by tnyakama on 5/5/2018 (see issues log).
 */

public class ChargingPlatformImpl implements ChargingPlatform{
  public ChargingPlatformImpl(){
  }
  @Autowired
    private IntelligentNetworkService intelligentNetworkService;

    public ChargingPlatformImpl(IntelligentNetworkService intelligentNetworkService) {
        this.intelligentNetworkService = intelligentNetworkService;
    }
  
    @Bean
    @Override
    public INBalanceResponse enquireBalance(final String partnerCode, final String msisdn) {
        return MessageConverters.convert(intelligentNetworkService.enquireBalance(partnerCode, msisdn));
    }
  @Bean
    @Override
    public INCreditResponse creditSubscriberAccount(final INCreditRequest inCreditRequest) {
        final CreditRequest creditRequest = MessageConverters.convert(inCreditRequest);
        return MessageConverters.convert(intelligentNetworkService.creditSubscriberAccount(creditRequest));
    }
}
