package com.padc.yaepyaypar.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.padc.yaepyaypar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mkt on 9/11/2016.
 */
public class FriendsViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.tv_friend_name)
    TextView tvFriendName;

    public FriendsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    public void bindData(String friendName){

        tvFriendName.setText(friendName);
    }

}
