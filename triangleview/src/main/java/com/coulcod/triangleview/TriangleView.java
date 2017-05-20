package com.coulcod.triangleview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.coulcod.triangleview.draw.DrawTriangle;
import com.coulcod.triangleview.draw.DrawVertexHandle;
import com.coulcod.triangleview.mapper.PointMapper;
import com.coulcod.triangleview.touchEvent.OnTriangleChangeListener;
import com.coulcod.triangleview.touchEvent.VertexMotionEvent;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public class TriangleView extends View implements OnTriangleChangeListener {

    private static final String STATE_PARAM_SUPER_STATE = "super_state";
    private static final String STATE_PARAM_TRIANGLE = "triangle";
    private static final String STATE_PARAM_HANDLE_DRAWABLE_RES = "handle_drawable_res";

    private Triangle triangle;
    private int handleDrawableRes;
    private Drawable vertexHandle;
    private final PointMapper pointMapper = new PointMapper();
    private final DrawTriangle drawTriangle = new DrawTriangle();
    private final DrawVertexHandle drawVertexHandle = new DrawVertexHandle();
    private final VertexMotionEvent vertexMotionEvent = new VertexMotionEvent(this);

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
        handleDrawableRes = a.getInt(R.styleable.TriangleView_handleDrawable, R.drawable.ic_dot_and_circle);
        vertexHandle = ContextCompat.getDrawable(getContext(), handleDrawableRes);
        setHandleSize(vertexHandle.getIntrinsicHeight());
        a.recycle();
    }

    private void setHandleSize(int size) {
        drawVertexHandle.setHandleSize(size);
        vertexMotionEvent.setHandleSize(size);
    }

    public TriangleArea getArea() {
        if (!pointMapper.isSizeExist()) {
            throw new RuntimeException("Triangle area can't be calculated before the view size established.");
        }
        return TriangleArea.create(triangle, pointMapper);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        pointMapper.setSize(w, h);
        drawTriangle.setViewSize(w, h);
        drawVertexHandle.setViewSize(w, h);
        vertexMotionEvent.setViewSize(w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawTriangle.draw(canvas, triangle);
        drawVertexHandle.draw(canvas, triangle, vertexHandle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        vertexMotionEvent.onTouchEvent(event, triangle);
        return true;
    }

    @Override
    public void onTriangleChange() {
        invalidate();
    }

    //save state

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_PARAM_TRIANGLE, triangle);
        bundle.putInt(STATE_PARAM_HANDLE_DRAWABLE_RES, handleDrawableRes);
        bundle.putParcelable(STATE_PARAM_SUPER_STATE, super.onSaveInstanceState());
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            triangle = bundle.getParcelable(STATE_PARAM_TRIANGLE);
            handleDrawableRes = bundle.getInt(STATE_PARAM_HANDLE_DRAWABLE_RES);
            vertexHandle = ContextCompat.getDrawable(getContext(), handleDrawableRes);
            setHandleSize(vertexHandle.getIntrinsicHeight());
            state = bundle.getParcelable(STATE_PARAM_SUPER_STATE);
        }
        super.onRestoreInstanceState(state);
    }
}
