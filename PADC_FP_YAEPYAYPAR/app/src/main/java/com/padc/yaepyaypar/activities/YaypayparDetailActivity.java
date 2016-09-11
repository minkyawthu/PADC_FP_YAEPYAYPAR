package com.padc.yaepyaypar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.adapters.YaypayparQuestionAdapter;
import com.padc.yaepyaypar.yaypayparpostvo;

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


    private ArrayList<yaypayparpostvo> yaypayparpostvos;

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
        yaypayparpostvos = new ArrayList<>();
        yaypayparpostvos.add(new yaypayparpostvo("What is your name", "", false, YaypayparQuestionAdapter.NORMAL_VIEWHOLDER));
        yaypayparpostvos.add(new yaypayparpostvo("How does your Friend Calls you", "", false, YaypayparQuestionAdapter.NORMAL_VIEWHOLDER));
        yaypayparpostvos.add(new yaypayparpostvo("Where do you live", "", false, YaypayparQuestionAdapter.NORMAL_VIEWHOLDER));
        yaypayparpostvos.add(new yaypayparpostvo("Who do you live with", "", false, YaypayparQuestionAdapter.NORMAL_VIEWHOLDER));
        yaypayparpostvos.add(new yaypayparpostvo("What is your favourite food", "", false, YaypayparQuestionAdapter.NORMAL_VIEWHOLDER));


    }
}
