package com.okay.test.utils;


import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateUtil {

    private static String df_yyyy_mm_dd_hh_mm_ss = "yyyy-MM-dd HH:mm:ss";

    /**
     * @param
     * @param millSec 需要转换的时间   long类型
     * @return 把long 转换成 日期 再转换成String类型
     */
    public static String transferLongToDate(Long millSec) {

        String dateFormat = df_yyyy_mm_dd_hh_mm_ss;

        /**
         *
         dateFormat 指的是你希望转换成的String类型的样式
         */
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }


}