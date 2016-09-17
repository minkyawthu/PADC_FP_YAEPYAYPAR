package com.padc.yaepyaypar.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.YaePyayParApp;
import com.padc.yaepyaypar.views.FriendsViewHolder;
import com.padc.yaepyaypar.views.listitemClicklistner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkt on 9/11/2016.
 */
public class FriendsListAdapter extends RecyclerView.Adapter<FriendsViewHolder>{

    private listitemClicklistner clicklistner;
    private LayoutInflater mInflater;
    private List<String> mfriendNameList;

    public FriendsListAdapter(List<String> mfriendNameList,listitemClicklistner clicklistner) {
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
        return new FriendsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FriendsViewHolder holder, final int position) {
        holder.bindData(mfriendNameList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicklistner.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mfriendNameList.size();
    }
}
