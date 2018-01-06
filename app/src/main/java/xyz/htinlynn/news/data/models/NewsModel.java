package xyz.htinlynn.news.data.models;

import xyz.htinlynn.news.network.HttpUrlConnectionDataAgent;
import xyz.htinlynn.news.network.NewsDataAgent;

/**
 * Created by htinlynn on 12/24/17.
 */

public class NewsModel {
    private static NewsModel sObjInstance;

    private NewsDataAgent mDataAgent;

    private NewsModel() {
        mDataAgent = HttpUrlConnectionDataAgent.getObjInstance();

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
