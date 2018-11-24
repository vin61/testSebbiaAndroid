package voronchenko.testsebbia.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static final NetworkService ourInstance = new NetworkService();
    private static final String BASE_URL = "http://testtask.sebbia.com";
    private Retrofit mRetrofit;

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        return ourInstance;
    }

    public JSONPlaceHolderApi getJSONApi(){
        return mRetrofit.create(JSONPlaceHolderApi.class);
    }

}
