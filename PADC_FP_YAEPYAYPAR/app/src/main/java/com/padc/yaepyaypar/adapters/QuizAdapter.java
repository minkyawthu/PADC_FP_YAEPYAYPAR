package com.padc.yaepyaypar.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.padc.yaepyaypar.Utils.YaePyayParConstants;
import com.padc.yaepyaypar.vos.Quiz;
import com.padc.yaepyaypar.vos.YayPayParVo;
import com.padc.yaepyaypar.widgets.AbsQuizView;
import com.padc.yaepyaypar.widgets.FillBlankQuizView;


import java.util.List;

/**
 * Created by kaungkhantthu on 9/17/16.
 */public class QuizAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<Quiz> mQuizzes;
    private  YayPayParVo yayPayParVo;
    private List<String> mQuizTypes;

    public QuizAdapter(Context context, YayPayParVo yayPayParVo) {
        mContext = context;
        this.yayPayParVo = yayPayParVo;
        mQuizzes = yayPayParVo.getQuizzes();

    }



    @Override
    public int getCount() {
        return mQuizzes.size();
    }

    @Override
    public Quiz getItem(int position) {
        return mQuizzes.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }






    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Quiz quiz = getItem(position);
        if (convertView instanceof  AbsQuizView) {
            if ((( AbsQuizView<Quiz>) convertView).getquiz().equals(quiz)) {
                return convertView;
            }
        }
        convertView =  getViewInternal(quiz,position);
        return convertView;
    }

    private  AbsQuizView<Quiz> getViewInternal(Quiz quiz,int position) {
        if (null == quiz) {
            throw new IllegalArgumentException("Quiz must not be null");
        }
        return createViewFor(quiz,position);
    }

    private AbsQuizView<Quiz> createViewFor(Quiz quiz, int position) {
        switch (quiz.getType()) {
            case YaePyayParConstants.VIEWTYPE_FILLBLANK:
                return new FillBlankQuizView(mContext, yayPayParVo, yayPayParVo.getQuizzes().get(position));

        }
        throw new UnsupportedOperationException(
                "Quiz of type " + quiz.getType() + " can not be displayed.");
    }
}
