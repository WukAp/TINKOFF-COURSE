package edu.project4.transformations;

import edu.project4.models.Point;

public class FisheyeTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double radius = radius(point);

        double x = 2 * point.y() / (radius + 1);
        double y = 2 * point.x() / (radius + 1);

        return new Point(x, y);
    }
}
