package edu.project4.postProcessing;

import edu.project4.models.Color;
import edu.project4.models.FractalImage;
import edu.project4.models.Pixel;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import static java.lang.Math.log10;

public class GammaCorrection implements ImageProcessor {
    private final double gamma;
    public static final double DEFAULT_GAMMA = 2.2;

    public GammaCorrection(double gamma) {
        this.gamma = gamma;
    }

    public GammaCorrection() {
        this.gamma = DEFAULT_GAMMA;
    }

    @Override
    public FractalImage process(FractalImage image) {

        double max = image.data().values().stream().mapToDouble(this::getNormal).max().orElseThrow();

        var data = image.data().entrySet().stream()
            .map((entry) -> new AbstractMap.SimpleEntry<>(entry.getKey(), getCorrectedPixel(entry.getValue(), max)))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new FractalImage(data, image.width(), image.height());
    }

    private Pixel getCorrectedPixel(Pixel pixel, double max) {
        return new Pixel(new Color(
            (int) (pixel.color().r() * Math.pow(log10(pixel.hitCount()) / max, 1.0 / gamma)),
            (int) (pixel.color().g() * Math.pow(log10(pixel.hitCount()) / max, 1.0 / gamma)),
            (int) (pixel.color().b() * Math.pow(log10(pixel.hitCount()) / max, 1.0 / gamma))
        ), pixel.hitCount());
    }

    private double getNormal(Pixel pixel) {
        return log10(pixel.hitCount());
    }
}
