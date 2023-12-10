package edu.project4.models;

public record Rect(double minX, double maxX, double minY, double maxY) {
    public boolean contains(Point p) {
        return p.x() > minX && p.x() < maxX && p.y() > minY && p.y() < maxY;
    }
}
