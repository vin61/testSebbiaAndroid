package voronchenko.testsebbia.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("fullDescription")
    @Expose
    private String fullDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public News withId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public News withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public News withDate(String date) {
        this.date = date;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public News withShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public News withFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
        return this;
    }

}