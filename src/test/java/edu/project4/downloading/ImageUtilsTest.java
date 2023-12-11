package edu.project4.downloading;

import edu.project4.models.Color;
import edu.project4.postProcessing.GammaCorrection;
import edu.project4.renderers.MultiThreadsRenderer;
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

import java.nio.file.Path;
import java.util.List;

class ImageUtilsTest {

    @Test void save1() {
        Renderer renderer = new OneThreadRenderer();
        short a = 100;
        var canvas = renderer.render(

            1000, 1000, new Rect(-1, 1, -1, 1), List.of(

                new DiamondTransformation(), new SphericalTransformation(), new DiscTransformation()),
            List.of(AffineTransformation.randomTransformation(new Color(12, 100, 3)),
                AffineTransformation.randomTransformation(new Color(12, 10, 3)),
                AffineTransformation.randomTransformation(new Color(120, 100, 3))), 10000, a

        );
        ImageUtils.save(canvas, Path.of("src/main/resources/project4/pic1"), ImageFormat.PNG);
    }

    @Test void save2() {
        Renderer renderer = new OneThreadRenderer();
        short a = 100;
        var canvas = renderer.render(

            1000, 1000, new Rect(-1, 1, -1, 1), List.of(

                new HyperbolicTransformation(),
                new FisheyeTransformation(),
                new DiscTransformation(),
                new CylinderTransformation(),
                new HeartTransformation()
            ), List.of(AffineTransformation.randomTransformation(new Color(12, 100, 3)),
                AffineTransformation.randomTransformation(new Color(12, 10, 300)),
                AffineTransformation.randomTransformation(new Color(120, 100, 3))),10000, a

        );
        ImageUtils.save(canvas, Path.of("src/main/resources/project4/pic2"), ImageFormat.PNG);
    }

    @Test void save3() {
        Renderer renderer = new OneThreadRenderer();
        short a = 100;
        var canvas = renderer.render(

            1000, 1000, new Rect(-1, 1, -1, 1), List.of(

                new SpiralTransformation(),
                new PolarTransformation(),
                new DiamondTransformation()
            ),
            List.of(AffineTransformation.randomTransformation(new Color(12, 100, 3)),
                AffineTransformation.randomTransformation(new Color(12, 10, 3)),
                    AffineTransformation.randomTransformation(new Color(120, 100, 3))), 40000, a
        );
        ImageUtils.save(canvas, Path.of("src/main/resources/project4/pic3"), ImageFormat.PNG);
    }

    @Test void save3MultiThread() {
        Renderer renderer = new MultiThreadsRenderer(15);
        short a = 100;
        var canvas = renderer.render(

            1000, 1000, new Rect(-1, 1, -1, 1), List.of(

                new SpiralTransformation(),
                new PolarTransformation(),
                new DiamondTransformation()
            ),List.of(AffineTransformation.randomTransformation(new Color(12, 100, 3)),
                AffineTransformation.randomTransformation(new Color(12, 10, 3)),
                AffineTransformation.randomTransformation(new Color(120, 100, 3))), 40000, a
        );
        ImageUtils.save(canvas, Path.of("src/main/resources/project4/pic3multi"), ImageFormat.PNG);
    }
    @Test void save4() {
        Renderer renderer = new OneThreadRenderer();
        short a = 100;
        var canvas = renderer.render(

            1000, 1000, new Rect(-1, 1, -1, 1), List.of(

                new HandkerchiefTransformation(),
                new SwirlTransformation(),
                new HorseshoeTransformation()
            ), List.of(AffineTransformation.randomTransformation(new Color(12, 100, 3)),
                AffineTransformation.randomTransformation(new Color(12, 10, 3)),
                AffineTransformation.randomTransformation(new Color(120, 100, 3))),40000, a
        );
        ImageUtils.save(canvas, Path.of("src/main/resources/project4/pic4"), ImageFormat.PNG);
    }
    @Test void save5Correction() {
        Renderer renderer = new MultiThreadsRenderer(10);
        short a = 100;
        var canvas = renderer.render(

            1000, 1000, new Rect(-1, 1, -1, 1), List.of(


                new HeartTransformation(),
                new DiamondTransformation(),
                new DiscTransformation()
            ), List.of(
                AffineTransformation.randomTransformation(new Color(255, 215, 0)),
                AffineTransformation.randomTransformation(new Color(240, 120, 0)),
                AffineTransformation.randomTransformation(new Color(255, 255, 180))),
            50000, a, 6
        );
        GammaCorrection gammaCorrection = new GammaCorrection(2.5);
        ImageUtils.save(gammaCorrection.process(canvas), Path.of("src/main/resources/project4/pic5"), ImageFormat.PNG);
    }

}
