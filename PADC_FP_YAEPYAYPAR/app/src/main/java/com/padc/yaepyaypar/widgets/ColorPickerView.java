package com.padc.yaepyaypar.widgets;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.colorpicker.dialog.ColorPickerDialogFragment;
import com.padc.yaepyaypar.vos.Quiz;
import com.padc.yaepyaypar.vos.YayPayParVo;

/**
 * Created by kaungkhantthu on 9/24/16.
 */
@SuppressLint("ViewConstructor")
public  class ColorPickerView extends AbsQuizView<Quiz> implements ColorPickerDialogFragment.ColorPickerDialogListener {
    private static final int DIALOG_ID = 0;
    private TextView mAnswerView;
    private String answercolor="";

    public ColorPickerView(Context context, YayPayParVo category, Quiz quiz) {
        super(context, category, quiz);
    }
    @Override
    protected View createQuizContentView() {
        mAnswerView = getAnswerView();
        return mAnswerView;
    }

    @Override
    public Bundle getUserInput() {
        return null;
    }


    @Override
    public void setUserInput(Bundle savedInput) {

    }


    @Override
    public String getAnswer() {
        return   answercolor;
    }

    public TextView getAnswerView() {
        mAnswerView = (TextView) getLayoutInflater().inflate(
                R.layout.quizcolorpicker, this, false);
        mAnswerView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPickerDialogFragment f = ColorPickerDialogFragment
                        .newInstance(DIALOG_ID, null, null, Color.BLACK, true,ColorPickerView.this);

                f.setStyle(DialogFragment.STYLE_NORMAL, R.style.LightPickerDialogTheme);
                f.show(((AppCompatActivity)getContext()).getFragmentManager(), "d");
            }
        });
        return mAnswerView;
    }

    @Override
    public void onColorSelected(int dialogId, int color) {
        Log.e( "onColorSelected: ", color+"");

        mAnswerView.setBackgroundColor(color);
        answercolor = color+"";
    }


    @Override
    public void onDialogDismissed(int dialogId) {

    }
}
