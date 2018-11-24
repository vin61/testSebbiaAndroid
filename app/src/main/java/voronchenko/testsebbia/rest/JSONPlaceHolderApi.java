package voronchenko.testsebbia.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import voronchenko.testsebbia.pojo.Details;
import voronchenko.testsebbia.pojo.ListCategories;
import voronchenko.testsebbia.pojo.ListNews;

public interface JSONPlaceHolderApi {
    @GET("/v1/news/details/")
    public Call<Details> getPostWithID(@Query("id") int id);

    @GET("/v1/news/categories")
    public Call<ListCategories> getCategories();

    @GET("/v1/news/categories/{id}/news")
    public Call<ListNews> getListNewsWithID(@Path("id") int id, @Query("page") int page);

}
