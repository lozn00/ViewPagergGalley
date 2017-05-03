package cn.qssq666.viewpagerggalley;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by luozheng on 2017/5/3.  qssq.space
 */

public class GallyPageTransformer implements ViewPager.PageTransformer {
    private static final float min_scale = 0.95f;
//    private static final float min_scale = 0.85f;
    private static final String TAG = "GallyPageTransformer";

    @Override
    public void transformPage(View page, float position) {
        float scaleFactor = Math.max(min_scale, 1 - Math.abs(position));
        Log.w(TAG,"scaleFactor:"+scaleFactor+",position:"+position);
        float rotate = 20 * Math.abs(position);
        if (position < -1) {

        } else if (position < 0) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        } else if (position >= 0 && position < 1) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        } else if (position >= 1) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        }
    }
}