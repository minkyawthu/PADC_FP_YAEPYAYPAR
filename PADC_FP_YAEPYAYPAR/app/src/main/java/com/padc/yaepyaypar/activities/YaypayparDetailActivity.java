package com.padc.yaepyaypar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.padc.yaepyaypar.MultipleChoiceQuestionVo;
import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.adapters.YaypayparQuestionAdapter;
import com.padc.yaepyaypar.YayPayParPostVo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YaypayparDetailActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewQuestionList)
    RecyclerView recyclerViewQuestionList;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_attraction)
    ImageView ivToolbar;


    private ArrayList<YayPayParPostVo> yaypayparpostvos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yaypaypar_detail);
        ButterKnife.bind(this);
       GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(ivToolbar);

        Glide.with(this)
                .load(R.drawable.happykiddo)
                .placeholder(R.drawable.happykiddo)
                .into(ivToolbar);
        setSupportActionBar(toolbar);
        setupArrayList();
        setupRecyclerView();

    }

    private void setupRecyclerView() {
        recyclerViewQuestionList.setLayoutManager(new LinearLayoutManager(this));
        YaypayparQuestionAdapter yaypayparQuestionAdapter = new YaypayparQuestionAdapter(yaypayparpostvos);
        recyclerViewQuestionList.setAdapter(yaypayparQuestionAdapter);
    }

    private void setupArrayList() {
        ArrayList<Integer> a = new ArrayList<>();
        yaypayparpostvos = new ArrayList<>();
        yaypayparpostvos.add(new YayPayParPostVo("What is your name", "", false, YaypayparQuestionAdapter.NORMAL_VIEWHOLDER));
        yaypayparpostvos.add(new YayPayParPostVo("How does your Friend Calls you", "", false, YaypayparQuestionAdapter.NORMAL_VIEWHOLDER));
        yaypayparpostvos.add(new MultipleChoiceQuestionVo("Where do you live", "", false, YaypayparQuestionAdapter.CHOICE_VIEWHOLDER,a));
        yaypayparpostvos.add(new YayPayParPostVo("Who do you live with", "", false, YaypayparQuestionAdapter.NORMAL_VIEWHOLDER));
        yaypayparpostvos.add(new YayPayParPostVo("What is your favourite food", "", false, YaypayparQuestionAdapter.NORMAL_VIEWHOLDER));


    }
}
