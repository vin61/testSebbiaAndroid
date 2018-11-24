package voronchenko.testsebbia.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShortNews {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShortNews withId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ShortNews withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ShortNews withDate(String date) {
        this.date = date;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public ShortNews withShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

}