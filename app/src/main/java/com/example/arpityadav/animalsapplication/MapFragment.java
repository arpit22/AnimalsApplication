package com.example.arpityadav.animalsapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {


    public  static  MapFragment getInstance(){
        // Required empty public constructor
        MapFragment mapFragment = new MapFragment();
        return  mapFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CameraPosition position= CameraPosition.builder()
                .target(new LatLng(39.7500, -104.9500))
                .zoom(16f)
                .bearing(0.0f)
                .tilt(0.0f)
                .build();
      //  MapFragment fragment = (MapFragment)getChildFragmentManager().findFragmentById(R.id.)
        Retrofit retrofit = new Retrofit.Builder().baseUrl(getString(R.string.pins_feed)).addConverterFactory(GsonConverterFactory.create()).build();
        PinApiInterface pinApiInterface= retrofit.create(PinApiInterface.class);
        Call<List<Pins>> call= pinApiInterface.getStreams();
        call.enqueue(new Callback<List<Pins>>() {
            @Override
            public void onResponse(Call<List<Pins>> call, Response<List<Pins>> response) {

            }

            @Override
            public void onFailure(Call<List<Pins>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
