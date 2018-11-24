package voronchenko.testsebbia;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import android.arch.paging.PagedList;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import voronchenko.testsebbia.adapter.ShortNewsAdapter;
import voronchenko.testsebbia.paging.ShortNewsViewModel;
import voronchenko.testsebbia.pojo.ShortNews;

public class ShortNewsActivity extends AppCompatActivity {

    private RecyclerView shortNewsRecycleView;
    private static int categoryID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Intent intent = getIntent();

        categoryID = intent.getIntExtra("id", 0);

        initRecyclerView();
    }

    private void initRecyclerView() {
        shortNewsRecycleView = findViewById(R.id.shortNewsRecyclerView);
        shortNewsRecycleView.setLayoutManager(new LinearLayoutManager(this));
        shortNewsRecycleView.setHasFixedSize(true);
        ShortNewsViewModel shortNewsViewModel = ViewModelProviders.of(this).get(ShortNewsViewModel.class);
        final ShortNewsAdapter shortNewsAdapter = new ShortNewsAdapter(this);
        shortNewsViewModel.shortNewsPagedList.observe(this, new Observer<PagedList<ShortNews>>() {
            @Override
            public void onChanged(@Nullable PagedList<ShortNews> shortNews) {
                shortNewsAdapter.submitList(shortNews);
            }
        });
        shortNewsRecycleView.setAdapter(shortNewsAdapter);
    }

    public static int getCategoryID() {
        return categoryID;
    }
}
