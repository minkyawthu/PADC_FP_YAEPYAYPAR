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
public class FriendsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.tv_friend_name)
    TextView tvFriendName;

    public FriendsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }

    public void bindData(String friendName){

        tvFriendName.setText(friendName);
    }
}
