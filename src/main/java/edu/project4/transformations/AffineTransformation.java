package edu.project4.transformations;

import edu.project4.models.Color;
import edu.project4.models.Point;
import java.util.concurrent.ThreadLocalRandom;

public class AffineTransformation extends TransformationWithColor {
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;

    @Override public Point apply(Point point) {
        double x = a * point.x() + b * point.y() + c;
        double y = d * point.x() + e * point.y() + f;

        return new Point(x, y);
    }

    public AffineTransformation(
        double a, double b, double c, double d, double e, double f
    ) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public AffineTransformation(
        double a, double b, double c, double d, double e, double f, Color color
    ) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public static AffineTransformation randomTransformation() {
        return randomTransformation(DEFAULT_COLOR);
    }

    public static AffineTransformation randomTransformation(Color color) {

        final double BORDER = 0.3;
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        double a;
        double b;
        double c;
        double d;
        double e;
        double f;

        do {
            do {
                a = rand.nextDouble(-1, 1);
                d = rand.nextDouble(-1, 1);

            } while ((a * a + d * d) > 1);
            do {
                b = rand.nextDouble(-1, 1);
                e = rand.nextDouble(-1, 1);

            } while ((b * b + e * e) > 1);
        } while ((a * a + b * b + d * d + e * e) > (1 + (a * e - d * b) * (a * e - d * b)));

        c = rand.nextDouble(-BORDER, BORDER);
        f = rand.nextDouble(-BORDER, BORDER);

        return new AffineTransformation(a, b, c, d, e, f, color);
    }

}
