package ru.vsu.fedosova.objects;

import ru.vsu.fedosova.DrawingObject;

import java.awt.*;

import static ru.vsu.fedosova.util.DrawUtil.*;

public class Sky extends DrawingObject {
    public Sky(double cofX, double cofY, double cofW, double cofH) {
        super(cofX, cofY, cofW, cofH);
    }

    @Override
    public void draw(Graphics2D g, int panelWidth, int panelHeight) {
        GradientPaint gradient = new GradientPaint(
                (int) (0.5 * panelWidth), (int) (cofY * panelHeight), new Color(88, 19, 59, 191),
                (int) (cofW * panelWidth), (int) (cofH * panelHeight), new Color(234, 149, 124, 136));
        drawWithGradient(g, gradient, () -> {
            g.fillRect(
                    (int) (cofX * panelWidth),
                    (int) (cofY * panelHeight),
                    (int) (cofW * panelWidth),
                    (int) (cofH * panelHeight)
            );
        });
    }
}
