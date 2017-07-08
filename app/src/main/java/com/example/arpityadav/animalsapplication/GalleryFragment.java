package com.example.arpityadav.animalsapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment implements AdapterView.OnItemClickListener {
    private GridView mgridView;
    private GalleryImageAdapter mAdapter;


    public static GalleryFragment getInstance() {
        GalleryFragment galleryFragment= new GalleryFragment();
        return galleryFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery_grid,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mgridView=(GridView) view.findViewById(R.id.grid);
        mgridView.setOnItemClickListener(this);
        mgridView.setDrawSelectorOnTop(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter=new GalleryImageAdapter(getActivity(),0);
        mgridView.setAdapter(mAdapter);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(getString(R.string.gallery_feed)).addConverterFactory(GsonConverterFactory.create()).build();
        GalleryApiInterface galleryApiInterface= retrofit.create(GalleryApiInterface.class);
        Call<List<GalleryImage>> call= galleryApiInterface.getStreams();
        call.enqueue(new Callback<List<GalleryImage>>() {
            @Override
            public void onResponse(Call<List<GalleryImage>> call, Response<List<GalleryImage>> response) {
                if(response.isSuccessful()){
                    List<GalleryImage> images= response.body();
                    for(GalleryImage image: images){
                        mAdapter.add(image);
                    }
                    mAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<GalleryImage>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
           GalleryImage image= (GalleryImage) adapterView.getItemAtPosition(i);
        Intent intent = new Intent(getActivity(),GalleryDetail2Activity.class);
        intent.putExtra(GalleryDetail2Activity.Extra_Image,image.getImage());
        intent.putExtra(GalleryDetail2Activity.Extra_Caption,image.getCaption());
        startActivity(intent);
    }
}
