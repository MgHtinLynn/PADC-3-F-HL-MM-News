package xyz.htinlynn.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.htinlynn.news.R;
import xyz.htinlynn.news.delegates.NewsActionDelegate;

/**
 * Created by htinlynn on 12/8/17.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    private NewsActionDelegate mNewsActionDelegate;

    public ItemNewsViewHolder(View itemView,NewsActionDelegate mNewsActionDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.mNewsActionDelegate = mNewsActionDelegate;
    }

    @OnClick(R.id.cv_news_item_root)
    public void onNewsItemTap(View view) {
        mNewsActionDelegate.onTrapNewsItem();
        //Toast.makeText(view.getContext(),"News Item Clicked",Toast.LENGTH_LONG).show();
    }

}
