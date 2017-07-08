package com.example.arpityadav.animalsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class GalleryDetail2Activity extends AppCompatActivity {
    private TextView mCaptionTextView;
    private ImageView mImageView;
    public static final String Extra_Image="extra_image";
    public static final String Extra_Caption="extra_caption";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail2);
        mCaptionTextView= (TextView)findViewById(R.id.caption);
        mImageView=(ImageView)findViewById(R.id.image);
        if(getIntent()!=null && getIntent().getExtras()!= null)
        {
            if(getIntent().getExtras().containsKey(Extra_Image))
            {
                Picasso.with(this).load(getIntent().getExtras().getString(Extra_Image)).into(mImageView);
            }
            if(getIntent().getExtras().containsKey(Extra_Caption))
            {
                mCaptionTextView.setText(getIntent().getExtras().getString(Extra_Caption));
            }
        }
    }
}
