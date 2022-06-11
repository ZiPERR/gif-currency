package com.kit.testforalfabank.apis;

import com.kit.testforalfabank.interfaces.ExchangeInterface;
import com.kit.testforalfabank.settings.MyConstants;
import feign.Feign;
import org.json.JSONObject;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static com.kit.testforalfabank.settings.MyConstants.EXCHANGE_API_URL;
import static com.kit.testforalfabank.settings.MyConstants.RATE_CURRENCY;

public class ExchangeApi {

    public String yesterdayRates;

    ExchangeInterface exchangeInterface = Feign.builder()
            .contract(new SpringMvcContract())
            .target(ExchangeInterface.class, EXCHANGE_API_URL);

    public BigDecimal getYesterdayRates() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                .withZone(ZoneId.systemDefault()); // PATTERN FOR DATE

        String formattedYesterdayDate = dateTimeFormatter.format(MyConstants.YESTERDAY_DATE);

        yesterdayRates = exchangeInterface.yesterdayRates(formattedYesterdayDate,
                MyConstants.KEY_FOR_EXCHANGE, MyConstants.BASE_CURRENCY);

        JSONObject jsonObject = new JSONObject(yesterdayRates);

        return (BigDecimal) jsonObject.getJSONObject("rates").get(RATE_CURRENCY);
    }

    public BigDecimal getTodayRates() {
        String todayRates = exchangeInterface.todayRates(
                MyConstants.KEY_FOR_EXCHANGE, MyConstants.BASE_CURRENCY);

        JSONObject jsonObject = new JSONObject(todayRates);

        return (BigDecimal) jsonObject.getJSONObject("rates").get(RATE_CURRENCY);
    }
}