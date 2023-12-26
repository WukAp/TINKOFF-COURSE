package edu.project4.downloading;

import edu.project4.models.FractalImage;
import edu.project4.renderers.MultiThreadsRenderer;
import edu.project4.renderers.RendererTest;
import edu.project4.renderers.Renderer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.File;
import java.nio.file.Path;
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
