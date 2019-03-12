package sierpinski;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro
 * @version 1.0
 * @since 12/03/2019
 */
public class Fractal extends JPanel {

    private int level;

    //Constructor
    public Fractal(int level) {
        this.level = level;
        setPreferredSize(new Dimension(800, 800));
    }

    /**
     * main de la clase Fractal
     * @param recursivity 
     */
    public static void draw(String recursivity) {
        if (recursivity.length() == 1) {
            try {
                int level = Integer.parseInt(recursivity);
                setFrame(level);
            } catch (NumberFormatException f) {
                System.out.println("Error: " + f.getMessage());
            }
        }
    }

    /**
     * Caracteristicas del frame
     * @param level 
     */
    private static void setFrame(int level) {
        JFrame frame = new JFrame("Sierpinski");
        frame.getContentPane().add(new Fractal(level));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    /**
     * Llama a la función de dibujado del triangulo y pone los colores de relleno
     * y el fondo
     * @param g 
     */
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        Dimension size = getSize();
        graphics.setColor(Color.DARK_GRAY);
        graphics.fill(new Rectangle(0, 0, size.width, size.height));
        graphics.setColor(Color.ORANGE);
        triangle(graphics, new Point(700, 700), new Point(30, 700), new Point(365, 120), level);
    }

    /**
     * Dibuja el triangulo desde 3 puntos ubicados en cada esquina de un triangulo
     * @param triangle
     * @param firstPoint
     * @param secondPoint
     * @param thirdPoint
     * @param level 
     */
    private void triangle(Graphics2D triangle, Point firstPoint, Point secondPoint, Point thirdPoint, int level) {
        int deltaX1 = (secondPoint.x + firstPoint.x) / 2;
        int deltaY1 = (secondPoint.y + firstPoint.y) / 2;

        int deltaX2 = (thirdPoint.x + secondPoint.x) / 2;
        int deltaY2 = (thirdPoint.y + secondPoint.y) / 2;

        int deltaX3 = (firstPoint.x + thirdPoint.x) / 2;
        int deltaY3 = (firstPoint.y + thirdPoint.y) / 2;
        if (level <= 0) {
            triangle.drawLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
            triangle.drawLine(secondPoint.x, secondPoint.y, thirdPoint.x, thirdPoint.y);
            triangle.drawLine(thirdPoint.x, thirdPoint.y, firstPoint.x, firstPoint.y);
        } else {

            triangle(triangle, new Point((firstPoint.x), (firstPoint.y)), new Point((deltaX1), (deltaY1)), new Point((deltaX3), (deltaY3)), level - 1);
            triangle(triangle, new Point((secondPoint.x), (secondPoint.y)), new Point((deltaX2), (deltaY2)), new Point((deltaX1), (deltaY1)), level - 1);
            triangle(triangle, new Point((thirdPoint.x), (thirdPoint.y)), new Point((deltaX3), (deltaY3)), new Point((deltaX2), (deltaY2)), level - 1);
        }
    }


}
