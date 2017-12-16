package xyz.htinlynn.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.htinlynn.news.R;

/**
 * Created by htinlynn on 12/8/17.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    public ItemNewsViewHolder(final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @OnClick(R.id.cv_news_item_root)
    public void onNewsItemTap(View view) {
        Toast.makeText(view.getContext(),"News Item Clicked",Toast.LENGTH_LONG).show();
    }

}
