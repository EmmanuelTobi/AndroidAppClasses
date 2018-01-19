package com.example.cosmic.androidappclasses;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ${cosmic} on 1/19/18.
 */

public class IntentImageSharing extends AppCompatActivity{

    public void ShareIntent(String packagename) {

        //For sharing images to other apps
        //packagename can be com.instagram.android or com.facebook.android ...

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, " /* replace this with an Image Uri or Url or image byte string */ ");
        shareIntent.setType("image/*");
        shareIntent.setPackage(packagename);

        PackageManager packManager = getPackageManager();
        List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(shareIntent,  PackageManager.MATCH_DEFAULT_ONLY);

        boolean resolved = false;
        for(ResolveInfo resolveInfo : resolvedInfoList){
            if(resolveInfo.activityInfo.packageName.startsWith(packagename)){
                shareIntent.setClassName(
                        resolveInfo.activityInfo.packageName,
                        resolveInfo.activityInfo.name );
                resolved = true;
                break;
            }
        }
        if(resolved){
            startActivity(shareIntent);

        }else{

            if(packagename.contains("instagram"))
                Toast.makeText(this, "Instagram App is not installed", Toast.LENGTH_LONG).show();

            else if(packagename.contains("facebook"))
                Toast.makeText(this, "Facebook App is not installed", Toast.LENGTH_LONG).show();
           }
    }
}
