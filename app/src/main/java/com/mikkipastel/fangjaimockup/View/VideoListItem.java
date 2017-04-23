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

public class VideoListItem {
    ImageView imageVideo;

    public VideoListItem(View parent) {
        imageVideo = (ImageView) parent.findViewById(R.id.imageVideo);
    }

    //set video cover in app
    public void setImageVideo(Context context, String picurl) {
        Glide.with(context)
                .load(picurl)
                .error(R.drawable.fungjai_logo_white)
                .placeholder(R.drawable.fungjai_logo_white)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageVideo);
    }

}
