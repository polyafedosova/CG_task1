package ru.vsu.fedosova;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {
        this.setSize(1500, 1000);
        this.setTitle("Mountains");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        add(new DrawPanel());
    }
}
