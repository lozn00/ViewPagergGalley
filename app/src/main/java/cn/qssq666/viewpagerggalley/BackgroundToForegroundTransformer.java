package cn.qssq666.viewpagerggalley;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by luozheng on 2017/5/3.  qssq.space
 */

public class BackgroundToForegroundTransformer implements ViewPager.PageTransformer {

    private static final float min(float val, float min) {
        return val < min ? min : val;
    }

    @Override
    public void transformPage(View view, float position) {
        final float height = view.getHeight();
        final float width = view.getWidth();
        final float scale = min(position < 0 ? 1f : Math.abs(1f - position), 0.5f);

        view.setScaleX(scale);
        view.setScaleY(scale);
        view.setPivotX(width * 0.5f);
        view.setPivotY(height * 0.5f);
        view.setTranslationX(position < 0 ? width * position : -width * position * 0.25f);
    }
}
