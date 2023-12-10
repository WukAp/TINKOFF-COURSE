package edu.project4.transformations;


import edu.project4.models.Color;

public abstract class TransformationWithColor implements Transformation {

    protected final Color color;
    public static final Color DEFAULT_COLOR = new Color(255, 255, 100);

    public TransformationWithColor(Color color) {
        this.color = color;
    }

    public TransformationWithColor() {
        this.color = DEFAULT_COLOR;
    }

    public Color getColor() {
        return color;
    }
}
