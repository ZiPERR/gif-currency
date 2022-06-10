package com.kit.testforalfabank.interfaces;

import feign.Headers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Headers("Content-Type: application/json")
public interface GiphyInterface {

    @RequestMapping(value = "search?q={searchQuery}&api_key={api_key}",
            method = RequestMethod.GET)
    String getGifs(
            @PathVariable("searchQuery") String searchQuery,
            @PathVariable("api_key") String api_key);
}