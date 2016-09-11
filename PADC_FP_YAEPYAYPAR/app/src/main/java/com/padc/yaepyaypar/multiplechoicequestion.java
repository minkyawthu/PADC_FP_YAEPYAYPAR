package com.padc.yaepyaypar;

import java.util.ArrayList;

/**
 * Created by kaungkhantthu on 9/11/16.
 */
public class multiplechoicequestion extends yaypayparpostvo {
    ArrayList<String> choice;
    public multiplechoicequestion(String question, String answer, boolean isanswered, int viewType) {
        super(question, answer, isanswered, viewType);
    }
}
