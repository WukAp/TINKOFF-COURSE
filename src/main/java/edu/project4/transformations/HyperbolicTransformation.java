package edu.project4.transformations;

import edu.project4.models.Point;

public class HyperbolicTransformation extends TransformationWithColor {
    @Override
    public Point apply(Point point) {
        double radius = radius(point);
        double theta = theta(point);

        double x = Math.sin(theta) / radius;
        double y = radius * Math.cos(theta);

        return new Point(x, y);
    }
}
