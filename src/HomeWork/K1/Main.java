package HomeWork.K1;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];

        shapes[0] = new Rectangle(5, 10);
        shapes[1] = new Circle(7);

        for (Shape shape : shapes) {
            shape.displayInfo();
            System.out.println("Diện tích: " + shape.getArea());
            System.out.println("Chu vi: " + shape.getPerimeter());

            if (shape instanceof Drawable) {
                ((Drawable) shape).draw();
            }

            System.out.println("--------------------");
        }
    }
}
