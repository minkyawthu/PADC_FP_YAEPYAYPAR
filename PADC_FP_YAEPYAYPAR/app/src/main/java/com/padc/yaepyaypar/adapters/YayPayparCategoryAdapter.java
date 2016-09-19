package com.padc.yaepyaypar.adapters;

import android.app.Activity;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.views.YayPayParCategoryViewHolder;
import com.padc.yaepyaypar.Utils.listitemClicklistner;
import com.padc.yaepyaypar.vos.YayPayParVo;

import java.util.ArrayList;

/**
 * Created by kaungkhantthu on 9/17/16.
 */
public class YayPayparCategoryAdapter extends RecyclerView.Adapter<YayPayParCategoryViewHolder> {
    private final ArrayList<YayPayParVo> yayparparlist;
    private final Activity activity;
    private final listitemClicklistner clicklistner;

    public YayPayparCategoryAdapter(Activity activity, listitemClicklistner itemclickListner, ArrayList<YayPayParVo> yaypayparList) {
        this.yayparparlist = yaypayparList;
        this.activity = activity;
        this.clicklistner = itemclickListner;
    }

    @Override
    public YayPayParCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);

        return new YayPayParCategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(YayPayParCategoryViewHolder holder, final int position) {
        YayPayParVo vo = yayparparlist.get(position);
        holder.bindData(vo);

        holder.itemView.setBackgroundColor(getColor(vo.getTheme().getWindowBackgroundColor()));
        holder.txtView_title.setTextColor(getColor(vo.getTheme().getTextPrimaryColor()));
        holder.txtView_title.setBackgroundColor(getColor(vo.getTheme().getPrimaryColor()));

        holder.item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicklistner.onClick(position);
            }
        });
    }

    private int getColor(@ColorRes int colorRes) {
        return ContextCompat.getColor(activity, colorRes);
    }

    @Override
    public int getItemCount() {
        return yayparparlist.size();
    }
}
