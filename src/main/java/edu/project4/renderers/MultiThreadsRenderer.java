package edu.project4.renderers;

import edu.project4.models.Color;
import edu.project4.models.FractalImage;
import edu.project4.models.Pixel;
import edu.project4.models.Point;
import edu.project4.models.Rect;
import edu.project4.transformations.AffineTransformation;
import edu.project4.transformations.Transformation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class MultiThreadsRenderer implements Renderer {
    private final int threadAmount;

    public MultiThreadsRenderer(int threadAmount) {
        this.threadAmount = threadAmount;
    }

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
        List<Callable<FractalImage>> tasks = new ArrayList<>();

        for (int i = 0; i < threadAmount; i++) {
            tasks.add(() -> new OneThreadRenderer().render(
                width, height,
                world,
                variations, affineTransformations,
                samples / threadAmount,
                iterationsPerSample, symmetry
            ));
        }

        try (ExecutorService executorService = Executors.newFixedThreadPool(threadAmount)) {
            List<Future<FractalImage>> futures = executorService.invokeAll(tasks);

            List<FractalImage> created = new ArrayList<>();
            for (var future : futures) {
                created.add(future.get());
            }
            return new FractalImage(mergeFractalImage(created), width, height);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<Point, Pixel> mergeFractalImage(List<FractalImage> forMerge) {
        return forMerge.stream()
            .map(FractalImage::data)
            .flatMap(pixelMap -> pixelMap.entrySet().stream())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (pixel1, pixel2) -> new Pixel(
                    new Color(
                        (pixel1.color().r() + pixel1.color().r()) / 2,
                        (pixel1.color().g() + pixel1.color().g()) / 2,
                        (pixel1.color().b() + pixel1.color().b()) / 2
                    ),
                    pixel1.hitCount() + pixel2.hitCount()
                )
            ));
    }

}
