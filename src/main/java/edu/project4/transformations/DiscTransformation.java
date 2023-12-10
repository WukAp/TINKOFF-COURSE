package edu.project4.transformations;

import edu.project4.models.Point;

public class DiscTransformation extends TransformationWithColor{
    @Override
    public Point apply(Point point) {
        double radius = radius(point);
        double theta = theta(point);

        double x = theta * Math.sin(Math.PI * radius) / Math.PI;
        double y = theta * Math.cos(Math.PI * radius) / Math.PI;

        return new Point(x, y);
    }
}
