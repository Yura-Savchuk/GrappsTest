package com.coulcod.triangleview;

/**
 * This class represent triangle vertex position in percentage.
 * values of fields {@link PercentagePoint#x}, {@link PercentagePoint#y} can be 0..1
 *
 * Class in mutable.
 */

public final class PercentagePoint {

    public float x;
    public float y;

    PercentagePoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

}
