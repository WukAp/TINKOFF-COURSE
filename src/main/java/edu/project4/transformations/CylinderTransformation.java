package edu.project4.transformations;

import edu.project4.models.Point;

public class CylinderTransformation extends TransformationWithColor {
    @Override
    public Point apply(Point point) {
        double x = Math.sin(point.x());
        double y = point.y();

        return new Point(x, y);
    }
}
