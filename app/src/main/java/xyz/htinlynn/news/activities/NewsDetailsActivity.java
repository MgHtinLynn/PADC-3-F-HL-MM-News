package xyz.htinlynn.news.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.htinlynn.news.R;
import xyz.htinlynn.news.adapters.ImagesInNewsDetailsAdapter;

/**
 * Created by htinlynn on 12/9/17.
 */

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.vp_news_details_images)
    ViewPager vpNewsDetailImages;

    private ImagesInNewsDetailsAdapter mImagesInNewsDetailsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this,this);
        mImagesInNewsDetailsAdapter = new ImagesInNewsDetailsAdapter();
        vpNewsDetailImages.setAdapter(mImagesInNewsDetailsAdapter);
    }
}
