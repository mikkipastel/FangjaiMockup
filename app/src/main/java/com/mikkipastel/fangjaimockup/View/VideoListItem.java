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
    TextView nameVideo;

    public VideoListItem(View parent) {
        imageVideo = (ImageView) parent.findViewById(R.id.imageVideo);
        nameVideo = (TextView) parent.findViewById(R.id.videoName);
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
    
    //add video name because give information abou this to user
    public void setNameVideo(String name){
        nameVideo.setText(name);
    }
    
    //add scale video cover to 4:3
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        width = imageVideo.getWidth();
        imageVideo.setMaxHeight(width * 3 / 4);
    }

}
