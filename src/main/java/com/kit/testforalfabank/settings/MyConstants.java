package com.kit.testforalfabank.settings;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class MyConstants {
    public static final Instant TODAY_DATE = Instant.now();
    public static final Instant YESTERDAY_DATE = Instant.now().minus(1, ChronoUnit.DAYS);

    public static final String EXCHANGE_API_URL = "http://openexchangerates.org/api/";
    public static final String GIPHY_API_URL = "http://api.giphy.com/v1/gifs/";
    public static final String BASE_CURRENCY = "USD";
    public static final String RATE_CURRENCY = "RUB";
    public static final String KEY_FOR_GIPHY = "aFcuqqarYg88lbYlmW4xTcfjg5fRW2GK";
    public static final String KEY_FOR_EXCHANGE = "f6f0c813d08546c99290f5e0b66e2063";

}
