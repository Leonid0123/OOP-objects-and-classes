import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>(); //1. Создать Ломаную, проходящую через точки {1;5}, {2;8}, {5;3}, {8,9}
        points.add(new Point(1, 5));
        points.add(new Point(2, 8));
        points.add(new Point(5, 3));
        points.add(new Point(8, 9));
        PolyLine polyLine = new PolyLine(points);
        ClosedPolyLine closedPolyLine = new ClosedPolyLine(points);
        StringMeasurable str = new StringMeasurable("Пример строки");

        double res1 = polyLine.getLength();
        double res2 = closedPolyLine.getLength();
        double res3 = str.getLength();
        System.out.println("Длина ломаной линии: " + res1);
        System.out.println("Длина замкнутой ломаной линии: " + res2);
        System.out.println("Длина строки: " + res3);

        Measurable[] measurable = {polyLine, closedPolyLine, str};
        double totalLength = LengthCalculator.sumLength(measurable);
        System.out.println("Общая длина: " + totalLength);
    }
}