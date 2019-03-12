package sierpinski;

import java.util.Scanner;

/**
 *
 * @author Alejandro
 * @version 1.0
 * @since 12/3/2019
 */
public class Sierpinski {

    public static void main(String[] args) {
        System.out.print("Digite el nivel de recursividad (Máximo 9): ");
        Fractal.draw(new Scanner(System.in).next());
    }
    
}
