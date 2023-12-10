package edu.project4.renderers;

import edu.project4.models.Color;
import edu.project4.models.FractalImage;
import edu.project4.models.Point;
import edu.project4.models.Rect;
import edu.project4.transformations.Transformation;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class OneThreadRenderer implements Renderer {
    private final ThreadLocalRandom THREAD_LOCAL_RANDOM = ThreadLocalRandom.current();
    private final static int EMPTY_STEPS = 20;
    private final static Color DEFAULT_COLOR = new Color(200, 50, 200);

    @Override
    public FractalImage render(
        int width,
        int height,
        Rect world,
        List<Transformation> variations,
        int samples,
        short iterationsPerSample,
        int symmetry
    ) {
        FractalImage canvas = FractalImage.create(width, height);

        for (int num = 0; num < samples; ++num) {
            Point pointInWorld = random(world);

            for (short step = -EMPTY_STEPS; step < iterationsPerSample; ++step) {
                Transformation variation = random(variations);

                pointInWorld = variation.apply(pointInWorld);
                if (step >= 0 && world.contains(pointInWorld)) {
                    double theta2 = 0.0;
                    for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, ++s) {
                        var rotatedPoint = rotate(pointInWorld, theta2);
                        if (!world.contains(rotatedPoint)) {
                            continue;
                        }

                        Point point = mapRange(world, rotatedPoint, canvas);
                        if (point == null) {
                            continue;
                        }
                        canvas.add(point, DEFAULT_COLOR);
                        // 1. делаем лок на время работы с пикселем
                        // 2. подмешиваем цвет и увеличиваем hit count
                    }
                }

            }
        }
        return canvas;
    }

    public Point random(Rect world) {
        return new Point(
            THREAD_LOCAL_RANDOM.nextDouble(0, world.maxX()),
            THREAD_LOCAL_RANDOM.nextDouble(0, world.maxY())
        );
    }

    public Transformation random(List<Transformation> variations) {
        return variations.get(
            THREAD_LOCAL_RANDOM.nextInt(variations.size())
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
