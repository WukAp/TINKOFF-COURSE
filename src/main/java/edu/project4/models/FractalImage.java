package edu.project4.models;

import java.util.HashMap;
import java.util.Map;

public record FractalImage(Map<Point, Pixel> data, int width, int height) {

    public static FractalImage create(int width, int height) {
        return new FractalImage(new HashMap<>(), width, height);
    }

    public boolean contains(Point point) {
        return data.containsKey(point);
    }

    public boolean isCoordinateInGrid(Point point) {
        return point.x() >= 0 && point.x() <= width && point.y() >= 0 && point.y() <= height;
    }

    public Pixel pixel(Point point) {
        return data.get(point);
    }

    public boolean add(Point point, Color color) {
        if (isCoordinateInGrid(point)) {
            if (contains(point)) {
                data.put(point, pixel(point).getPixelWithIncrementedHitCount());

                return true;
            }
            data.put(point, new Pixel(color, 1));
            return true;
        }
        return false;
    }
}
