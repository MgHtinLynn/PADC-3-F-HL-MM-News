package xyz.htinlynn.news.network;

import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.htinlynn.news.MMNewsApp;
import xyz.htinlynn.news.events.LoadedNewsEvent;
import xyz.htinlynn.news.network.responses.GetNewsResponse;

/**
 * Created by htinlynn on 1/6/18.
 */

public class RetrofitDataAgent implements NewsDataAgent {

    private static RetrofitDataAgent sObjInstance;
    private static NewsApi mNewsApi;

    private RetrofitDataAgent() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mNewsApi = retrofit.create(NewsApi.class);
    }

    public static RetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new RetrofitDataAgent();
        }
        return sObjInstance;
    }

    @Override
    public void loadNews() {

        Call<GetNewsResponse> getNewsResponseCall = mNewsApi.loadNews(1,"b002c7e1a528b7cb460933fc2875e916");
        getNewsResponseCall.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                GetNewsResponse getNewsResponse = response.body();
                if (getNewsResponse != null) {
                    EventBus.getDefault().post(new LoadedNewsEvent(getNewsResponse.getMmNews()));
                }
            }
            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {
                Log.e(MMNewsApp.LOG_TAG,"");
            }
        });
    }
}
