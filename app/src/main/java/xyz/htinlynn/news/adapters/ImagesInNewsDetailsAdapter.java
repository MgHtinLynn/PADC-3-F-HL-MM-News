package xyz.htinlynn.news.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.htinlynn.news.R;
import xyz.htinlynn.news.viewitems.ImageInNewsDetailViewItem;

/**
 * Created by htinlynn on 12/17/17.
 */

public class ImagesInNewsDetailsAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
//        if (object instanceof View)
//            return true;
//        else
//            return false;
        //return (object instanceof View);
        return (view == (View) object);


    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ImageInNewsDetailViewItem view = (ImageInNewsDetailViewItem) layoutInflater.inflate(R.layout.item_news_detail_images,container,false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
