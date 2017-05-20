package com.coulcod.triangleview.draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.NonNull;

import com.coulcod.triangleview.mapper.PointMapper;
import com.coulcod.triangleview.Triangle;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public class DrawTriangle {

    private final PointMapper pointMapper = new PointMapper();

    public DrawTriangle() {

    }

    public void setViewSize(int width, int height) {
        pointMapper.setSize(width, height);
    }

    public void draw(@NonNull Canvas canvas, @NonNull Triangle triangle) {
        if (!pointMapper.isSizeExist()) return;
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setStrokeWidth(2);
        paint.setColor(android.graphics.Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(pointMapper.xPointToPx(triangle.point1.x), pointMapper.yPointToPx(triangle.point1.y));
        path.lineTo(pointMapper.xPointToPx(triangle.point2.x), pointMapper.yPointToPx(triangle.point2.y));
        path.lineTo(pointMapper.xPointToPx(triangle.point3.x), pointMapper.yPointToPx(triangle.point3.y));
        path.lineTo(pointMapper.xPointToPx(triangle.point1.x), pointMapper.yPointToPx(triangle.point1.y));
        path.close();

        canvas.drawPath(path, paint);
    }

}
