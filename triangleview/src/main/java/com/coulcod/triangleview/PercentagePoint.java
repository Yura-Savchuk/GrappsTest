package com.coulcod.triangleview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class represent triangle vertex position in percentage.
 * values of fields {@link PercentagePoint#x}, {@link PercentagePoint#y} can be 0..1
 *
 * Class in mutable.
 */

public final class PercentagePoint implements Parcelable {

    public float x;
    public float y;

    PercentagePoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(this.x);
        dest.writeFloat(this.y);
    }

    protected PercentagePoint(Parcel in) {
        this.x = in.readFloat();
        this.y = in.readFloat();
    }

    public static final Parcelable.Creator<PercentagePoint> CREATOR = new Parcelable.Creator<PercentagePoint>() {
        @Override
        public PercentagePoint createFromParcel(Parcel source) {
            return new PercentagePoint(source);
        }

        @Override
        public PercentagePoint[] newArray(int size) {
            return new PercentagePoint[size];
        }
    };
}
