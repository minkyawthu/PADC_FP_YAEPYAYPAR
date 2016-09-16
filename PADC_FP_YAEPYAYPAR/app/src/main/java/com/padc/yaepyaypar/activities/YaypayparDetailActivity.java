package com.padc.yaepyaypar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.padc.yaepyaypar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YaypayparDetailActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewQuestionList)
    RecyclerView recyclerViewQuestionList;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_attraction)
    ImageView ivToolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yaypaypar_detail);
        ButterKnife.bind(this);

    }


}
