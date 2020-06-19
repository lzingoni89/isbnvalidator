package com.violetacorp.tdd.isbnvalidator.service.impl;

import com.violetacorp.tdd.isbnvalidator.service.ISBNValidatorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ISBNValidatorServiceImpl implements ISBNValidatorService {
    @Override
    public boolean checkISBNNumber(String isbnNumber) {
        if (isbnNumber == null) return false;

        isbnNumber = isbnNumber.replace("-", "");
        var isbnLength = isbnNumber.length();
        if (isbnLength != 10 && isbnLength != 13) throw new NumberFormatException("ISBN Number has incorrect length");
        

    }

}
