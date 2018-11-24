package voronchenko.testsebbia.paging;


import android.arch.lifecycle.MutableLiveData;

import android.arch.paging.DataSource;
import android.arch.paging.DataSource.Factory;
import android.arch.paging.PageKeyedDataSource;

import voronchenko.testsebbia.pojo.ShortNews;

public class NewsDataSourceFactory extends Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, ShortNews>> shortNewsLiveDataSource = new MutableLiveData<>();

    @Override
    public DataSource<Integer, ShortNews> create() {
        NewsDataSource newsDataSource = new NewsDataSource();
        shortNewsLiveDataSource.postValue((newsDataSource));
        return newsDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, ShortNews>> getShortNewsLiveDataSource(){
        return shortNewsLiveDataSource;
    }
}
