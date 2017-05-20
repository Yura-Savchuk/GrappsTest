package com.coulcod.triangleview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.coulcod.triangleview.draw.DrawTriangle;
import com.coulcod.triangleview.draw.DrawVertexHandle;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public class TriangleView extends View {

    private Triangle triangle;
    private Drawable vertexHandle;
    private final DrawTriangle drawTriangle = new DrawTriangle();
    private final DrawVertexHandle drawVertexHandle = new DrawVertexHandle();

    public TriangleView(Context context) {
        this(context, null);
    }

    public TriangleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TriangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Resources.Theme theme = context.getTheme();
        TypedArray a = theme.obtainStyledAttributes(attrs, R.styleable.TriangleView, defStyleAttr, 0);
        triangle = TriangleCreate.fromTypeArray(a);
        int handleDrawableRes = a.getInt(R.styleable.TriangleView_handleDrawable, R.drawable.ic_dot_and_circle);
        vertexHandle = ContextCompat.getDrawable(getContext(), handleDrawableRes);
        drawVertexHandle.setHandleSize(vertexHandle.getIntrinsicHeight());
        a.recycle();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        drawTriangle.setViewSize(w, h);
        drawVertexHandle.setViewSize(w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawTriangle.draw(canvas, triangle);
        drawVertexHandle.draw(canvas, triangle, vertexHandle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return true;
    }
}
