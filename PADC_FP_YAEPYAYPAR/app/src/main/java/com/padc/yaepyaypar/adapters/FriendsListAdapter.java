package com.padc.yaepyaypar.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.YaePyayParApp;
import com.padc.yaepyaypar.views.FriendsViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkt on 9/11/2016.
 */
public class FriendsListAdapter extends RecyclerView.Adapter<FriendsViewHolder> {

    private  FriendsViewHolder.listitemClicklistner clicklistner;
    private LayoutInflater mInflater;
    private List<String> mfriendNameList;

    public FriendsListAdapter(List<String> mfriendNameList,FriendsViewHolder.listitemClicklistner clicklistner) {
        if (mfriendNameList != null) {
            this.mfriendNameList = mfriendNameList;
            this.clicklistner = clicklistner;
        } else {
            this.mfriendNameList = new ArrayList<>();
            this.clicklistner = clicklistner;

        }
        mInflater = LayoutInflater.from(YaePyayParApp.getContext());
    }

    @Override
    public FriendsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.view_item_friends, parent, false);
        return new FriendsViewHolder(itemView,clicklistner);
    }

    @Override
    public void onBindViewHolder(FriendsViewHolder holder, int position) {
        holder.bindData(mfriendNameList.get(position));
    }

    @Override
    public int getItemCount() {
        return mfriendNameList.size();
    }
}
