import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Point p1 = new Point(1, 5);
        Point p2 = new Point(1, 8);
        Point p3 = new Point(2, 3);
        Point p4 = new Point(4, 5);
        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p1, p2);
        Line l3 = new Line(p3, p4);

        System.out.println(l1.equals(l2)); //объекты равны
        System.out.println(l1.equals(l3)); //объекты НЕ равны

        Line cloneL3 = l3.clone();
        System.out.println("before: " + l3.equals(cloneL3)); //объекты до изменений равны
        l3.getStart().setX(9); //изменили значения в l3, проверка на то, что значение cloneL3 не изменится
        l3.getEnd().setY(9);
        System.out.println("after: " + l3.equals(cloneL3)); //объекты после изменения l3 не равны
    }
}