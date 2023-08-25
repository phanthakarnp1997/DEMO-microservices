package com.example.microservice.commonlibrary.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String formatDateDefault(Date date) {
        return formatDate(date, DEFAULT_DATE_FORMAT);
    }

    public static Date getCurrentUtcDate() {
        return new Date();
    }

    public static String getCurrentUtcDateString() {
        return formatDateDefault(getCurrentUtcDate());
    }
}
