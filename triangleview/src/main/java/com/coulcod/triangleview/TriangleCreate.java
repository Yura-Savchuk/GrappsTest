package com.coulcod.triangleview;

import android.content.res.TypedArray;
import android.support.annotation.NonNull;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

class TriangleCreate {

    static Triangle fromTypeArray(@NonNull TypedArray typedArray) {
        float x = typedArray.getFloat(R.styleable.TriangleView_percentagePoint1x, 0f);
        float y = typedArray.getFloat(R.styleable.TriangleView_percentagePoint1y, 0.5f);
        PercentagePoint point1 = new PercentagePoint(x, y);
        x = typedArray.getFloat(R.styleable.TriangleView_percentagePoint2x, 0f);
        y = typedArray.getFloat(R.styleable.TriangleView_percentagePoint2y, 1f);
        PercentagePoint point2 = new PercentagePoint(x, y);
        x = typedArray.getFloat(R.styleable.TriangleView_percentagePoint3x, 1f);
        y = typedArray.getFloat(R.styleable.TriangleView_percentagePoint3y, 1f);
        PercentagePoint point3 = new PercentagePoint(x, y);
        return new Triangle(point1, point2, point3);
    }

}
