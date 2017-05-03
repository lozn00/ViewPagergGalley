package cn.qssq666.viewpagerggalley;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/dolphinwang/ImageCoverFlow
 * qssq666.cn
 */
public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private ViewPager mViewPager;
    private LinearLayout ll_main;
    private List<ImageView> imageViews;
    private int pagerWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        ll_main = (LinearLayout) findViewById(R.id.activity_main);
        initData();

        mViewPager.setOffscreenPageLimit(3);
        pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels);
        Log.w(TAG, "");
//        pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 3.0f / 5.0f);
        int value = DensityUtil.dip2px(this, 100);
        pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels - (value * 2));
//        pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 3.0f / 5.0f);
        ViewGroup.LayoutParams lp = mViewPager.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        } else {
            lp.width = pagerWidth;
        }
        mViewPager.setLayoutParams(lp);
//        mViewPager.setPageMargin(-(value*2));
        ll_main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mViewPager.dispatchTouchEvent(motionEvent);
            }
        });
        mViewPager.setPageTransformer(true, new GallyPage1Transformer());
//        mViewPager.setPageTransformer(true, new GallyPageTransformer());
        mViewPager.setAdapter(new MyViewPagerAdapter(imageViews));
    }

    private void initData() {
        imageViews = new ArrayList<>();
        ImageView first = new ImageView(MainActivity.this);
//        first.setImageBitmap(ImageUtil.getReverseBitmapById(R.drawable.img1, MainActivity.this));
        first.setImageResource(R.drawable.img1);
        add(first);
        first = new ImageView(MainActivity.this);
//        first.setImageBitmap(ImageUtil.getReverseBitmapById(R.drawable.img2, MainActivity.this));
        first.setImageResource(R.drawable.img2);
        add(first);
        first = new ImageView(MainActivity.this);
        first.setImageResource(R.drawable.img3);
        add(first);
        first = new ImageView(MainActivity.this);
        first.setImageResource(R.drawable.img1);
        add(first);
        first = new ImageView(MainActivity.this);
        first.setImageResource(R.drawable.img2);
        add(first);
//        first.setImageBitmap(ImageUtil.getReverseBitmapById(R.drawable.img3, MainActivity.this));
    }

    public void add(ImageView view) {
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        imageViews.add(view);
        view.setBackgroundColor(Color.parseColor("#9900ffff"));
    }
}
