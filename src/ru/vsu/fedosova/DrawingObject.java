package ru.vsu.fedosova;

import java.awt.*;

public abstract class DrawingObject {
    protected final double cofX;
    protected final double cofY;
    protected final double cofW;
    protected final double cofH;
    protected final Color color;

    public DrawingObject(double cofX, double cofY, double cofW, double cofH, Color color) {
        this.cofX = cofX;
        this.cofY = cofY;
        this.cofW = cofW;
        this.cofH = cofH;
        this.color = color;
    }

    public DrawingObject(double cofX, double cofY, double cofW, double cofH) {
        this.cofX = cofX;
        this.cofY = cofY;
        this.cofW = cofW;
        this.cofH = cofH;
        color = null;
    }

    public DrawingObject(double cofX, double cofY, double cofH) {
        this.cofX = cofX;
        this.cofY = cofY;
        this.cofH = cofH;
        color = null;
        cofW = 0;
    }

    public abstract void draw(Graphics2D g, int panelWidth, int panelHeight);
}
