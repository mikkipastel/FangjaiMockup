package com.mikkipastel.fangjaimockup.View;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mikkipastel.fangjaimockup.R;


/**
 * Created by acer on 4/21/2017.
 */

public class AdsListItem {
    ImageView imageAds;
    TextView nameAds;

    public AdsListItem(View parent) {
        imageAds = (ImageView) parent.findViewById(R.id.imageAds);
        nameAds = (TextView) parent.findViewById(R.id.adsName);
    }

    //set ads cover in app
    public void setImageAds(Context context, String picurl) {
        Glide.with(context)
                .load(picurl)
                .error(R.drawable.fungjai_logo_white)
                .placeholder(R.drawable.fungjai_logo_white)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageAds);
    }
    
    //add video name because give information abou this to user
    public void setNameAds(String name){
        nameAds.setText(name);
    }
    
    //add to scale cover to 4:3
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        width = imageAds.getWidth();
        imageAds.setMaxHeight(width * 3 / 4);
    }

}
