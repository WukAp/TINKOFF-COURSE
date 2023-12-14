package edu.project4.downloading;

import edu.project4.models.Color;
import edu.project4.models.FractalImage;
import edu.project4.models.Pixel;
import edu.project4.models.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import javax.imageio.ImageIO;

public final class ImageUtils {

    private final static int RED = 16;
    private final static int GREEN = 8;
    private static final Color BACKGROUND_COLOR = new Color(0, 0, 0);

    private ImageUtils() {
    }

    public static void save(FractalImage fractalImage, Path path, ImageFormat format) throws IOException {
        BufferedImage image =
            new BufferedImage(fractalImage.width(), fractalImage.height(), BufferedImage.TYPE_INT_RGB);

        setPixels(image, fractalImage.data());

        try {
            File outputfile = getPathName(path, format.name().toLowerCase()).toFile();
            Files.createDirectories(path.getParent());
            ImageIO.write(image, format.name().toLowerCase(), outputfile);

        } catch (IOException e) {
            throw new IOException("Can't download image file");
        }
    }

    private static void setPixels(BufferedImage image, Map<Point, Pixel> pixelMap) {
        Pixel defaultPixel = new Pixel(BACKGROUND_COLOR, 0);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Pixel pixel = pixelMap.getOrDefault(new Point(x, y), defaultPixel);
                int rgb = (pixel.color().r() << RED) | (pixel.color().g() << GREEN) | pixel.color().b();
                image.setRGB(x, y, rgb);
            }
        }
    }

    private static Path getPathName(Path path, String fileExtension) {
        return path.resolveSibling(path.getFileName().toString().split("\\.")[0] + "." + fileExtension);
    }

}
