package ru.vsu.fedosova;

import ru.vsu.fedosova.objects.*;

import javax.swing.*;
import java.awt.*;
import static ru.vsu.fedosova.util.RandomUtil.*;
import static ru.vsu.fedosova.util.ArrayUtil.*;

public class DrawPanel extends JPanel {
    private final World world;

    public DrawPanel() {
        world = new World(0, 0, 1, 1, Color.white);

        world.getObjects().add(new Sky(0, 0, 1, 1));
        world.getObjects().add(new Mountain(0.35, 0.7, 0.4, 0.5, new Color(255, 255, 255)));
        world.getObjects().add(new Mountain(0.5, 0.7, 0.38, 0.4, new Color(205, 133, 183)));
        world.getObjects().add(new Mountain(0.2, 0.7, 0.35, 0.3, new Color(71, 35, 61)));

        world.getObjects().add(new Mountain(0.35, 0.7, 0.4, - 0.25, new Color(255, 255, 255)));
        world.getObjects().add(new Mountain(0.5, 0.7, 0.38, - 0.2, new Color(205, 133, 183)));
        world.getObjects().add(new Mountain(0.2, 0.7, 0.35, - 0.15, new Color(71, 35, 61)));

        for (int i = 0; i < 3; i++) {
            world.getObjects().add(new Cloud(randDouble(0.3*i, 0.3 * (1 + i)), randDouble(0.2, 0.5), 0.3 + 0.05 * i, 0.05, new Color(232, 211, 211, 228)));
            world.getObjects().add(new Cloud(randDouble(0.3*i, 0.3 * (1 + i)), randDouble(0.2, 0.5), 0.2 + 0.05 * i, 0.05, new Color(153, 96, 106, 218)));
        }

        double[] dif = new double[11];
        for (int i = 0; i < 11; i++) {
            dif[i] = randDouble(0.01, 0.07);
        }
        world.getObjects().add(new Glacier(0.15, 0.7, 0.75, 0.07, new Color(255, 255, 255), dif));
        world.getObjects().add(new Glacier(0.15, 0.7, 0.75, 0.07, new Color(255, 255, 255), multiplyArrayBy(dif, -1)));

        world.getObjects().add(new Water(0, 0.7, 1, 0.3, new Color(175, 196, 213, 77)));

        Foreground secondPlan = new Foreground(0, 1, 1, 0.7, new Color(73,37,63), true);
        Foreground firstPlan = new Foreground(0, 1, 1, 0.3, new Color(57,32,51), false);
        world.getObjects().add(secondPlan);

        for (int i = 0; i < firstPlan.getX().length - 3; i++) {
            i+=4;
            if (i < 9 || i > 15) {
                world.getObjects().add(new Tree(secondPlan.getX()[i - 2], secondPlan.getY()[i], randDouble(0.3, 0.8), new Color(73, 37, 63)));
                world.getObjects().add(new Tree(firstPlan.getX()[i], firstPlan.getY()[i], randDouble(0.3, 0.8), new Color(57, 32, 51)));
            }
        }
        world.getObjects().add(firstPlan);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gr2d = (Graphics2D) g;
        this.world.draw(gr2d, this.getWidth(), this.getHeight());
    }
}
