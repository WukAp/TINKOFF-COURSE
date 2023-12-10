package edu.project4.renderers;

import edu.project4.transformations.SinTransformation;
import edu.project4.models.Rect;
import org.junit.jupiter.api.Test;

import java.util.List;

class OneThreadRendererTest {

    @Test
    void render() {
        Renderer renderer = new OneThreadRenderer();
        short a = 100;
        var canvas = renderer.render(
            100, 100
            , new Rect(-1.777, 10, -10, 1)
            , List.of(new SinTransformation())
            , 100000
            , a

        );
        System.out.println(canvas);
    }
}
