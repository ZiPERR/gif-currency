package com.kit.testforalfabank.apis;

import com.kit.testforalfabank.interfaces.GiphyInterface;
import feign.Feign;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import java.util.ArrayList;
import java.util.List;

import static com.kit.testforalfabank.settings.MyConstants.GIPHY_API_URL;
import static com.kit.testforalfabank.settings.MyConstants.KEY_FOR_GIPHY;

public class GiphyApi {
    private final GiphyInterface giphyInterface = Feign.builder()
            .contract(new SpringMvcContract())
            .target(GiphyInterface.class, GIPHY_API_URL);

    private String richJsonUrl = "";
    private String brokeJsonUrl = "";

    public String getRichGifs() {
        String richGifs = giphyInterface.getGifs("rich", KEY_FOR_GIPHY);
        List<String> gifIds = new ArrayList<>();
        JSONArray dataArray = new JSONObject(richGifs).getJSONArray("data");
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject jsonObject = dataArray.getJSONObject(i);
            String gifId = jsonObject.getString("id");
            gifIds.add(gifId);

            int index = (int) (Math.random() * gifIds.size());

            if (jsonObject.getString("id").equals(gifIds.get(index))) {
                richJsonUrl = jsonObject.getJSONObject("images").getJSONObject("original").getString("url");
            }
        }

        return richJsonUrl;
    }

    public String getBrokeGifs() {
        String brokeGifs = giphyInterface.getGifs("broke", KEY_FOR_GIPHY);
        List<String> gifIds = new ArrayList<>();
        JSONArray dataArray = new JSONObject(brokeGifs).getJSONArray("data");
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject jsonObject = dataArray.getJSONObject(i);
            String gifId = jsonObject.getString("id");
            gifIds.add(gifId);

            int index = (int) (Math.random() * gifIds.size());

            if (jsonObject.getString("id").equals(gifIds.get(index))) {
                brokeJsonUrl = jsonObject.getJSONObject("images").getJSONObject("original").getString("url");
            }
        }

        return brokeJsonUrl;
    }
}
