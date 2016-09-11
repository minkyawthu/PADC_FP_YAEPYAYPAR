package com.padc.yaepyaypar;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kaungkhantthu on 9/11/16.
 */
public class MultipleChoiceViewholder extends RecyclerView.ViewHolder {


    private TextView txtQuestion;
    private ImageView imgchoice1;
    private ImageView imgchoice2;
    private ImageView imgchoice3;


    public MultipleChoiceViewholder(View itemView) {
        super(itemView);
        txtQuestion = (TextView) itemView.findViewById(R.id.txt_question);
        imgchoice1 =(ImageView) itemView.findViewById(R.id.choice1);
        imgchoice2 =(ImageView) itemView.findViewById(R.id.choice2);
        imgchoice3 =(ImageView) itemView.findViewById(R.id.choice3);


    }

    public void bindData(String question, int img1,int img2,int img3) {
        txtQuestion.setText(question);
        imgchoice1.setImageResource(R.mipmap.ic_launcher);
        imgchoice2.setImageResource(R.mipmap.ic_launcher);
        imgchoice3.setImageResource(R.mipmap.ic_launcher);


    }


}
