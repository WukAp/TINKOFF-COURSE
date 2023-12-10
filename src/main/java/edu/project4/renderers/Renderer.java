package edu.project4.renderers;

import edu.project4.models.FractalImage;
import edu.project4.models.Rect;
import edu.project4.transformations.AffineTransformation;
import edu.project4.transformations.Transformation;
import java.util.List;

// может быть несколько имплементаций интерфейса: однопоточный, многопоточный и т.п.
@FunctionalInterface
@SuppressWarnings("ParameterNumber")
public interface Renderer {
    FractalImage render(
        int width,
        int height,
        Rect world,
        List<Transformation> variations,
        List<AffineTransformation> affineTransformations,
        int samples,
        short iterationsPerSample,
        int symmetry
    );

    default FractalImage render(
        int width,
        int height,
        Rect world,
        List<Transformation> variations,
        List<AffineTransformation> affineTransformations,
        int samples,
        short iterationsPerSample
    ) {
        return render(width, height, world, variations, affineTransformations, samples, iterationsPerSample, 1);
    }
}
