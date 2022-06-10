package com.kit.testforalfabank;

import com.kit.testforalfabank.apis.ExchangeApi;
import com.kit.testforalfabank.apis.GiphyApi;

import java.math.BigDecimal;

public class DifferenceBetweenDays {
    private ExchangeApi exchangeApi = new ExchangeApi();
    private GiphyApi giphyApi = new GiphyApi();

    public String compareTwoDays(){
        if(exchangeApi.getTodayRates().compareTo(exchangeApi.getYesterdayRates()) < 0){
            return giphyApi.getBrokeGifs();
        }
        else if (exchangeApi.getTodayRates().compareTo(exchangeApi.getYesterdayRates()) > 0){
            return giphyApi.getRichGifs();
        }
        return null;
    }
}
