package xyz.htinlynn.news.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.htinlynn.news.MMNewsApp;
import xyz.htinlynn.news.R;
import xyz.htinlynn.news.adapters.NewsAdapter;
import xyz.htinlynn.news.data.models.NewsModel;
import xyz.htinlynn.news.delegates.NewsActionDelegate;
import xyz.htinlynn.news.events.LoadedNewsEvent;

/**
 * Created by htinlynn on 1/7/18.
 */

public class NewsByCategoryFragment extends Fragment implements NewsActionDelegate {

    @BindView(R.id.rv_news_by_category)
    RecyclerView rvNewsByCategory;

    private NewsAdapter mNewsByCategoryAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_by_category, container, false);
        ButterKnife.bind(this, view);


        mNewsByCategoryAdapter = new NewsAdapter(this);
        rvNewsByCategory.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
        rvNewsByCategory.setAdapter(mNewsByCategoryAdapter);

        NewsModel.getsObjInstance().loadNews();

        return view;


    }

    @Override
    public void onTrapNewsItem() {

    }

    @Override
    public void onTapCommentButton() {

    }

    @Override
    public void onTapSendToButton() {

    }

    @Override
    public void onTapFavouriteButton() {

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsLoaded(LoadedNewsEvent event) {
        Log.d(MMNewsApp.LOG_TAG, "onNewsLoaded: " + event.getNewsList().size());
        mNewsByCategoryAdapter.setNews(event.getNewsList());
    }
}
