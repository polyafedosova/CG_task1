package ru.vsu.fedosova.objects;

import ru.vsu.fedosova.DrawingObject;

import java.awt.*;
import static ru.vsu.fedosova.util.DrawUtil.*;
import static ru.vsu.fedosova.util.ArrayUtil.*;

public class Mountain extends DrawingObject {
    private final double[] x;
    private final double[] y;

    public Mountain(double cofX, double cofY, double cofW, double cofH, Color color) {
        super(cofX, cofY, cofW, cofH, color);
        this.x = new double[]{
                cofX,
                cofX + cofW,
                cofX + cofW * 0.5
        };
        this.y = new double[]{
                cofY,
                cofY,
                cofY - cofH
        };
    }

    @Override
    public void draw(Graphics2D g, int panelWidth, int panelHeight) {
        drawWithColor(g, this.color, () -> {
            g.fillPolygon(toIntArray(multiplyArrayBy(x, panelWidth)),
            toIntArray(multiplyArrayBy(y, panelHeight)), 3);
        });
        assert this.color != null;
        drawWithColor(g, this.color.darker(), () -> {
            g.fillPolygon(toIntArray(multiplyArrayBy(new double[] {x[0], x[0] * 1.15, x[2]}, panelWidth)),
                    toIntArray(multiplyArrayBy(new double[] {y[0], y[1], y[2]}, panelHeight)), 3);
            g.fillPolygon(toIntArray(multiplyArrayBy(new double[] {x[0], x[0] * 1.2, x[0] + cofW * 0.42}, panelWidth)),
                    toIntArray(multiplyArrayBy(new double[] {y[0], y[1], y[2] + cofH / 3}, panelHeight)), 3);

        });
    }
}
