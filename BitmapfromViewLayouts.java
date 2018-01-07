package com.example.cosmic.androidappclasses;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Layout;

/**
 * Created by ${cosmic} on 1/7/18.
 */

public class BitmapfromViewLayouts {

    public Bitmap BitmapfromViewLayouts(Layout layout){

        Bitmap bitmap = Bitmap.createBitmap(layout.getWidth(), layout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        layout.draw(canvas);
        return bitmap;
    }
}
