package com.coulcod.triangleview.touchEvent;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.coulcod.triangleview.PercentagePoint;
import com.coulcod.triangleview.Triangle;
import com.coulcod.triangleview.mapper.PointMapper;

import static com.coulcod.triangleview.util.Assertion.nonnull;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

class PointFind {

    final PointMapper pointMapper;
    Triangle triangle;
    int handleSize = Integer.MIN_VALUE;

    PointFind() {
        this.pointMapper = new PointMapper();
    }

    void setSize(int w, int h) {
        pointMapper.setSize(w, h);
    }

    boolean isSizeExist() {
        return pointMapper.isSizeExist() && handleSize > 0;
    }

    @Nullable
    PercentagePoint getPoint(int x, int y) {
        nonnull(triangle);
        if (isHandlerPointAtPosition(triangle.point1, x, y)) return triangle.point1;
        if (isHandlerPointAtPosition(triangle.point2, x, y)) return triangle.point2;
        if (isHandlerPointAtPosition(triangle.point3, x, y)) return triangle.point3;
        return null;
    }

    private boolean isHandlerPointAtPosition(@NonNull PercentagePoint point, int x, int y) {
        int left = pointMapper.handleLeftPx(point.x, handleSize);
        int top = pointMapper.handleTopPx(point.y, handleSize);
        int right = pointMapper.handleRightPx(point.x, handleSize);
        int bottom = pointMapper.handleBottomPx(point.y, handleSize);
        return x >= left && x <= right && y >= top && y <= bottom;
    }
}
