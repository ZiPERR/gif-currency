package com.kit.testforalfabank.controllers;

import com.kit.testforalfabank.DifferenceBetweenDays;
import com.kit.testforalfabank.apis.ExchangeApi;
import com.kit.testforalfabank.settings.MyConstants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    DifferenceBetweenDays differenceBetweenDays = new DifferenceBetweenDays();
    ExchangeApi exchangeApi = new ExchangeApi();

    @RequestMapping("/api/getCurrencyGif")
    public String getCurrencyGif() {
        return "<p>Yesterday: " + exchangeApi.getYesterdayRates() + " " + MyConstants.RATE_CURRENCY +
                " <p/><p>Today: " + exchangeApi.getTodayRates() + " " + MyConstants.RATE_CURRENCY
                + "<p></p>" + differenceBetweenDays.compareTwoDays();
    }
}
