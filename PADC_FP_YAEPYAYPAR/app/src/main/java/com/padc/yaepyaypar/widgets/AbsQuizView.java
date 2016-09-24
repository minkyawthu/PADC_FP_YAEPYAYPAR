package com.padc.yaepyaypar.widgets;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.Log;
import android.util.Property;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.YaePyayParApp;
import com.padc.yaepyaypar.vos.Quiz;
import com.padc.yaepyaypar.vos.YayPayParVo;

import java.util.Stack;

/**
 * <p>
 * Subclasses need to implement {@link AbsQuizView#createQuizContentView()}
 * in order to allow solution of a quiz.
 * </p>
 * <p>


 */
public abstract class AbsQuizView<Q extends Quiz> extends FrameLayout  {

    private static final int ANSWER_HIDE_DELAY = 500;
    private static final int FOREGROUND_COLOR_CHANGE_DELAY = 750;
    private final int mSpacingDouble;
    private final LayoutInflater mLayoutInflater;
    private final YayPayParVo yayPayParVo;
    private final Q mQuiz;
    private final Interpolator mLinearOutSlowInInterpolator;
    private final Handler mHandler;
    private final InputMethodManager mInputMethodManager;
    private boolean mAnswered;
    private TextView mQuestionView;
    private Runnable mHideFabRunnable;
    private Runnable mMoveOffScreenRunnable;


    public AbsQuizView(Context context, YayPayParVo category, Q quiz) {
        super(context);
        mQuiz = quiz;
        yayPayParVo = category;
        mSpacingDouble = getResources().getDimensionPixelSize(R.dimen.margin_medium_2);
        mLayoutInflater = LayoutInflater.from(context);
        mLinearOutSlowInInterpolator = new LinearOutSlowInInterpolator();
        mHandler = new Handler();
        mInputMethodManager = (InputMethodManager) context.getSystemService
                (Context.INPUT_METHOD_SERVICE);

        setUpQuestionView();
        LinearLayout container = createContainerLayout(context);
        View quizContentView = getInitializedContentView();
        addContentView(container, quizContentView);
        addOnLayoutChangeListener(new OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom,
                                       int oldLeft,
                                       int oldTop, int oldRight, int oldBottom) {
                removeOnLayoutChangeListener(this);
            }
        });
    }

    /**
     * Sets the behaviour for all question views.
     */
    private void setUpQuestionView() {
        mQuestionView = (TextView) mLayoutInflater.inflate(R.layout.layout_question, this, false);
        mQuestionView.setBackgroundColor(ContextCompat.getColor(getContext(),
                yayPayParVo.getTheme().getPrimaryColor()));
        mQuestionView.setText(getQuiz().getQuestion());
    }

    private LinearLayout createContainerLayout(Context context) {
        LinearLayout container = new LinearLayout(context);
        container.setId(R.id.absQuizViewContainer);
        container.setOrientation(LinearLayout.VERTICAL);
        return container;
    }

    private View getInitializedContentView() {
        View quizContentView = createQuizContentView();
        quizContentView.setId(R.id.quiz_content);
        quizContentView.setSaveEnabled(true);
        setDefaultPadding(quizContentView);
        if (quizContentView instanceof ViewGroup) {
            ((ViewGroup) quizContentView).setClipToPadding(false);
        }
        setMinHeightInternal(quizContentView);
        return quizContentView;
    }

    private void addContentView(LinearLayout container, View quizContentView) {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        container.addView(mQuestionView, layoutParams);
        container.addView(quizContentView, layoutParams);
        addView(container, layoutParams);
    }



    private void setDefaultPadding(View view) {
        view.setPadding(mSpacingDouble, mSpacingDouble, mSpacingDouble, mSpacingDouble);
    }

    protected LayoutInflater getLayoutInflater() {
        return mLayoutInflater;
    }


    protected abstract View createQuizContentView();

    /**
     * Implementations must make sure that the answer provided is evaluated and correctly rated.
     *
     * @return <code>true</code> if the question has been correctly answered, else
     * <code>false</code>.
     */

    /**
     * Save the user input to a bundle for orientation changes.
     *
     * @return The bundle containing the user's input.
     */
    public abstract Bundle getUserInput();

    /**
     * Restore the user's input.
     *
     * @param savedInput The input that the user made in a prior instance of this view.
     */
    public abstract void setUserInput(Bundle savedInput);

    public Q getQuiz() {
        return mQuiz;
    }


    /**
     * Sets the quiz to answered or unanswered.
     *
     * @param answered <code>true</code> if an answer was selected, else <code>false</code>.
     */


    /**
     * Sets the quiz to answered if it not already has been answered.
     * Otherwise does nothing.
     */


    /**
     * Allows children to submit an answer via code.
     */

    @SuppressWarnings("UnusedParameters")


    /**
     * Animates the view nicely when the answer has been submitted.
     *
     * @param answerCorrect <code>true</code> if the answer was correct, else <code>false</code>.
     */




    private void resizeViewProperty(Property<View, Float> property,
                                    float targetScale, int durationOffset) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, property,
                1f, targetScale);
        animator.setInterpolator(mLinearOutSlowInInterpolator);
        animator.setStartDelay(FOREGROUND_COLOR_CHANGE_DELAY + durationOffset);
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        if (mHideFabRunnable != null) {
            mHandler.removeCallbacks(mHideFabRunnable);
        }
        if (mMoveOffScreenRunnable != null) {
            mHandler.removeCallbacks(mMoveOffScreenRunnable);
        }
        super.onDetachedFromWindow();
    }



    private void setMinHeightInternal(View view) {
        view.setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.min_height_question));
    }

    public abstract String getAnswer();


}
