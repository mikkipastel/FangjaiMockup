package com.mikkipastel.fangjaimockup.Manager;

import android.content.Context;

import com.mikkipastel.fangjaimockup.DAO.seed;

import java.util.List;

public class SeedManager {
    private static SeedManager instance;

    public static  SeedManager getInstance() {
        if (instance == null)
            instance = new SeedManager();
        return instance;
    }

    private List<seed> seedList;

    public void setDao(List<seed> dao) {
        this.seedList = dao;
    }

    public List<seed> getSeedList() {
        return seedList;
    }

    private Context mContext;

    private SeedManager() {
        mContext = Contextor.getInstance().getContext();
    }

}
