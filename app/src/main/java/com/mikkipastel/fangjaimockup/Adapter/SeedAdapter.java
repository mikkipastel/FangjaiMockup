package com.mikkipastel.fangjaimockup.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mikkipastel.fangjaimockup.DAO.seed;
import com.mikkipastel.fangjaimockup.Manager.SeedManager;
import com.mikkipastel.fangjaimockup.R;
import com.mikkipastel.fangjaimockup.View.AdsListItem;
import com.mikkipastel.fangjaimockup.View.TrackListItem;
import com.mikkipastel.fangjaimockup.View.VideoListItem;

public class SeedAdapter extends BaseAdapter {

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

        //check not null object
        if (convertView == null) {
            //check get json complete
            if (dao.getType() != null) {
                //display layout from type
                if (dao.getType().contentEquals("track")) {
                    convertView = getTrackView(dao, parent);
                } else if (dao.getType().contentEquals("video")) {
                    convertView = getVideoView(dao, parent);
                } else if (dao.getType().contentEquals("ads")) {
                    convertView = getAdsView(dao, parent);
                }
            }
        }
        return convertView;
    }

    //set layout from track
    private View getTrackView(seed dao, ViewGroup parent) {
        TrackListItem item;
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View convertView = inflater.inflate(R.layout.listview_track, parent, false);

        Object tag = convertView.getTag(R.id.track_view);
        if (tag == null) {
            item = new TrackListItem(convertView);
            convertView.setTag(R.id.track_view, item);
        } else {
            item = (TrackListItem) tag;
        }

        item.setNameTrack(dao.getName());
        item.setImageTrack(context, dao.getCover());

        return convertView;
    }

    //set layout from video
    private View getVideoView(seed dao, ViewGroup parent) {
        VideoListItem item;
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View convertView = inflater.inflate(R.layout.listview_video, parent, false);

        Object tag = convertView.getTag(R.id.video_view);
        if (tag == null) {
            item = new VideoListItem(convertView);
            convertView.setTag(R.id.video_view, item);
        } else {
            item = (VideoListItem) tag;
        }

        item.setImageVideo(context, dao.getCover());
        //item.setNameVideo("[" + dao.getType() + "] " + dao.getName());

        return convertView;
    }

    //set layout from ads
    private View getAdsView(seed dao, ViewGroup parent) {
        AdsListItem item;
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View convertView = inflater.inflate(R.layout.listview_ads, parent, false);

        Object tag = convertView.getTag(R.id.ads_view);
        if (tag == null) {
            item = new AdsListItem(convertView);
            convertView.setTag(R.id.ads_view, item);
        } else {
            item = (AdsListItem) tag;
        }

        item.setImageAds(context, dao.getCover());
        //item.setNameAds("[" + dao.getType() + "] " + dao.getName());

        return convertView;
    }

}
