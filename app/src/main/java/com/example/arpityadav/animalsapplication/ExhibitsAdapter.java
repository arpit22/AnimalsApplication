package com.example.arpityadav.animalsapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Arpit Yadav on 7/5/2017.
 */

public class ExhibitsAdapter extends ArrayAdapter<Animal> {
    public ExhibitsAdapter(Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView== null){
            holder= new ViewHolder();
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.exhibit_list, parent, false);
            holder.name= (TextView) convertView.findViewById(R.id.name);
            holder.species= (TextView) convertView.findViewById(R.id.species);
            holder.thumbnail= (ImageView) convertView.findViewById(R.id.thumbnail);
            convertView.setTag(holder);
        }
        else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.name.setText(getItem(position).getName());
        holder.species.setText(getItem(position).getSpecies());
        Picasso.with(getContext()).load(getItem(position).getThumbnail()).into(holder.thumbnail);
        return convertView;

    }
    class ViewHolder{
        ImageView thumbnail;
        TextView name;
        TextView species;
    }
}
