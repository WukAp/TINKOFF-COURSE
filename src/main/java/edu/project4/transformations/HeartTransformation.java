package edu.project4.transformations;

import edu.project4.models.Point;

public class HeartTransformation extends TransformationWithColor {
    @Override
    public Point apply(Point point) {
        double radius = radius(point);
        double theta = theta(point);

        double x = radius * Math.sin(radius * theta);
        double y = radius * -Math.cos(radius * theta);

        return new Point(x, y);
    }
}
