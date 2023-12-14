package edu.project4.renderers;

import edu.project4.models.Color;
import edu.project4.models.FractalImage;
import edu.project4.transformations.AffineTransformation;
import edu.project4.transformations.CylinderTransformation;
import edu.project4.transformations.DiamondTransformation;
import edu.project4.transformations.DiscTransformation;
import edu.project4.models.Rect;
import edu.project4.transformations.FisheyeTransformation;
import edu.project4.transformations.HandkerchiefTransformation;
import edu.project4.transformations.HeartTransformation;
import edu.project4.transformations.HorseshoeTransformation;
import edu.project4.transformations.HyperbolicTransformation;
import edu.project4.transformations.PolarTransformation;
import edu.project4.transformations.SinTransformation;
import edu.project4.transformations.SphericalTransformation;
import edu.project4.transformations.SpiralTransformation;
import edu.project4.transformations.SwirlTransformation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RendererTest {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    public static FractalImage getFractal(Renderer renderer) {
        short a = 100;
        return renderer.render(
            WIDTH,
            HEIGHT,
            new Rect(-1, 1, -1, 1),
            List.of(new DiamondTransformation(), new SphericalTransformation(), new DiscTransformation(),
            new CylinderTransformation(),
            new FisheyeTransformation(),
            new HandkerchiefTransformation(),
            new HorseshoeTransformation(),
            new SinTransformation(),
            new PolarTransformation(),
            new SpiralTransformation(),
            new SwirlTransformation(),
            new HeartTransformation(),
            new HyperbolicTransformation()),
            List.of(
                AffineTransformation.randomTransformation(new Color(255, 215, 0)),
                AffineTransformation.randomTransformation(new Color(240, 120, 0)),
                AffineTransformation.randomTransformation()
            ),
            10000,
            a
        );
    }

    public static Stream<Renderer> argsProviderFactory() {
        return Stream.of(new MultiThreadsRenderer(10), new OneThreadRenderer());
    }

    @ParameterizedTest
    @MethodSource("argsProviderFactory")
    void render(Renderer renderer) {
        assertDoesNotThrow(() -> getFractal(renderer));
        var canvas = getFractal(renderer);
        assertEquals(WIDTH, canvas.width());
        assertEquals(HEIGHT, canvas.height());
        assertNotNull(canvas.data());
    }

}
