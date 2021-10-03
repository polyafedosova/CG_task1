package ru.vsu.fedosova.objects;

import ru.vsu.fedosova.DrawingObject;

import java.awt.*;
import static ru.vsu.fedosova.util.RandomUtil.*;

import static ru.vsu.fedosova.util.ArrayUtil.multiplyArrayBy;
import static ru.vsu.fedosova.util.ArrayUtil.toIntArray;
import static ru.vsu.fedosova.util.DrawUtil.drawWithColor;

public class Foreground extends DrawingObject {
    private final double[] x = new double[25];
    private final double[] y = new double[25];

    public Foreground(double cofX, double cofY, double cofW, double cofH, Color color, boolean type) {
        super(cofX, cofY, cofW, cofH, color);
        fillArrX();
        fillArrY(type);
    }

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }

    @Override
    public void draw(Graphics2D g, int panelWidth, int panelHeight) {
        drawWithColor(g, this.color, () -> {
            g.fillPolygon(toIntArray(multiplyArrayBy(x, panelWidth)),
                    toIntArray(multiplyArrayBy(y, panelHeight)), 25);
        });
    }

    private void fillArrX(){
        double dif = cofW / 20;
        x[0] = cofX;
        x[1] = cofX;
        for (int i = 2; i < 23; i++) {
            x[i] = x[i - 1] + dif;
        }
        x[23] = cofX + cofW;
        x[24] = cofX + cofW;
    }

    private void fillArrY(boolean type){
        y[0] = cofY;
        y[1] = cofY - cofH;
        if (type) {
            for (int i = 1; i < 22; i++) {
                y[i] = randDouble(getY(x[i - 1]), getY(x[i]));
            }
        } else {
            for (int i = 2; i < 22; i++) {
                if(i % 2 == 0) {
                    y[i] = getY(x[i]) + (getY(x[i]) - getY(x[i - 1])) / 3;
                } else y[i] = getY(x[i]) - (getY(x[i]) - getY(x[i - 1])) / 2;
            }
        }
        y[22] = y[1];
        y[23] = y[1];
        y[24] = y[0];
    }

    private double getY(double x) {
        return - 1 * Math.pow((x - cofW * 0.5), 2) + (cofY - 0.15 * cofH);
    }
}
