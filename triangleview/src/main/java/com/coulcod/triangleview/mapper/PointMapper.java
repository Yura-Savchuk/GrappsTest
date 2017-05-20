package com.coulcod.triangleview.mapper;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public class PointMapper {

    private static final int EMPTY = -1;

    private int viewWidth = EMPTY;
    private int viewHeight = EMPTY;

    public void setSize(int width, int height) {
        viewWidth = width;
        viewHeight = height;
    }

    public boolean isSizeExist() {
        return viewHeight >= 0 && viewWidth >= 0;
    }

    public int xPointToPx(float percentageX) {
        return (int) (viewWidth * percentageX);
    }

    public int yPointToPx(float percentageY) {
        return (int) (viewHeight * percentageY);
    }

    public int handleLeftPx(float percentageX, int handleSize) {
        return xPointToPx(percentageX) - handleSize/2;
    }

    public int handleTopPx(float percentageY, int handleSize) {
        return yPointToPx(percentageY) - handleSize/2;
    }

    public int handleRightPx(float percentageX, int handleSize) {
        return xPointToPx(percentageX) + handleSize/2;
    }

    public int handleBottomPx(float percentageY, int handleSize) {
        return yPointToPx(percentageY) + handleSize/2;
    }

}
