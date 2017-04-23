package com.mikkipastel.fangjaimockup.View;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mikkipastel.fangjaimockup.R;


/**
 * Created by acer on 4/21/2017.
 */

public class TrackListItem extends BaseCustomViewGroup {
    ImageView imageTrack;
    TextView nameTrack;

    public TrackListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    private void initInflate() {
        inflate(getContext(), R.layout.listview_track, this);
    }

    private void initInstances() {
        // findViewById here
        imageTrack = (ImageView) findViewById(R.id.imageTrack);
        nameTrack = (TextView) findViewById(R.id.nameTrack);
    }

    public void setImageTrack(String picurl) {
        Glide.with(getContext())
                .load(picurl)
                .asBitmap()
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageTrack);
    }

    public void setNameTrack(String name) {
        nameTrack.setText(name);
    }

}
