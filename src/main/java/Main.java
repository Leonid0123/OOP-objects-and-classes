import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //первая ломаная
        List<Point> points1 = new ArrayList<>();
        points1.add(new Point(1, 5));
        points1.add(new Point(2, 8));
        points1.add(new Point(5, 3));
        points1.add(new Point(8, 9));
        PolyLine polyLine1 = new PolyLine(points1);

        //вторая ломаная
        List<Point> points2 = new ArrayList<>();
        points2.add(new Point(2, 3));
        points2.add(new Point(4, 5));
        points2.add(new Point(6, 7));
        points2.add(new Point(8, 9));
        PolyLine polyLine2 = new PolyLine(points2);

        //третья ломаная (копия первой)
        List<Point> points3 = new ArrayList<>(); //1. Создать Ломаную, проходящую через точки {1;5}, {2;8}, {5;3}, {8,9}
        points3.add(new Point(1, 5));
        points3.add(new Point(2, 8));
        points3.add(new Point(5, 3));
        points3.add(new Point(8, 9));
        PolyLine polyLine3 = new PolyLine(points3);

        System.out.println(polyLine1.equals(polyLine3)); //объекты равны
        System.out.println(polyLine1.equals(polyLine2)); //объекты НЕ равны
    }
}