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

    private final listitemClicklistner itemclicklistner;
    @BindView(R.id.tv_friend_name)
    TextView tvFriendName;

    public FriendsViewHolder(View itemView,listitemClicklistner clicklistner) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.itemclicklistner = clicklistner;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        itemclicklistner.onClick();
    }

    public void bindData(String friendName){

        tvFriendName.setText(friendName);
    }
    public interface listitemClicklistner{
        public void onClick();
    }
}
