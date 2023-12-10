package edu.project4.transformations;

import edu.project4.models.Point;

public class SphericalTransformation extends TransformationWithColor{
    @Override
    public Point apply(Point point) {
        double radiusSquared = radiusSquared(point);

        double x = point.x() / radiusSquared;
        double y = point.y() / radiusSquared;

        return new Point(x, y);
    }
}
