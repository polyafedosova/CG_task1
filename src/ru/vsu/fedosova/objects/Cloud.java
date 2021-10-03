package ru.vsu.fedosova.objects;

import ru.vsu.fedosova.DrawingObject;

import java.awt.*;

import static ru.vsu.fedosova.util.ArrayUtil.multiplyArrayBy;
import static ru.vsu.fedosova.util.ArrayUtil.toIntArray;
import static ru.vsu.fedosova.util.DrawUtil.drawWithColor;
import static ru.vsu.fedosova.util.RandomUtil.*;

public class Cloud extends DrawingObject {
    private final double[] x;
    private final double[] y;

    public Cloud(double cofX, double cofY, double cofW, double cofH, Color color) {
        super(cofX, cofY, cofW, cofH, color);
        this.x = new double[]{
                cofX,
                cofX + cofW,
                randDouble(cofX + cofW * 0.6, cofX + cofW * 0.9),
                randDouble(cofX + cofW * 0.3, cofX + cofW * 0.6)
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
