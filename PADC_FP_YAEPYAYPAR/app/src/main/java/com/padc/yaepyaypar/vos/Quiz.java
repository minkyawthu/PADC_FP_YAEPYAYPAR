
package com.padc.yaepyaypar.vos;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quiz {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("captions")
    @Expose
    private List<String> captions = new ArrayList<String>();
    @SerializedName("answer")
    @Expose
    private String answer;

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 
     * @param question
     *     The question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * 
     * @return
     *     The captions
     */
    public List<String> getCaptions() {
        return captions;
    }

    /**
     * 
     * @param captions
     *     The captions
     */
    public void setCaptions(List<String> captions) {
        this.captions = captions;
    }

    /**
     * 
     * @return
     *     The answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 
     * @param answer
     *     The answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
