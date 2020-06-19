package com.violetacorp.tdd.isbnvalidator.business.impl;

import com.violetacorp.tdd.isbnvalidator.business.ISBNValidator;
import org.apache.commons.lang3.StringUtils;

public class TenISBNValidator implements ISBNValidator {
    @Override
    public boolean checkNumber(String isbnNumber) {
        var lastChar = isbnNumber.charAt(isbnLength - 1);
        var lastCharIsAnX = lastChar == 'X';
        if (!StringUtils.isNumeric(isbnNumber.substring(0, isbnLength - 1))
                || (!lastCharIsAnX && !StringUtils.isNumeric(String.valueOf(lastChar))))
            throw new NumberFormatException("ISBN Number is not numeric");

        var multipleNumber = 10;
        var total = 0;
        for (char c : isbnNumber.toCharArray()) {
            total += multipleNumber * (lastCharIsAnX ? 10 : (int) c);
            multipleNumber--;

        }
        return total % 11 == 0;
    }
}
