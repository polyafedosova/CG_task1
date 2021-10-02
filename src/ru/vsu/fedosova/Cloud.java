package ru.vsu.fedosova;

import java.awt.*;

import static ru.vsu.fedosova.ArrayUtil.multiplyArrayBy;
import static ru.vsu.fedosova.ArrayUtil.toIntArray;
import static ru.vsu.fedosova.DrawUtil.drawWithColor;
import static ru.vsu.fedosova.RandomUtil.*;

public class Cloud extends DrawingObject {
    private final double[] x;
    private final double[] y;

    public Cloud(double cofX, double cofY, double cofW, double cofH, Color color) {
        super(cofX, cofY, cofW, cofH, color);
        this.x = new double[]{
                cofX,
                cofX + cofW,
                randDouble(cofX + cofW / 2, cofX + cofW),
                randDouble(cofX + cofW / 8, cofX + cofW / 2)
        };
        this.y = new double[]{
                cofY,
                cofY,
                cofY - cofH,
                cofY - cofH / 2
        };
    }

    @Override
    public void draw(Graphics2D g, int panelWidth, int panelHeight) {
        drawWithColor(g, this.color, () -> {
            g.fillPolygon(toIntArray(multiplyArrayBy(x, panelWidth)),
                    toIntArray(multiplyArrayBy(y, panelHeight)), 4);
        });
    }
}
