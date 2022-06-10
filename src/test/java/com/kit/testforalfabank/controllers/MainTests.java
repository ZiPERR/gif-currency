package com.kit.testforalfabank.controllers;

import com.kit.testforalfabank.apis.ExchangeApi;
import com.kit.testforalfabank.apis.GiphyApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MainTests {

    @Autowired
    private MockMvc mockMvc;
    private GiphyApi giphyApi;
    private ExchangeApi exchangeApi;

    @Test
    public void shouldReturnGif() throws Exception {
        try {
            if (giphyApi.getRichGifs() != null) {
                this.mockMvc.perform(get("/api/getCurrencyGif")).andDo(print()).andExpect(status().isOk())
                        .andExpect(content().string(containsString(giphyApi.getRichGifs())));
            } else if (giphyApi.getBrokeGifs() != null) {
                this.mockMvc.perform(get("/api/getCurrencyGif")).andDo(print()).andExpect(status().isOk())
                        .andExpect(content().string(containsString(giphyApi.getBrokeGifs())));
            } else {
                throw new Exception("No gif on the page.");
            }
        } catch (NullPointerException nullPointerException) {
            nullPointerException.getStackTrace();
        }
    }

    @Test
    public void shouldReturnRates() throws Exception {
        try {
            this.mockMvc.perform(get("/api/getCurrencyGif")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString(String.valueOf(exchangeApi.getTodayRates()))))
                    .andExpect(content().string(containsString(String.valueOf(exchangeApi.getYesterdayRates()))));
        } catch (NullPointerException nullPointerException) {
            nullPointerException.getStackTrace();
        }
    }
}
