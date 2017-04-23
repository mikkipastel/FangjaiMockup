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

public class VideoListItem extends BaseCustomViewGroup {
    ImageView imageVideo;

    public VideoListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    private void initInflate() {
        inflate(getContext(), R.layout.listview_video, this);
    }

    private void initInstances() {
        // findViewById here
        imageVideo = (ImageView) findViewById(R.id.imageVideo);
    }

    //set video cover in app
    public void setImageVideo(String picurl) {
        Glide.with(getContext())
                .load(picurl)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageVideo);
    }

}
