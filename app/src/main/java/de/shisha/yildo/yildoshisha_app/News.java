package de.shisha.yildo.yildoshisha_app;

/**
 * Created by Marc on 21.11.2017.
 */

public class News {

    private String title;
    private String text;

    public News(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }
}
