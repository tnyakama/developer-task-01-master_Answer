package com.econetwireless.epay.business.services.impl;

import com.econetwireless.epay.business.integrations.api.ChargingPlatform;
import com.econetwireless.epay.business.services.api.CreditsService;
import com.econetwireless.epay.dao.subscriberrequest.api.SubscriberRequestDao;
import com.econetwireless.epay.domain.SubscriberRequest;
import com.econetwireless.utils.constants.SystemConstants;
import com.econetwireless.utils.enums.ResponseCode;
import com.econetwireless.utils.messages.AirtimeTopupRequest;
import com.econetwireless.utils.messages.AirtimeTopupResponse;
import com.econetwireless.utils.pojo.INCreditRequest;
import com.econetwireless.utils.pojo.INCreditResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tnyamakura on 17/3/2017.
 * Modified by tnyakama on 6/5/2018 (see issues log)
 */
@Service
@Transactional
public class CreditsServiceImpl implements CreditsService{

    CreditsServiceImpl(){}
    private static final Logger LOGGER = LoggerFactory.getLogger(CreditsServiceImpl.class);
    
    private ChargingPlatform chargingPlatform;
    private SubscriberRequestDao subscriberRequestDao;
   
    public CreditsServiceImpl(ChargingPlatform chargingPlatform, SubscriberRequestDao subscriberRequestDao) {
        this.chargingPlatform = chargingPlatform;
        this.subscriberRequestDao = subscriberRequestDao;
    }
  @Bean
    @Override
    public AirtimeTopupResponse credit(final AirtimeTopupRequest airtimeTopupRequest) {
        LOGGER.info("Credit airtime Request : {}", airtimeTopupRequest);
        final AirtimeTopupResponse airtimeTopupResponse = new AirtimeTopupResponse();
        final SubscriberRequest subscriberRequest = populateSubscriberRequest(airtimeTopupRequest);
        
        final SubscriberRequest createdSubscriberRequest = subscriberRequestDao.save(subscriberRequest);
        final INCreditResponse inCreditResponse = chargingPlatform.creditSubscriberAccount(populate(airtimeTopupRequest));
        changeSubscriberRequestStatusOnCredit(createdSubscriberRequest, inCreditResponse);
        subscriberRequestDao.save(createdSubscriberRequest);
        airtimeTopupResponse.setResponseCode(inCreditResponse.getResponseCode());
        airtimeTopupResponse.setNarrative(inCreditResponse.getNarrative());
        airtimeTopupResponse.setMsisdn(airtimeTopupRequest.getMsisdn());
        airtimeTopupResponse.setBalance(inCreditResponse.getBalance());
        LOGGER.info("Finished Airtime Credit :: Msisdn : {}, response code : {}", airtimeTopupRequest.getMsisdn(), inCreditResponse.getResponseCode());
        return airtimeTopupResponse;
    }
@Bean
    private static void changeSubscriberRequestStatusOnCredit(final SubscriberRequest subscriberRequest, final INCreditResponse inCreditResponse) {
        final boolean isSuccessfulResponse = ResponseCode.SUCCESS.getCode().equalsIgnoreCase(inCreditResponse.getResponseCode());
        if(!isSuccessfulResponse) {
            subscriberRequest.setStatus(SystemConstants.STATUS_FAILED);
        } else {
            subscriberRequest.setStatus(SystemConstants.STATUS_SUCCESSFUL);
            subscriberRequest.setBalanceAfter(inCreditResponse.getBalance());
            subscriberRequest.setBalanceBefore(inCreditResponse.getBalance() - subscriberRequest.getAmount());
        }
    }
    @Bean
    private static SubscriberRequest populateSubscriberRequest(final AirtimeTopupRequest airtimeTopupRequest) {
        final SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setRequestType(SystemConstants.REQUEST_TYPE_AIRTIME_TOPUP);
        subscriberRequest.setPartnerCode(airtimeTopupRequest.getPartnerCode());
        subscriberRequest.setMsisdn(airtimeTopupRequest.getMsisdn());
        subscriberRequest.setReference(airtimeTopupRequest.getReferenceNumber());
        subscriberRequest.setAmount(airtimeTopupRequest.getAmount());
        return subscriberRequest;
    }
    @Bean
    private static INCreditRequest populate(final AirtimeTopupRequest airtimeTopupRequest) {
        final INCreditRequest inCreditRequest = new INCreditRequest();
        inCreditRequest.setAmount(airtimeTopupRequest.getAmount());
        inCreditRequest.setMsisdn(airtimeTopupRequest.getMsisdn());
        inCreditRequest.setPartnerCode(airtimeTopupRequest.getPartnerCode());
        inCreditRequest.setReferenceNumber(airtimeTopupRequest.getReferenceNumber());
        return inCreditRequest;
    }

}
