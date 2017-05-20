package com.coulcod.triangleview;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public final class Triangle implements Parcelable {

    public final PercentagePoint point1;
    public final PercentagePoint point2;
    public final PercentagePoint point3;

    Triangle(PercentagePoint point1, PercentagePoint point2, PercentagePoint point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.point1, flags);
        dest.writeParcelable(this.point2, flags);
        dest.writeParcelable(this.point3, flags);
    }

    protected Triangle(Parcel in) {
        this.point1 = in.readParcelable(PercentagePoint.class.getClassLoader());
        this.point2 = in.readParcelable(PercentagePoint.class.getClassLoader());
        this.point3 = in.readParcelable(PercentagePoint.class.getClassLoader());
    }

    public static final Parcelable.Creator<Triangle> CREATOR = new Parcelable.Creator<Triangle>() {
        @Override
        public Triangle createFromParcel(Parcel source) {
            return new Triangle(source);
        }

        @Override
        public Triangle[] newArray(int size) {
            return new Triangle[size];
        }
    };
}
