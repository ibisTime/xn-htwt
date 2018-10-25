package com.cdkj.loan.core;

import com.cdkj.loan.common.DateUtil;

/** 
 * @author: miyb 
 * @since: 2015-5-5 下午1:13:04 
 * @history:
 */
public class OrderNoGenerater {

    /**
     * 产生毫秒级+后5位随机数别主键序列
     * @param prefix
     * @return 
     * @create: 2015年9月28日 下午5:18:38 xieyj
     * @history:
     */
    public static String generate(String prefix) {
        int random = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;
        String today = DateUtil.getToday(DateUtil.DATA_TIME_PATTERN_5);
        return prefix + today + String.valueOf(random);
    }

    /**
     * 随机生成一个7位数，且第一位不为0
     * @return 
     * @create: 2018年10月25日 下午10:20:31 CYL
     * @history:
     */
    public static String random7() {
        Double random = Math.random();
        String str = random.toString().substring(2, 9);
        String sub2 = random.toString().substring(2, 3);
        if (sub2.equals("0")) {
            str = "1" + random.toString().substring(3, 9);
        }
        return str;
    }

}
