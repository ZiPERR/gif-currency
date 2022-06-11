package com.kit.testforalfabank;

import com.kit.testforalfabank.apis.ExchangeApi;
import com.kit.testforalfabank.apis.GiphyApi;
import com.kit.testforalfabank.settings.MyConstants;

import java.math.BigDecimal;

public class DifferenceBetweenDays {
    private ExchangeApi exchangeApi = new ExchangeApi();
    private GiphyApi giphyApi = new GiphyApi();

    public String compareTwoDays() {
        if (exchangeApi.getTodayRates().compareTo(exchangeApi.getYesterdayRates()) < 0) {
            return "<img src=" + giphyApi.getBrokeGifs() + " alt='currencygif'</img>";
        } else if (exchangeApi.getTodayRates().compareTo(exchangeApi.getYesterdayRates()) > 0) {
            return "<img src=" + giphyApi.getRichGifs() + " alt='currencygif'</img>";
        } else {
            return "They are equal!";
        }
    }
}
