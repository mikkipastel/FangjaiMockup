package com.mikkipastel.fangjaimockup.Manager;

import com.mikkipastel.fangjaimockup.DAO.seed;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by acer on 4/21/2017.
 */

public interface ApiService {
    @GET("seed.json")
    Call<List<seed>> loadList();
}
