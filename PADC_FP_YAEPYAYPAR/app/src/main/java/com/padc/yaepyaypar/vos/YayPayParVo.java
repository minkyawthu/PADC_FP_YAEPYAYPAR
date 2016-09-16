
package com.padc.yaepyaypar.vos;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YayPayParVo {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("theme")
    @Expose
    private String theme;
    @SerializedName("quizzes")
    @Expose
    private List<Quiz> quizzes = new ArrayList<Quiz>();
    @SerializedName("solved")
    @Expose
    private String solved;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * 
     * @param theme
     *     The theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * 
     * @return
     *     The quizzes
     */
    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    /**
     * 
     * @param quizzes
     *     The quizzes
     */
    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    /**
     * 
     * @return
     *     The solved
     */
    public String getSolved() {
        return solved;
    }

    /**
     * 
     * @param solved
     *     The solved
     */
    public void setSolved(String solved) {
        this.solved = solved;
    }

}
