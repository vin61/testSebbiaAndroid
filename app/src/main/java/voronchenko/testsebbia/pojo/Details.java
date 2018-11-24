package voronchenko.testsebbia.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Details {
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("news")
    @Expose
    private News news;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Details withCode(int code) {
        this.code = code;
        return this;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Details withNews(News news) {
        this.news = news;
        return this;
    }

}


