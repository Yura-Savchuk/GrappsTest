package com.coulcod.triangleview.touchEvent;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MotionEvent;

import com.coulcod.triangleview.PercentagePoint;
import com.coulcod.triangleview.Triangle;
import com.coulcod.triangleview.mapper.PointMapper;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public class VertexMotionEvent {

    private final OnTriangleChangeListener listener;

    private PointFind pointFind = new PointFind();

    private PercentagePoint point;

    public VertexMotionEvent(OnTriangleChangeListener listener) {
        this.listener = listener;
    }

    public void setHandleSize(int handleSize) {
        pointFind.handleSize = handleSize;
    }

    public void setViewSize(int w, int h) {
        pointFind.setSize(w, h);
    }

    public void onTouchEvent(MotionEvent event, @NonNull Triangle triangle) {
        if (!pointFind.isSizeExist()) return;
        pointFind.triangle = triangle;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                onActionDown(event);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                onActionMove(event);
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                onActionUp(event);
                break;
            }
        }
    }
    private void onActionDown(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        point = pointFind.getPoint(x, y);
    }

    private void onActionMove(MotionEvent event) {
        if (point == null) return;
        float x = event.getX();
        float y = event.getY();
        PointMapper mapper = pointFind.pointMapper;
        float newX = mapper.xToPercentage(x);
        if (newX >= 0 && newX <= 1) {
            point.x = newX;
        }
        float newY = mapper.yToPercentage(y);
        if (newY >= 0 && newY <= 1) {
            point.y = newY;
        }
        listener.onTriangleChange();
    }

    private void onActionUp(MotionEvent event) {
        point = null;
    }
}
