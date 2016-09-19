package com.padc.yaepyaypar.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.vos.YayPayParVo;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kaungkhantthu on 9/17/16.
 */
public class YayPayParCategoryViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.category_icon)
    public ImageView iView_icon;

    @BindView(R.id.category_title)
    public TextView txtView_title;

    @BindView(R.id.category_item)
    public FrameLayout item_layout;

    public YayPayParCategoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    public void bindData(YayPayParVo vo) {
//TODO change with real icons
        txtView_title.setText(vo.getName());
        Glide.with(item_layout.getContext())
                .load(R.drawable.icon_category_food_raster)
                .placeholder(R.drawable.dummy_avatar)
                .into(iView_icon);

    }
}
