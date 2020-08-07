package com.neversettle.statusdownloader.widget;

import android.content.Context;
import android.content.res.TypedArray;

import android.util.AttributeSet;
import android.view.View;

import androidx.cardview.widget.CardView;

import com.neversettle.statusdownloader.R;


public class BoundedCardView extends CardView {

    private int boundedWidth;
    private int boundedHeight;

    public BoundedCardView(Context context) {
        super(context);
        boundedWidth = 0;
        boundedHeight = 0;
    }

    public BoundedCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BoundedView);
        boundedWidth = a.getDimensionPixelSize(R.styleable.BoundedView_bounded_width, 0);
        boundedHeight = a.getDimensionPixelSize(R.styleable.BoundedView_bounded_height, 0);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Adjust width as necessary
        int measuredWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        if (boundedWidth > 0 && boundedWidth < measuredWidth) {
            int measureMode = View.MeasureSpec.getMode(widthMeasureSpec);
            widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(boundedWidth, measureMode);
        }
        // Adjust height as necessary
        int measuredHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        if (boundedHeight > 0 && boundedHeight < measuredHeight) {
            int measureMode = View.MeasureSpec.getMode(heightMeasureSpec);
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(boundedHeight, measureMode);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
