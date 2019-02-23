package com.example.viewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Scroller;

public class MyView extends android.support.v7.widget.AppCompatTextView {

    Paint mPaint1;
    Paint mPaint2;
    Scroller mScroller = new Scroller(getContext());

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);
        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, mPaint2);
        canvas.save();
        canvas.translate(10, 10);
        super.onDraw(canvas);
    }

    private void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int deltax = destX - scrollX;
        mScroller.startScroll(scrollX, 0, deltax, 0, 1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
