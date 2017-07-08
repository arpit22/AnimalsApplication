package com.example.arpityadav.animalsapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Arpit Yadav on 7/5/2017.
 */

public class ApiClient {
    public static final String BASE_URL = "https://gist.githubusercontent.com/arpit22/980275d37fe5612600c3183a90e040e9/raw/8a3b3f92dd54b3fc345b1dc1b91488ee1382c76d/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
