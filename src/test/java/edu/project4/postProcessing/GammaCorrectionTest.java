package edu.project4.postProcessing;

import edu.project4.models.FractalImage;
import edu.project4.renderers.MultiThreadsRenderer;
import edu.project4.renderers.Renderer;
import edu.project4.renderers.RendererTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GammaCorrectionTest {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    @Test
    void process() {
        ImageProcessor processor = new GammaCorrection();
        var canvas = getFractal();
        assertDoesNotThrow(() -> processor.process(getFractal()));
        var processedCanvas = processor.process(canvas);
        assertEquals(WIDTH, processedCanvas.width());
        assertEquals(HEIGHT, processedCanvas.height());
        assertNotNull(processedCanvas.data());

        assertNotEquals(canvas.data(), processedCanvas.data());

        var processedCanvas2 = processor.process(canvas);
        for (var entry : processedCanvas.data().entrySet()) {
            assertTrue(processedCanvas2.data().containsKey(entry.getKey()));
            assertEquals(entry.getValue(), processedCanvas2.data().get(entry.getKey()));
        }
    }

    @Test
    void processMyGamma() {
        ImageProcessor processor = new GammaCorrection(1.5);
        var canvas = getFractal();
        assertDoesNotThrow(() -> processor.process(getFractal()));
        var processedCanvas = processor.process(canvas);
        assertEquals(WIDTH, processedCanvas.width());
        assertEquals(HEIGHT, processedCanvas.height());
        assertNotNull(processedCanvas.data());

        assertNotEquals(canvas.data(), processedCanvas.data());

        var processedCanvas2 = processor.process(canvas);
        for (var entry : processedCanvas.data().entrySet()) {
            assertTrue(processedCanvas2.data().containsKey(entry.getKey()));
            assertEquals(entry.getValue(), processedCanvas2.data().get(entry.getKey()));
        }
    }

    private FractalImage getFractal() {
        Renderer renderer = new MultiThreadsRenderer(10);
        return RendererTest.getFractal(renderer);
    }
}
