package ru.vsu.fedosova;

import java.awt.*;
import java.util.ArrayList;

public abstract class CompositionObject extends DrawingObject {
    private ArrayList<DrawingObject> objects = new ArrayList<>();

    public CompositionObject(double cofX, double cofY, double cofW, double cofH, Color color) {
        super(cofX, cofY, cofW, cofH, color);
    }

    public ArrayList<DrawingObject> getObjects() {
        return objects;
    }

    @Override
    public void draw(Graphics2D g, int panelWidth, int panelHeight) {
        if (objects != null) {
            this.objects.forEach(drawingObject -> drawingObject.draw(g, panelWidth, panelHeight));
        }
    }
}
