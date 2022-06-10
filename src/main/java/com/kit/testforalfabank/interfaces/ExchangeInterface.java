package com.kit.testforalfabank.interfaces;

import feign.Headers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Headers("Content-Type: application/json")
public interface ExchangeInterface {

    @RequestMapping(value = "historical/{today_date}.json?app_id={app_id}&base={base_currency}",
            method = RequestMethod.GET)
    String todayRates(
            @PathVariable(value = "today_date") String today_date,
            @PathVariable(value = "app_id") String app_id,
            @PathVariable(value = "base_currency") String base_currency);


    @RequestMapping(value = "historical/{yesterday_date}.json?app_id={app_id}&base={base_currency}",
            method = RequestMethod.GET)
    String yesterdayRates(
            @PathVariable(value = "yesterday_date") String yesterday_date,
            @PathVariable(value = "app_id") String app_id,
            @PathVariable(value = "base_currency") String base_currency);


}
