package edu.project4.renderers;

import edu.project4.models.Color;
import edu.project4.models.FractalImage;
import edu.project4.models.Point;
import edu.project4.models.Rect;
import edu.project4.transformations.Transformation;
import java.util.List;

public class OneThreadRenderer implements Renderer {
    private final static int EMPTY_STEPS = 40;
    private final static Color DEFAULT_COLOR = new Color(255, 255, 255);

    @Override
    public FractalImage render(
        int width,
        int height,
        Rect world,
        List<Transformation> variations,
        int samples,
        short iterPerSample,
        int symmetry
    ) {
        FractalImage canvas = FractalImage.create(width, height);

        for (int num = 0; num < samples; ++num) {
            Point pointInWorld = RendererUtils.random(world);

            for (short step = -EMPTY_STEPS; step < iterPerSample; ++step) {
                Transformation variation = RendererUtils.random(variations);

                pointInWorld = variation.apply(pointInWorld);
                if (step >= 0 && world.contains(pointInWorld)) {
                    double theta2 = 0.0;
                    for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, ++s) {
                        var rotatedPoint = RendererUtils.rotate(pointInWorld, theta2);
                        if (!world.contains(rotatedPoint)) {
                            continue;
                        }

                        Point point = RendererUtils.mapRange(world, rotatedPoint, canvas);
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
}
