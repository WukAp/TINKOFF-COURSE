package edu.project4.postProcessing;

import edu.project4.models.FractalImage;

@FunctionalInterface
public
interface ImageProcessor {
    FractalImage process(FractalImage image);
}
