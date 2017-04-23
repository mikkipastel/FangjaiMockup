package com.mikkipastel.fangjaimockup.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.mikkipastel.fangjaimockup.DAO.seed;
import com.mikkipastel.fangjaimockup.Manager.SeedManager;
import com.mikkipastel.fangjaimockup.View.AdsListItem;
import com.mikkipastel.fangjaimockup.View.TrackListItem;
import com.mikkipastel.fangjaimockup.View.VideoListItem;

import java.util.List;


/**
 * Created by acer on 4/21/2017.
 */

public class SeedAdapter extends BaseAdapter {

    //List<seed> dao;

    @Override
    public int getCount() {
        if (SeedManager.getInstance().getSeedList() == null)
            return 0;
        return SeedManager.getInstance().getSeedList().size();
    }

    @Override
    public seed getItem(int position) {
        return SeedManager.getInstance().getSeedList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final seed dao = getItem(position);

        TrackListItem trackItem = new TrackListItem(parent.getContext());
        AdsListItem adsItem = new AdsListItem(parent.getContext());
        VideoListItem videoItem = new VideoListItem(parent.getContext());

        //display layout from type
        if (convertView == null) {
            // check not null object
            if (dao.getType() != null) {
                if (dao.getType().contentEquals("track")) {
                    trackItem.setNameTrack(dao.getName());
                    trackItem.setImageTrack(dao.getCover());
                } else if (dao.getType().contentEquals("video")) {
                    videoItem.setImageVideo(dao.getCover());
                } else if (dao.getType().contentEquals("ads")) {
                    adsItem.setImageAds(dao.getCover());
                }
            }
        }

        return convertView;

    }

}
