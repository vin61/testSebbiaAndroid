package voronchenko.testsebbia.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListNews {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("list")
    @Expose
    private List<ShortNews> shortNews = new ArrayList<ShortNews>();
    @SerializedName("message")
    @Expose
    private String message;
    public boolean has_more;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ListNews withCode(int code) {
        this.code = code;
        return this;
    }

    public List<ShortNews> getShortNews() {
        return shortNews;
    }

    public void setShortNews(List<ShortNews> shortNews) {
        this.shortNews = shortNews;
    }

    public ListNews withShortNews(List<ShortNews> shortNews) {
        this.shortNews = shortNews;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }
}