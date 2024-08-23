import java.util.List;

public abstract class Figure {
    private final double startX;
    private final double startY;

    public Figure(double startX, double startY) {
        this.startX = startX;
        this.startY = startY;
    }

    public abstract double getArea();

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public static double sumAllAreas(List<Figure> figures) {
        double res = 0;
        for (Figure figure : figures) {
            res += figure.getArea();
        }
        return res;
    }
}
