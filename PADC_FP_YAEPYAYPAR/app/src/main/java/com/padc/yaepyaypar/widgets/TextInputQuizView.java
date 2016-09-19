package com.padc.yaepyaypar.widgets;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.vos.Quiz;
import com.padc.yaepyaypar.vos.YayPayParVo;

public abstract class TextInputQuizView<Q extends Quiz> extends AbsQuizView<Q>
        implements TextWatcher, TextView.OnEditorActionListener {

    public TextInputQuizView(Context context, YayPayParVo category, Q quiz) {
        super(context, category, quiz);
    }

    protected final EditText createEditText() {
        EditText editText = (EditText) getLayoutInflater().inflate(
                R.layout.quiz_edit_text, this, false);
        editText.addTextChangedListener(this);
        editText.setOnEditorActionListener(this);
        return editText;
    }



    /**
     * Convenience method to hide the keyboard.
     *
     * @param view A view in the hierarchy.
     */
    protected void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = getInputMethodManager();
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private InputMethodManager getInputMethodManager() {
        return (InputMethodManager) getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (TextUtils.isEmpty(v.getText())) {
            return false;
        }
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            hideKeyboard(v);
            return true;
        }
        return false;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        /* no-op */
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        /* no-op */
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
