package com.cdkj.loan.common;

import org.apache.commons.lang3.StringUtils;

public class NumberUtil {
    public static Integer parseInt(String number) {
        if (StringUtils.isNotBlank(number)) {
            return Integer.parseInt(number);
        }
        return null;
    }
}
