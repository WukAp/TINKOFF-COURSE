package edu.project4.renderers;

import edu.project4.models.FractalImage;
import edu.project4.models.Point;
import edu.project4.models.Rect;
import edu.project4.transformations.Transformation;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RendererUtils {
    private static final ThreadLocalRandom THREAD_LOCAL_RANDOM = ThreadLocalRandom.current();

    private RendererUtils() {
    }

    public static Point random(Rect world) {
        return new Point(
            THREAD_LOCAL_RANDOM.nextDouble(0, world.maxX()),
            THREAD_LOCAL_RANDOM.nextDouble(0, world.maxY())
        );
    }

    public static Transformation random(List<Transformation> variations) {
        return variations.get(
            THREAD_LOCAL_RANDOM.nextInt(variations.size())
        );
    }

    public static Point rotate(Point pw, double theta2) {
        return new Point(
            pw.x() * Math.cos(theta2) - pw.y() * Math.sin(theta2),

            pw.x() * Math.sin(theta2) + pw.y() * Math.cos(theta2)
        );
    }

    public static Point mapRange(Rect world, Point pwr, FractalImage canvas) {
        int x = canvas.width() - (int) Math.ceil(
            (world.maxX() - pwr.x()) / (world.maxX() - world.minX()) * canvas.width());
        int y = canvas.height() - (int) Math.ceil(
            (world.maxY() - pwr.y()) / (world.maxY() - world.minY()) * canvas.height());
        return new Point(x, y);
    }
}

