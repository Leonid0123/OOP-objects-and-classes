import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(1, 3, 5);
        Square square = new Square(2, 3, 7);
        Rectangle rectangle = new Rectangle(4, 4, 4, 4);

        System.out.println("Площадь круга: " + circle.getArea());
        System.out.println("Площадь квадрата: " + square.getArea());
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());

        List<Figure> figures = new ArrayList<>(List.of(circle, square, rectangle));
        System.out.println("Общая площадь всех фигур: " + Figure.sumAllAreas(figures));
    }
}