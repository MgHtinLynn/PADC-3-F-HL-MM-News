package xyz.htinlynn.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.htinlynn.news.R;
import xyz.htinlynn.news.data.vo.NewsVO;
import xyz.htinlynn.news.delegates.NewsActionDelegate;
import xyz.htinlynn.news.viewholders.ItemNewsViewHolder;

/**
 * Created by htinlynn on 12/8/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<ItemNewsViewHolder> {

    private NewsActionDelegate mNewsActionDelegate;
    private List<NewsVO>  mNewsList;

    public NewsAdapter(NewsActionDelegate newsActionDelegate) {
        mNewsActionDelegate = newsActionDelegate;
        mNewsList = new ArrayList<>();

    }

    @Override
    public ItemNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View newsItemView = inflater.inflate(R.layout.item_news, parent, false);
        ItemNewsViewHolder itemNewsViewHolder = new ItemNewsViewHolder(newsItemView,mNewsActionDelegate);
        return itemNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemNewsViewHolder holder, int position) {
        holder.setNews(mNewsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void setNews(List<NewsVO> newsList) {
        mNewsList = newsList;
        notifyDataSetChanged();
    }
}
