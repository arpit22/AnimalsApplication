package com.example.arpityadav.animalsapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Arpit Yadav on 7/5/2017.
 */

public interface AnimalApiInterface {
    @GET("Exhibits.json")
    Call<List<Animal>> getStreams();

}
