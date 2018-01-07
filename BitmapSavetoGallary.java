package com.example.cosmic.androidappclasses;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by ${cosmic} on 1/7/18.
 */

public class BitmapSavetoGallary extends AppCompatActivity{
    private Handler mHandler;
    private Context context = this;
    ProgressBar progressbar;

    OnPictureSavedListener mListener;
    private void saveImage(final String folderName, final String fileName, final Bitmap image) {
        File path = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File file = new File(path, folderName + "/" + fileName);
        progressbar.setVisibility(View.VISIBLE);
        try {
            file.getParentFile().mkdirs();
            image.compress(Bitmap.CompressFormat.PNG, 80, new FileOutputStream(file));
            MediaScannerConnection.scanFile(context,
                    new String[] {
                            file.toString()
                    }, null,
                    new MediaScannerConnection.OnScanCompletedListener() {
                        @Override
                        public void onScanCompleted(final String path, final Uri uri) {
                            //startActivity(new Intent(/* present activity.this*/, /*another activity.class*/));
                            if (mListener != null) {
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        mListener.onPictureSaved(uri);
                                    }
                                },1000);
                            }
                        }
                    });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public interface OnPictureSavedListener {
        void onPictureSaved(Uri uri);
    }
}
