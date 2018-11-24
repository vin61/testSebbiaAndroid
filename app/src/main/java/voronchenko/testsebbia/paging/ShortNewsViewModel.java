package voronchenko.testsebbia.paging;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

import voronchenko.testsebbia.pojo.ShortNews;

public class ShortNewsViewModel extends ViewModel {
   public LiveData<PagedList<ShortNews>> shortNewsPagedList;
    LiveData<PageKeyedDataSource<Integer, ShortNews>> liveDataSource;

    public ShortNewsViewModel(){
        NewsDataSourceFactory newsDataSourceFactory = new NewsDataSourceFactory();

        liveDataSource = newsDataSourceFactory.getShortNewsLiveDataSource();
        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(10).build();

        shortNewsPagedList = (new LivePagedListBuilder(newsDataSourceFactory, pagedListConfig))
                .build();
    }
}
