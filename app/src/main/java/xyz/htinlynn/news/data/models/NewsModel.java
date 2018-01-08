package xyz.htinlynn.news.data.models;

import xyz.htinlynn.news.network.HttpUrlConnectionDataAgent;
import xyz.htinlynn.news.network.NewsDataAgent;
import xyz.htinlynn.news.network.OKHttpDataAgent;
import xyz.htinlynn.news.network.RetrofitDataAgent;

/**
 * Created by htinlynn on 12/24/17.
 */

public class NewsModel {
    private static NewsModel sObjInstance;

    private NewsDataAgent mDataAgent;

    private NewsModel() {
        //mDataAgent = HttpUrlConnectionDataAgent.getObjInstance();
        //mDataAgent = OKHttpDataAgent.getsObjInstance();
        mDataAgent = RetrofitDataAgent.getsObjInstance();

    }
    public static NewsModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new NewsModel();
        }
        return sObjInstance;
    }

    /**
     * network request api for load news
     */
    public void loadNews() {
        mDataAgent.loadNews();
    }
}
