package edu.project2.models;

public enum Direction {
    LEFT(new int[] {0, -1}), RIGHT(new int[] {0, 1}), BOTTOM(new int[] {-1, 0}), TOP(new int[] {1, 0});
    private final int[] step;

    Direction(int[] step) {
        this.step = step;
    }

    public int[] getStep() {
        return step;
    }

    public Direction getReverse() {
        return switch (this) {
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
            case BOTTOM -> TOP;
            case TOP -> BOTTOM;
        };
    }
}
