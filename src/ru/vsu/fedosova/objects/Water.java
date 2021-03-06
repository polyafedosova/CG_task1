package ru.vsu.fedosova.objects;

import ru.vsu.fedosova.DrawingObject;

import java.awt.*;

import static ru.vsu.fedosova.util.DrawUtil.*;

public class Water extends DrawingObject {
    public Water(double cofX, double cofY, double cofW, double cofH, Color color) {
        super(cofX, cofY, cofW, cofH, color);
    }

    @Override
    public void draw(Graphics2D g, int panelWidth, int panelHeight) {
        drawWithColor(g, color, () -> {
            g.fillRect(
                    (int) (cofX * panelWidth),
                    (int) (cofY * panelHeight),
                    (int) (cofW * panelWidth),
                    (int) (cofH * panelHeight)
            );
        });
    }
}
