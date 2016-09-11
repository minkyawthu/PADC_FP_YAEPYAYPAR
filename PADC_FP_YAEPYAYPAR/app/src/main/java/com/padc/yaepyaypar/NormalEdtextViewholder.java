package com.padc.yaepyaypar;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kaungkhantthu on 9/11/16.
 */
public class NormalEdtextViewholder extends RecyclerView.ViewHolder {

    private TextView txtQuestion;
    private EditText edAnswer;

    public NormalEdtextViewholder(View itemView) {
        super(itemView);

        txtQuestion = (TextView) itemView.findViewById(R.id.txt_question);
        edAnswer = (EditText) itemView.findViewById(R.id.ed_answer);

        edAnswer.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Log.e(YaePyayParApp.TAG, "onFocusChange: " );
            }
        });
    }
    public  void bindData(String question,String answer){
        txtQuestion.setText(question);
        edAnswer.setText(answer);
    }

}


