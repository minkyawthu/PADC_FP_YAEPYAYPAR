package com.padc.yaepyaypar.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.yaepyaypar.NormalEdtextViewholder;
import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.yaypayparpostvo;

import java.util.ArrayList;

/**
 * Created by kaungkhantthu on 9/11/16.
 */
public class YaypayparQuestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<yaypayparpostvo> yaypayparpostvos;
    public static final int NORMAL_VIEWHOLDER = 0;
    public static final int CHOICE_VIEWHOLDER = 1;
    public static final int DOODLE_VIEWHOLDER = 2;
    public static final int ANSWER_VIEWHOLDER = 3;


    public YaypayparQuestionAdapter(ArrayList<yaypayparpostvo> yaypayparpostvos) {
        this.yaypayparpostvos = yaypayparpostvos;
    }

    @Override
    public int getItemViewType(int position) {
        int viewholderType = yaypayparpostvos.get(position).getViewType();

        return viewholderType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case NORMAL_VIEWHOLDER:
            case CHOICE_VIEWHOLDER:
            case DOODLE_VIEWHOLDER:
            case ANSWER_VIEWHOLDER:
            default:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.normalquestion, parent, false);
                return new NormalEdtextViewholder(v);

        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NormalEdtextViewholder) holder).bindData(yaypayparpostvos.get(position).getQuestion(), yaypayparpostvos.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return yaypayparpostvos.size();
    }
}
