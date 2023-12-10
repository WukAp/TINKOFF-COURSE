package edu.project4.renderers;

import edu.project4.models.FractalImage;
import edu.project4.models.Rect;
import edu.project4.transformations.Transformation;
import java.util.List;

// может быть несколько имплементаций интерфейса: однопоточный, многопоточный и т.п.
@FunctionalInterface
public interface Renderer {
    FractalImage render(
        int width,
        int height,
        Rect world,
        List<Transformation> variations,
        int samples,
        short iterPerSample,
        int symmetry
    );

    default FractalImage render(
        int width,
        int height,
        Rect world,
        List<Transformation> variations,
        int samples,
        short iterPerSample
    ) {
        return render(width, height, world, variations, samples, iterPerSample, 1);
    }
}
