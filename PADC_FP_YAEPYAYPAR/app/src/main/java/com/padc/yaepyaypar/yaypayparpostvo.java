package com.padc.yaepyaypar;

/**
 * Created by kaungkhantthu on 9/11/16.
 */
public class YayPayParPostVo {

    protected String question;
    protected String answer;
    protected boolean isanswered;
    protected int viewType;

    public YayPayParPostVo(String question, String answer, boolean isanswered, int viewType) {
        this.question = question;
        this.answer = answer;
        this.isanswered = isanswered;
        this.viewType = viewType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isanswered() {
        return isanswered;
    }

    public void setIsanswered(boolean isanswered) {
        this.isanswered = isanswered;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
