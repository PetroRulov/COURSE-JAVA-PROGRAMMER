package lesson3.shapes;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{

        IDrawable[] shapes = new IDrawable[4];

        shapes[0] = new Circle();
        shapes[1] = new Square();
        shapes[2] = new Rectangle();
        shapes[3] = new Triangle();

        ShapesTemplate template = new ShapesTemplate(shapes);

    }
}
