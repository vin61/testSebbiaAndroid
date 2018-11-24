package voronchenko.testsebbia.paging;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import voronchenko.testsebbia.ShortNewsActivity;
import voronchenko.testsebbia.pojo.ListNews;
import voronchenko.testsebbia.pojo.ShortNews;
import voronchenko.testsebbia.rest.NetworkService;

public class NewsDataSource extends PageKeyedDataSource<Integer, ShortNews> {

    public static final int FIRST_PAGE = 0;

    private int categoryID = ShortNewsActivity.getCategoryID();

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, ShortNews> callback) {
        NetworkService.getInstance()
                .getJSONApi()
                .getListNewsWithID(categoryID, FIRST_PAGE)
                .enqueue(new Callback<ListNews>() {
                    @Override
                    public void onResponse(Call<ListNews> call, Response<ListNews> response) {
                        if (response.body().getCode() == 0) {
                            callback.onResult(response.body()
                                    .getShortNews(), null, FIRST_PAGE + 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<ListNews> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ShortNews> callback) {
        NetworkService.getInstance()
                .getJSONApi()
                .getListNewsWithID(categoryID, params.key)
                .enqueue(new Callback<ListNews>() {
                    @Override
                    public void onResponse(Call<ListNews> call, Response<ListNews> response) {
                        Integer aadjacentKey = (params.key > 0) ? params.key - 1 : null;
                        if (response.body() != null) {
                            callback.onResult(response.body().getShortNews(), aadjacentKey);
                        }
                    }

                    @Override
                    public void onFailure(Call<ListNews> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ShortNews> callback) {
        NetworkService.getInstance()
                .getJSONApi()
                .getListNewsWithID(categoryID, params.key)
                .enqueue(new Callback<ListNews>() {
                    @Override
                    public void onResponse(Call<ListNews> call, Response<ListNews> response) {
                        if (response.body() != null) {
                            Integer key = response.body().has_more ? params.key + 1 : null;
                            callback.onResult(response.body().getShortNews(), key);
                        }

                    }

                    @Override
                    public void onFailure(Call<ListNews> call, Throwable t) {

                    }
                });
    }
}
