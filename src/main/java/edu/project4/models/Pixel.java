package edu.project4.models;

public record Pixel(Color color, int hitCount) {
    public Pixel getPixelWithIncrementedHitCount() {
        return new Pixel(color, hitCount + 1);
    }
}
