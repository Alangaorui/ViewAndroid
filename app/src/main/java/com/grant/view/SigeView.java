package com.grant.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by grant on 2018/4/27 0027.
 */

public class SigeView extends View {
    private Paint mPaint;//初始化画笔

    public SigeView(Context context) {
        super(context);
    }

    // 第二个函数调用
    public SigeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //初始化画笔
        initView();
    }


    public SigeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @SuppressLint("NewApi")
    public SigeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);//设置画笔的颜色
        mPaint.setStrokeWidth(3f);//设置画笔的宽度
        mPaint.setStyle(Paint.Style.FILL);//充满
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 获取控件的高度和宽度

        //获取padding的大小
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();
        //减去边距
        int width = getWidth() - paddingLeft -paddingRight;
        int height = getHeight() -paddingTop - paddingBottom;

        int r = Math.min(width, height)/2;
        canvas.drawCircle(paddingLeft+width/2,paddingTop+height/2,r,mPaint);
    }
}
