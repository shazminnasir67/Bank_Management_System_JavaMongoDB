package bank_management_system.Components;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;

public class GradientPanel extends JPanel {
    private Color startColor;
    private Color endColor;

    public GradientPanel(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        // Create the gradient paint object
        GradientPaint gradient = new GradientPaint(0, 0, startColor, width, height, endColor);

        // Cast Graphics to Graphics2D for additional functionality
        Graphics2D g2d = (Graphics2D) g;

        // Set the paint to the gradient and fill the entire panel with it
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200); // Set your desired size here
    }
}
