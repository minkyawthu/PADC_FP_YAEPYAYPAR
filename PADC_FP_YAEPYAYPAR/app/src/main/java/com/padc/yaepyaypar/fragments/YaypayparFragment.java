package com.padc.yaepyaypar.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.activities.YaypayparDetailActivity;
import com.padc.yaepyaypar.adapters.FriendsListAdapter;
import com.padc.yaepyaypar.adapters.YayPayparCategoryAdapter;
import com.padc.yaepyaypar.model.YaypayparModel;
import com.padc.yaepyaypar.views.FriendsViewHolder;
import com.padc.yaepyaypar.vos.YayPayParVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kaungkhantthu on 9/11/16.
 */
public class YaypayparFragment extends Fragment  {
    @BindView(R.id.rv_friends)
    RecyclerView rvFriends;

    private YayPayparCategoryAdapter yaypar;


    public YaypayparFragment() {
    }

    public static Fragment newInstance() {
        Fragment fragment = new YaypayparFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        YaypayparModel.getInstance().loadAttractions();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);




        return rootView;
    }

}

