package voronchenko.testsebbia.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListCategories {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("list")
    @Expose
    private java.util.List<voronchenko.testsebbia.pojo.Categories> list = new ArrayList<voronchenko.testsebbia.pojo.Categories>();
    @SerializedName("message")
    @Expose
    private String message = null;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ListCategories withCode(int code) {
        this.code = code;
        return this;
    }

    public java.util.List<voronchenko.testsebbia.pojo.Categories> getList() {
        return list;
    }

    public void setList(java.util.List<voronchenko.testsebbia.pojo.Categories> list) {
        this.list = list;
    }

    public ListCategories withList(java.util.List<voronchenko.testsebbia.pojo.Categories> list) {
        this.list = list;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}