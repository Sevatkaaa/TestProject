package com.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeTest {

    private static final DateFormat DATE_FORMAT = SimpleDateFormat.getDateInstance(SimpleDateFormat.LONG, Locale.CHINA);

    public static void main(String[] args) {
        Date now = new Date();
        long time = now.getTime() + 8 * 60 * 1000;
        System.out.println(time);
        System.out.println(DATE_FORMAT.format(new Date(1623393710811L)));
        System.out.println(DATE_FORMAT.format(1623393710811L));
    }
}
