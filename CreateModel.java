package com.example.cosmic.androidappclasses;

import android.graphics.Bitmap;

/**
 * Created by ${cosmic} on 12/21/17.
 */

public class CreateModel {

    private String mfromOnTextImage;
    private String mfromTimestamp;
    private String mwordCount;
    private Bitmap mbitmap;

    public Bitmap getMbitmap() {
        return mbitmap;
    }

    public String getMfromOnTextImage() {
        return mfromOnTextImage;
    }

    public void setMbitmap(Bitmap mbitmap) {
        this.mbitmap = mbitmap;
    }

    public void setMfromOnTextImage(String mfromOnTextImage) {
        this.mfromOnTextImage = mfromOnTextImage;
    }

    public String getMfromTimestamp() {
        return mfromTimestamp;
    }

    public String getMwordCount() {
        return mwordCount;
    }

    public void setMfromTimestamp(String mfromTimestamp) {
        this.mfromTimestamp = mfromTimestamp;
    }

    public void setMwordCount(String mwordCount) {
        this.mwordCount = mwordCount;
    }

    private static final CreateModel createdModel = new CreateModel();

    public static CreateModel getIntance(){
        return createdModel;
    }
}
