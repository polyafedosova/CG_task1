package ru.vsu.fedosova.objects;

import ru.vsu.fedosova.DrawingObject;

import java.awt.*;

import static ru.vsu.fedosova.util.ArrayUtil.*;
import static ru.vsu.fedosova.util.DrawUtil.*;

public class Glacier extends DrawingObject {
    private final double[] x = new double[13];
    private final double[] y = new double[13];

    public Glacier(double cofX, double cofY, double cofW, double cofH, Color color, double[] dif) {
        super(cofX, cofY, cofW, cofH, color);
        fillArrX();
        fillArrY(dif);
    }

    @Override
    public void draw(Graphics2D g, int panelWidth, int panelHeight) {
        drawWithColor(g, this.color, () -> {
            g.fillPolygon(toIntArray(multiplyArrayBy(x, panelWidth)),
                    toIntArray(multiplyArrayBy(y, panelHeight)), 13);
        });
    }

    private void fillArrX(){
        this.x[0] = cofX;
        for (int i = 1; i < 12; i++) {
            this.x[i] = this.x[i - 1] + 0.06;
        }
        this.x[12] = cofX + cofW;
    }

    private void fillArrY(double[] dif){
        this.y[0] = cofY;
        for (int i = 1; i < 12; i++) {
            this.y[i] = cofY - dif[i - 1];
        }
        this.y[12] = this.y[0];
    }
}
