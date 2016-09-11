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
import com.padc.yaepyaypar.views.FriendsViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mkt on 9/11/2016.
 */
public class ShareProfileListFragment extends Fragment implements FriendsViewHolder.listitemClicklistner{

    @BindView(R.id.rv_friends)
    RecyclerView rvFriends;

    private FriendsListAdapter mFriendListAdapter;
    private int gridColumnSpanCount = 2;

    public ShareProfileListFragment() {
    }

    public static Fragment newInstance() {
        Fragment fragment = new ShareProfileListFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] nameListArray = getResources().getStringArray(R.array.dummy_friends_name);
        List<String> friendNameList = new ArrayList<>(Arrays.asList(nameListArray));

        mFriendListAdapter = new FriendsListAdapter(friendNameList,this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);

        rvFriends.setLayoutManager(new GridLayoutManager(getContext(), gridColumnSpanCount));
        rvFriends.setAdapter(mFriendListAdapter);

        return rootView;
    }

    @Override
    public void onClick() {
        Intent i = new Intent(getContext(), YaypayparDetailActivity.class);
        startActivity(i);
    }
}