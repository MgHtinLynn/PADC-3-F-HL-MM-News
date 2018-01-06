package xyz.htinlynn.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.htinlynn.news.R;
import xyz.htinlynn.news.data.vo.NewsVO;
import xyz.htinlynn.news.delegates.NewsActionDelegate;

/**
 * Created by htinlynn on 12/8/17.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    @BindView(R.id.tv_news_brief)
    TextView tvNewsBrief;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

    @BindView(R.id.iv_news_image)
    ImageView ivNewsImage;




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

    public void setNews(NewsVO news) {
        tvPublicationTitle.setText(news.getPublication().getTitle());
        tvPostedDate.setText(news.getPostedDate());
        tvNewsBrief.setText(news.getDetails());
        Glide.with(ivPublicationLogo.getContext())
                .load(news.getPublication().getLogo())
                .into(ivPublicationLogo);
        if (news.getImages() != null) {
            ivNewsImage.setVisibility(View.VISIBLE);
            Glide.with(ivNewsImage.getContext())
                    .load(news.getImages().get(0))
                    .into(ivNewsImage);
        } else {
            ivNewsImage.setVisibility(View.GONE);
        }

    }

}
