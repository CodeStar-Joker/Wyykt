package com.zjx.wyykt;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.VideoView;

public class FullScreenVideoView extends VideoView {

    //主要用于直接new出来的对象
    public FullScreenVideoView(Context context) {
        super(context);
    }
    //主要用于xml文件当中 支持自定义树形
    public FullScreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //也是主要用于xml文件当中 支持自定义属性 同时支持style样式
    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //测量模式 测量大小
        //得到宽高
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width,height);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
