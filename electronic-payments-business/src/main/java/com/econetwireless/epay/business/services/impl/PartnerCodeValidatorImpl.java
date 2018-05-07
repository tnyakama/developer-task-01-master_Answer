package com.econetwireless.epay.business.services.impl;

import com.econetwireless.epay.business.services.api.PartnerCodeValidator;
import com.econetwireless.epay.dao.requestpartner.api.RequestPartnerDao;
import com.econetwireless.utils.enums.ResponseCode;
import com.econetwireless.utils.execeptions.EpayException;

/**
 * Created by tnyamakura on 18/3/2017.
 * Modified by tnyakama on 6/5/2018(see issues log)
 */
public class PartnerCodeValidatorImpl implements PartnerCodeValidator{

    private RequestPartnerDao requestPartnerDao;
    

    public PartnerCodeValidatorImpl(RequestPartnerDao requestPartnerDao) {
        super();
        this.requestPartnerDao = requestPartnerDao;
    }

    @Override
    public boolean validatePartnerCode(final String partnerCode) {
        final boolean isValidPartner = requestPartnerDao.findByCode(partnerCode) != null;
        if(!isValidPartner) {
            throw new EpayException(ResponseCode.INVALID_REQUEST, "Invalid partner code supplied : "+partnerCode);
        }
        return isValidPartner;
    }
}
