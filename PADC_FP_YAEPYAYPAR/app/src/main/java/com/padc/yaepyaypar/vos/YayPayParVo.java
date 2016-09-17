
package com.padc.yaepyaypar.vos;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.padc.yaepyaypar.Theme;

public class YayPayParVo {

    /**name is use for the title of the yay pay par specific category name **/
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;
    /**name is use for the title of the yay pay par specific category color **/

    @SerializedName("theme")
    @Expose
    private String theme;
    /**questions that are going to be included in the specific yay pay par form**/
    @SerializedName("quizzes")
    @Expose
    private List<Quiz> quizzes = new ArrayList<Quiz>();
    @SerializedName("answered")
    @Expose
    private boolean answered;
    private Theme cTheme;

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
    public Theme getTheme() {
        switch (this.theme){
            case "blue": return Theme.blue;

            case "yellow": return Theme.yellow;

            case "green": return  Theme.green;

            case "purple": return Theme.purple;

            case "base": return Theme.mapp;

        }


        return Theme.mapp;
    }

    /**
     * 
     * @param theme
     *     The theme
     */


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
    public boolean getSolved() {
        return answered;
    }

    /**
     * 
     * @param answered
     *     The solved
     */
    public void setSolved(boolean answered) {
        this.answered = answered;
    }

}
