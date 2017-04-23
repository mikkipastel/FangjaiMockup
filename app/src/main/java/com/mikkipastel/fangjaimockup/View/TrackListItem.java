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

public class TrackListItem {
    ImageView imageTrack;
    TextView nameTrack;

    public TrackListItem(View parent) {
        imageTrack = (ImageView) parent.findViewById(R.id.imageTrack);
        nameTrack = (TextView) parent.findViewById(R.id.nameTrack);
    }

    public void setImageTrack(Context context, String picurl) {
        Glide.with(context)
                .load(picurl)
                .asBitmap()
                .error(R.drawable.fungjai_logo_white)
                .placeholder(R.drawable.fungjai_logo_white)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageTrack);
    }

    public void setNameTrack(String name) {
        nameTrack.setText(name);
    }

}
