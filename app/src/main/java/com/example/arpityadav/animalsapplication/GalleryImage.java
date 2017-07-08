package com.example.arpityadav.animalsapplication;

/**
 * Created by Arpit Yadav on 7/6/2017.
 */

public class GalleryImage {
    private String thumbnail;
    private String caption;
    private String image;

    public GalleryImage() {
    }

    public GalleryImage(String thumbnail, String caption, String image) {
        this.thumbnail = thumbnail;
        this.caption = caption;
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
