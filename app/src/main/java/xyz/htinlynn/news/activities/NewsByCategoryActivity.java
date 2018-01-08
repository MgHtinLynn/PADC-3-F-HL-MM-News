package xyz.htinlynn.news.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.htinlynn.news.R;
import xyz.htinlynn.news.adapters.NewsByCategoryAdapter;
import xyz.htinlynn.news.data.models.NewsModel;
import xyz.htinlynn.news.fragments.NewsByCategoryFragment;
import xyz.htinlynn.news.fragments.NewsByInternationalFragment;
import xyz.htinlynn.news.fragments.NewsByLocalFragment;

/**
 * Created by htinlynn on 1/7/18.
 */

public class NewsByCategoryActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_by_category)
    ViewPager vpNewsByCategory;

    @BindView(R.id.tb_news_by_category)
    TabLayout tbNewsByCategory;
    


    private NewsByCategoryAdapter mNewsByCategoryAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_by_category);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle(R.string.title_news_by_category);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mNewsByCategoryAdapter = new NewsByCategoryAdapter(getSupportFragmentManager());
        vpNewsByCategory.setAdapter(mNewsByCategoryAdapter);

        mNewsByCategoryAdapter.addTab("Local News", new NewsByCategoryFragment());
        mNewsByCategoryAdapter.addTab("International News", new NewsByLocalFragment());
        mNewsByCategoryAdapter.addTab("Sports News", new NewsByInternationalFragment());

        tbNewsByCategory.setupWithViewPager(vpNewsByCategory);




    }


}
