package ru.vsu.fedosova;

import java.awt.*;

public class Foreground extends DrawingObject {
    private final double[] x = new double[13];
    private final double[] y = new double[13];

    public Foreground(double cofX, double cofY, double cofW, double cofH, Color color) {
        super(cofX, cofY, cofW, cofH, color);
    }

    @Override
    public void draw(Graphics2D g, int panelWidth, int panelHeight) {

    }

    public double getY(double x, int panelWidth, int panelHeight){
        return - 1 * (x - panelWidth * 0.5) / panelHeight + 0.9 * panelHeight;
    }
}
