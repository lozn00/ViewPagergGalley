package cn.qssq666.viewpagerggalley;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by luozheng on 2017/5/3.  qssq.space
 */

public class MyViewPagerAdapter  extends PagerAdapter {
    private List<ImageView> listViews;

    public MyViewPagerAdapter(List<ImageView> listViews) {
        this.listViews = listViews;
    }

    @Override
    public int getCount() {
        return listViews == null ? 0 : listViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = listViews.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(listViews.get(position));
    }
}