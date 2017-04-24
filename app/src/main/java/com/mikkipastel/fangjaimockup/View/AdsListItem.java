package com.mikkipastel.fangjaimockup.View;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mikkipastel.fangjaimockup.R;



public class AdsListItem {
    private ImageView imageAds;

    public AdsListItem(View parent) {
        imageAds = (ImageView) parent.findViewById(R.id.imageAds);
    }

    //set ads cover in app
    public void setImageAds(Context context, String picurl) {
        Glide.with(context)
                .load(picurl)
                .error(R.drawable.fungjai_logo_white)
                .placeholder(R.drawable.fungjai_logo_white)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .fitCenter()
                .into(imageAds);
    }

}
