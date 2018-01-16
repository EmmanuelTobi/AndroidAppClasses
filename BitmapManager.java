package com.example.cosmic.androidappclasses;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;

import java.io.ByteArrayOutputStream;

/**
 * Created by ${cosmic} on 1/2/18.
 */

public class BitmapManager {

    // convert from bitmap to byte array
    public byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    // convert from byte array to bitmap
    public Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    public Bitmap DrawabletoBitmapthumpnail(Drawable drawable){
        BitmapDrawable bitD = (BitmapDrawable) drawable;
        return ThumbnailUtils.extractThumbnail(bitD.getBitmap(), 200, 200);
    }
}
