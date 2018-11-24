package voronchenko.testsebbia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import voronchenko.testsebbia.adapter.CategoryAdapter;
import voronchenko.testsebbia.pojo.Categories;
import voronchenko.testsebbia.pojo.Details;
import voronchenko.testsebbia.pojo.ListCategories;
import voronchenko.testsebbia.pojo.ShortNews;
import voronchenko.testsebbia.rest.NetworkService;

public class MainActivity extends AppCompatActivity {
    private RecyclerView categoriesRecyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Categories> listCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        getData();
    }

    // Получить список категорий с сервера
    private void getData() {
        NetworkService.getInstance()
                .getJSONApi()
                .getCategories()
                .enqueue(new Callback<ListCategories>() {
                    @Override
                    public void onResponse(Call<ListCategories> call, Response<ListCategories> response) {
                        if (response.body().getCode() == 0) {
                            listCategories = response.body().getList();
                            Collection<Categories> categories = listCategories;
                            categoryAdapter.setItems(categories);
                        }
                    }

                    @Override
                    public void onFailure(Call<ListCategories> call, Throwable t) {

                    }
                });

    }

    private void initRecyclerView() {
        categoriesRecyclerView = findViewById(R.id.categoriesRecyclerView);
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryAdapter = new CategoryAdapter();
        categoriesRecyclerView.setAdapter(categoryAdapter);
    }

    //
//
}
