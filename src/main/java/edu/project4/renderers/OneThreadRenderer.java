package edu.project4.renderers;

import edu.project4.models.FractalImage;
import edu.project4.models.Point;
import edu.project4.models.Rect;
import edu.project4.transformations.AffineTransformation;
import edu.project4.transformations.Transformation;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class OneThreadRenderer implements Renderer {
    private final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
    private final static int EMPTY_STEPS = 20;

    @SuppressWarnings("ParameterNumber")
    @Override
    public FractalImage render(
        int width,
        int height,
        Rect world,
        List<Transformation> variations,
        List<AffineTransformation> affineTransformations,
        int samples,
        short iterationsPerSample,
        int symmetry
    ) {
        FractalImage canvas = FractalImage.create(width, height);

        for (int num = 0; num < samples; ++num) {
            Point pointInWorld = random(world);

            for (short step = -EMPTY_STEPS; step < iterationsPerSample; ++step) {

                Transformation variation = variations.get(
                    threadLocalRandom.nextInt(variations.size())
                );

                AffineTransformation affineTransformation = affineTransformations.get(
                    threadLocalRandom.nextInt(affineTransformations.size())
                );

                pointInWorld = affineTransformation.apply(variation.apply(pointInWorld));
                if (step >= 0 && world.contains(pointInWorld)) {
                    double theta2 = 0.0;
                    for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, s++) {
                        var rotatedPoint = rotate(pointInWorld, theta2);

                        Point point = mapRange(world, rotatedPoint, canvas);
                        canvas.add(point, affineTransformation.getColor());
                    }
                }

            }
        }
        return canvas;
    }

    public Point random(Rect world) {
        return new Point(
            threadLocalRandom.nextDouble(0, world.maxX()),
            threadLocalRandom.nextDouble(0, world.maxY())
        );
    }

    public Point rotate(Point pw, double theta2) {
        return new Point(
            pw.x() * Math.cos(theta2) - pw.y() * Math.sin(theta2),
            pw.x() * Math.sin(theta2) + pw.y() * Math.cos(theta2)
        );
    }

    public Point mapRange(Rect world, Point pwr, FractalImage canvas) {
        int x = canvas.width() - (int) Math.ceil(
            (world.maxX() - pwr.x()) / (world.maxX() - world.minX()) * canvas.width());
        int y = canvas.height() - (int) Math.ceil(
            (world.maxY() - pwr.y()) / (world.maxY() - world.minY()) * canvas.height());
        return new Point(x, y);
    }
}
