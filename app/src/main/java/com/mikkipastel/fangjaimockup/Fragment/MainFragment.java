package com.mikkipastel.fangjaimockup.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.mikkipastel.fangjaimockup.Adapter.SeedAdapter;
import com.mikkipastel.fangjaimockup.DAO.seed;
import com.mikkipastel.fangjaimockup.Manager.HttpManager;
import com.mikkipastel.fangjaimockup.Manager.SeedManager;
import com.mikkipastel.fangjaimockup.R;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by acer on 4/21/2017.
 */

public class MainFragment extends Fragment {
    ListView myListView;
    SeedAdapter adapter;

    SwipeRefreshLayout swipeRefreshLayout;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myListView = (ListView)view.findViewById(R.id.seed_list);
        adapter = new SeedAdapter();
        myListView.setAdapter(adapter);

        //myListView.setOnItemClickListener(listViewItemClickListener);

        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reloadData();
            }
        });

        myListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {}

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                swipeRefreshLayout.setEnabled(firstVisibleItem == 0);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        reloadData();
    }

    private void reloadData() {
        Call<List<seed>> call = HttpManager.getInstance().getService().loadList();
        call.enqueue(new Callback<List<seed>>() {
            @Override
            public void onResponse(Call<List<seed>> call, Response<List<seed>> response) {
                swipeRefreshLayout.setRefreshing(false);
                checkResponse(response);
            }

            @Override
            public void onFailure(Call<List<seed>> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                showErrorToast(t.toString());
            }
        });
    }

    private void checkResponse(Response<List<seed>> response) {
        if (response.isSuccessful()){
            List<seed> collection = response.body();
            SeedManager.getInstance().setDao(collection);
            adapter.notifyDataSetChanged();
            //showErrorToast(collection.get(0).getId() + " " + collection.get(0).getType());
        } else {
            try { //404 not found
                showErrorToast(response.errorBody().string());
            } catch (IOException e) {
                showErrorToast(response.message());
            }
        }
    }

    private void showErrorToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
