package edu.project4.transformations;

import edu.project4.models.Point;

public class SinTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = Math.sin(point.x());
        double y = Math.sin(point.y());
        return new Point(Math.sin(point.x()), Math.sin(point.y()));
    }
}
