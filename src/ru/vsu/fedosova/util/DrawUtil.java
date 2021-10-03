package ru.vsu.fedosova.util;

import com.sun.prism.paint.Gradient;

import java.awt.*;

public class DrawUtil {
    public static void drawWithColor(Graphics2D g, Color color, Runnable drawAction) {
        Color oldC = g.getColor();
        g.setColor(color);
        drawAction.run();
        g.setColor(oldC);
    }

    public static void drawWithGradient(Graphics2D g, GradientPaint gradient, Runnable drawAction) {
        Color oldC = g.getColor();
        g.setPaint(gradient);
        drawAction.run();
        g.setColor(oldC);
    }

    public static void drawWithFont(Graphics2D g, Font font, Runnable drawAction) {
        Font oldF = g.getFont();
        g.setFont(font);
        drawAction.run();
        g.setFont(oldF);
    }
}
