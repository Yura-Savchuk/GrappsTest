package com.coulcod.triangleview.draw;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.coulcod.triangleview.PercentagePoint;
import com.coulcod.triangleview.mapper.PointMapper;
import com.coulcod.triangleview.Triangle;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public class DrawVertexHandle {

    private static final int EMPTY = -1;

    private final PointMapper pointMapper = new PointMapper();
    private int handleSize = EMPTY;

    public DrawVertexHandle() {
    }

    public void setViewSize(int width, int height) {
        pointMapper.setSize(width, height);
    }

    public void setHandleSize(int handleSize) {
        this.handleSize = handleSize;
    }

    public void draw(@NonNull Canvas canvas, @NonNull Triangle triangle, @NonNull Drawable vertexHandle) {
        if (!pointMapper.isSizeExist() || handleSize <= 0) return;
        drawHandle(canvas, triangle.point1, vertexHandle);
        drawHandle(canvas, triangle.point2, vertexHandle);
        drawHandle(canvas, triangle.point3, vertexHandle);
    }

    private void drawHandle(@NonNull Canvas canvas, @NonNull PercentagePoint point, @NonNull Drawable vertexHandle) {
        vertexHandle.setBounds(
                pointMapper.handleLeftPx(point.x, handleSize),
                pointMapper.handleTopPx(point.y, handleSize),
                pointMapper.handleRightPx(point.x, handleSize),
                pointMapper.handleBottomPx(point.y, handleSize)
        );
        vertexHandle.draw(canvas);
    }

}
