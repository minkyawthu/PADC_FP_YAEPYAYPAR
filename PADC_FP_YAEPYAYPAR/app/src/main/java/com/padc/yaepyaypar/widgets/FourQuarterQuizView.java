package com.padc.yaepyaypar.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.Utils.ApiLevelHelper;
import com.padc.yaepyaypar.adapters.OptionsQuizAdapter;
import com.padc.yaepyaypar.vos.Quiz;
import com.padc.yaepyaypar.vos.YayPayParVo;


@SuppressLint("ViewConstructor")
public class FourQuarterQuizView extends AbsQuizView<Quiz> {

    private static final String KEY_ANSWER = "ANSWER";
    private int mAnswered = -1;
    private GridView mAnswerView;
    private String choseAnswer="";

    public FourQuarterQuizView(Context context, YayPayParVo category, Quiz quiz) {
        super(context, category, quiz);
    }

    @Override
    protected View createQuizContentView() {
        mAnswerView = new GridView(getContext());
        mAnswerView.setSelector(R.drawable.selector_button);
        mAnswerView.setNumColumns(2);
        mAnswerView.setAdapter(new OptionsQuizAdapter(getQuiz().getCaptions(),
                R.layout.item_answer));
        mAnswerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                choseAnswer = getQuiz().getCaptions().get(position);
                mAnswered = position;
            }
        });
        return mAnswerView;
    }

    @Override
    public Bundle getUserInput() {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ANSWER, mAnswered);
        return bundle;
    }

    @Override
    @SuppressLint("NewApi")
    public void setUserInput(Bundle savedInput) {
        if (savedInput == null) {
            return;
        }
        mAnswered = savedInput.getInt(KEY_ANSWER);
        if (mAnswered != -1) {
            if (ApiLevelHelper.isAtLeast(Build.VERSION_CODES.KITKAT) && isLaidOut()) {
                setUpUserInput();
            } else {
                addOnLayoutChangeListener(new OnLayoutChangeListener() {
                    @Override
                    public void onLayoutChange(View v, int left, int top,
                                               int right, int bottom,
                                               int oldLeft, int oldTop,
                                               int oldRight, int oldBottom) {
                        v.removeOnLayoutChangeListener(this);
                        setUpUserInput();
                    }
                });
            }
        }
    }

    @Override
    public String getAnswer() {
        return choseAnswer;
    }

    private void setUpUserInput() {
        mAnswerView.performItemClick(mAnswerView.getChildAt(mAnswered), mAnswered,
                mAnswerView.getAdapter().getItemId(mAnswered));
        mAnswerView.getChildAt(mAnswered).setSelected(true);
        mAnswerView.setSelection(mAnswered);
    }


}