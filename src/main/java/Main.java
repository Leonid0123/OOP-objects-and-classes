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

        double brokenLineLength = polyLine.getLength(); //2. Рассчитать длину Ломаной
        System.out.println("Длина ломаной: " + brokenLineLength);
        List<Line> arrayOfLines = polyLine.getLines(); //3. Получить у Ломаной массив Линий
        System.out.println("Массив линий: " + arrayOfLines);

        double arrayOfLinesLength=0; //4. Рассчитать длину массива Линий
        for (Line line : arrayOfLines) {
            arrayOfLinesLength = arrayOfLinesLength + line.getLength();
        }
        System.out.println("Длина массива линий: " + arrayOfLinesLength);

        System.out.println("Длина ломаной и массива линий равны? " + (brokenLineLength == arrayOfLinesLength)); //5. Сравнить длину Ломаной и массива Линий: они должны совпасть
        System.out.println("Изменяемая точка до изменений: " + points.get(1)); //6. Изменить координаты Точки {2,8} таким образом, чтобы она стала иметь значение {12,8}.
        System.out.println("Изменяемая ломаная до изменений: " + polyLine);
        System.out.println("Изменяемый массив до изменений: " + arrayOfLines);
        if (points.get(1).getX() == 2 && points.get(1).getY() == 8) {
            points.get(1).setX(12);
            points.get(1).setY(8);
        }
        System.out.println("Изменяемая точка после изменений: " + points.get(1)); //Если изменения отразились в данной точке,
        System.out.println("Изменяемая ломаная после изменений: " + polyLine); //в Ломаной
        System.out.println("Изменяемый массив после изменений: " + arrayOfLines); //и в двух Линиях массива (из пункта 3), то задача решена верно.
    }
}