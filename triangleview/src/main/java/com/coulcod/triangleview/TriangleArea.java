package com.coulcod.triangleview;

import android.support.annotation.NonNull;

import com.coulcod.triangleview.mapper.PointMapper;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public class TriangleArea {

    private final int value;

    private TriangleArea(int value) {
        this.value = value;
    }

    /** Calculate triangle area by Herona formula.
     */
    public static TriangleArea create(@NonNull Triangle triangle, PointMapper mapper) {
        int x1 = mapper.xPointToPx(triangle.point1.x);
        int y1 = mapper.yPointToPx(triangle.point1.y);
        int x2 = mapper.xPointToPx(triangle.point2.x);
        int y2 = mapper.yPointToPx(triangle.point2.y);
        int x3 = mapper.xPointToPx(triangle.point3.x);
        int y3 = mapper.yPointToPx(triangle.point3.y);
        double a = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        double b = Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
        double c = Math.sqrt((x3-x1)*(x3-x1) + (y3-y1)*(y3-y1));
        double p = (a+b+c)/2;
        double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return new TriangleArea((int) area);
    }

    public int getValue() {
        return value;
    }
}
