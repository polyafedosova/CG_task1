package ru.vsu.fedosova.objects;

import ru.vsu.fedosova.DrawingObject;

import java.awt.*;

import static ru.vsu.fedosova.util.ArrayUtil.multiplyArrayBy;
import static ru.vsu.fedosova.util.ArrayUtil.toIntArray;
import static ru.vsu.fedosova.util.DrawUtil.drawWithColor;

public class Tree extends DrawingObject {
    public Tree(double cofX, double cofY, double cofH, Color color) {
        super(cofX, cofY, cofH, color);
    }

    @Override
    public void draw(Graphics2D g, int panelWidth, int panelHeight) {
        drawWithColor(g, this.color, () -> {
            g.fillRect((int) ((cofX - cofH / 60) * panelWidth), (int) ((cofY - cofH / 2) * panelHeight),
                    (int) ((cofH / 30) * panelWidth), (int) (cofH * panelHeight));
            g.fillPolygon(toIntArray(multiplyArrayBy(new double[] {cofX - cofH / 12, cofX + cofH / 12, cofX}, panelWidth)),
                    toIntArray(multiplyArrayBy(new double[] {cofY - cofH / 10, cofY - cofH / 10, cofY - cofH * 2 / 3}, panelHeight)), 3);
            g.fillPolygon(toIntArray(multiplyArrayBy(new double[] {cofX - cofH / 13, cofX + cofH / 13, cofX}, panelWidth)),
                    toIntArray(multiplyArrayBy(new double[] {cofY - cofH / 3, cofY - cofH / 3, cofY - cofH * 7 / 9}, panelHeight)), 3);
            g.fillPolygon(toIntArray(multiplyArrayBy(new double[] {cofX - cofH / 15, cofX + cofH / 15, cofX}, panelWidth)),
                    toIntArray(multiplyArrayBy(new double[] {cofY - cofH / 2, cofY - cofH / 2, cofY - cofH * 7 / 9}, panelHeight)), 3);
        });
    }
}
