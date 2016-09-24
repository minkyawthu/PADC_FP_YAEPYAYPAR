package com.padc.yaepyaypar.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.AdapterViewAnimator;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.Utils.ApiLevelHelper;
import com.padc.yaepyaypar.Utils.YaePyayParConstants;
import com.padc.yaepyaypar.YaePyayParApp;
import com.padc.yaepyaypar.adapters.QuizAdapter;
import com.padc.yaepyaypar.colorpicker.dialog.ColorPickerDialogFragment;
import com.padc.yaepyaypar.model.YaypayparModel;
import com.padc.yaepyaypar.vos.YayPayParVo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YaypayparDetailActivity extends AppCompatActivity  {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.quiz_view)
    AdapterViewAnimator quizView;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.mSeekbar)
    SeekBar mSeekbar;
    @BindView(R.id.progress_toolbar)
    Toolbar progressToolbar;
    private String categoryid;
    private YaypayparModel model;
    private YayPayParVo YayPayParitem;
    private QuizAdapter mQuizAdapter;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoryid = (String) getIntent().getExtras().get(YaePyayParConstants.CATEGORY_ID);
        Log.e(YaePyayParApp.TAG, "onStart: "+categoryid);
        model = YaypayparModel.getInstance();
        model.loadyaypaypar();
        YayPayParitem = model.getYaypayparById(categoryid);
        setTheme(YayPayParitem.getTheme().getStyleId());
        setContentView(R.layout.activity_yaypaypar_detail);
        ButterKnife.bind(this);
        setQuizViewAnimations();
        quizView.setAdapter(getQuizAdapter());

        setupProgress();
    }
    private QuizAdapter getQuizAdapter() {
        if (null == mQuizAdapter) {
            mQuizAdapter = new QuizAdapter(this, YayPayParitem);
        }
        return mQuizAdapter;
    }
    private void setupProgress(){
        progress.setMax(YayPayParitem.getQuizzes().size()-1);
        mSeekbar.setMax(YayPayParitem.getQuizzes().size()-1);

        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                quizView.setSelection(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setQuizViewAnimations() {
        if (ApiLevelHelper.isLowerThan(Build.VERSION_CODES.LOLLIPOP)) {
            return;
        }
        quizView.setInAnimation(this, R.animator.slide_in_left);
        quizView.setOutAnimation(this, R.animator.slide_out_right);
    }



}
