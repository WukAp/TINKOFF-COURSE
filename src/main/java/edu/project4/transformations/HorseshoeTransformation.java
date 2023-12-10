package edu.project4.transformations;

import edu.project4.models.Point;

public class HorseshoeTransformation extends TransformationWithColor {
    @Override
    public Point apply(Point point) {
        double radius = radius(point);

        double x = (point.x() - point.y()) * (point.x() + point.y()) / radius;
        double y = 2 * point.x() * point.y() / radius;

        return new Point(x, y);
    }
}
