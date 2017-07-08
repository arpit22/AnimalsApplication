package com.example.arpityadav.animalsapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Arpit Yadav on 7/6/2017.
 */

public interface GalleryApiInterface {
    @GET("gallery.json")
    Call<List<GalleryImage>> getStreams();
}
