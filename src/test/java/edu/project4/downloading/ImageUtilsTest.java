package edu.project4.downloading;

import edu.project4.models.Color;
import edu.project4.models.FractalImage;
import edu.project4.postProcessing.GammaCorrection;
import edu.project4.renderers.MultiThreadsRenderer;
import edu.project4.renderers.RendererTest;
import edu.project4.transformations.AffineTransformation;
import edu.project4.transformations.CylinderTransformation;
import edu.project4.transformations.DiamondTransformation;
import edu.project4.transformations.DiscTransformation;
import edu.project4.transformations.FisheyeTransformation;
import edu.project4.transformations.HandkerchiefTransformation;
import edu.project4.transformations.HeartTransformation;
import edu.project4.transformations.HorseshoeTransformation;
import edu.project4.transformations.HyperbolicTransformation;
import edu.project4.transformations.PolarTransformation;
import edu.project4.transformations.SphericalTransformation;
import edu.project4.transformations.SpiralTransformation;
import edu.project4.models.Rect;
import edu.project4.renderers.OneThreadRenderer;
import edu.project4.renderers.Renderer;
import edu.project4.transformations.SwirlTransformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImageUtilsTest {

    @ParameterizedTest
    @EnumSource(ImageFormat.class)
    void save(ImageFormat format) {
        var canvas = getFractal();
        assertDoesNotThrow(() -> ImageUtils.save(canvas, Path.of("src/main/resources/project4/save"), format));
        assertTrue(new File("src/main/resources/project4/save." + format.name().toLowerCase()).exists());
    }

    private FractalImage getFractal() {
        Renderer renderer = new MultiThreadsRenderer(10);
        return RendererTest.getFractal(renderer);
    }

}
