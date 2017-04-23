package com.mikkipastel.fangjaimockup.View;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mikkipastel.fangjaimockup.R;


/**
 * Created by acer on 4/21/2017.
 */

public class AdsListItem extends BaseCustomViewGroup {
    ImageView imageAds;

    public AdsListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    private void initInflate() {
        inflate(getContext(), R.layout.listview_ads, this);
    }

    private void initInstances() {
        // findViewById here
        imageAds = (ImageView) findViewById(R.id.imageAds);
    }

    //set video cover in app
    public void setImageAds(String picurl) {
        Glide.with(getContext())
                .load(picurl)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageAds);
    }

}
