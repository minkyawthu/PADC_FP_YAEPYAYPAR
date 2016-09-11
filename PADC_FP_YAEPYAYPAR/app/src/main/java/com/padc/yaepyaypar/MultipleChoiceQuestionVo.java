package com.padc.yaepyaypar;

import java.util.ArrayList;

/**
 * Created by kaungkhantthu on 9/11/16.
 */
public class MultipleChoiceQuestionVo extends YayPayParPostVo {
    ArrayList<Integer> choice;
    public MultipleChoiceQuestionVo(String question, String answer, boolean isanswered, int viewType) {
        super(question, answer, isanswered, viewType);
    }

    public MultipleChoiceQuestionVo(String question, String answer, boolean isanswered, int viewType, ArrayList<Integer> choice) {
        super(question, answer, isanswered, viewType);
        this.choice = choice;
    }
}
