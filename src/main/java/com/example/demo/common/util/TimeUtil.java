package com.example.demo.common.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeUtil {
    public static final long DAY_TIME_STAMP = 24 * 60 * 60;

    public static final long HOUR_TIME_STAMP = 60 * 60;

    public static final long MINUTE_TIME_STAMP = 60;

    public static final String FORMAT_STR = "yyMMddHHmmss";

    public static final String FORMAT_PATTERN_SECOND = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_PATTERN_SECOND_2 = "yyyyMMddHHmmss";

    public static final String FORMAT_PATTERN_DAY = "yyyyMMdd";

    public static final String FORMAT_PATTERN_DAY_2 = "yyyy-MM-dd";

    public static final String FORMAT_PATTERN_3 = "yyMMdd";

    public static final String FORMAT_MILLISECOND = "yyMMddHHmmssSSS";

    public static final String FORMAT_PATTERN_HOUR = "MM-dd HH:mm";
}
