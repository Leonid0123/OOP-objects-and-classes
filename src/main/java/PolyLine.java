import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PolyLine {
    final private List<Point> points;

    public PolyLine(List<Point> pointList) {
        this.points = pointList;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Линия " + points;
    }

    public List<Line> getLines() {
        List<Line> res = new ArrayList<>();
        for (int i = 0; i < this.points.size() - 1; i++) {
            res.add(new Line(points.get(i), points.get(i + 1)));
        }
        return res;
    }

    public double getLength() {
        double res = 0;
        List<Line> lines = this.getLines();
        for (Line line : lines) {
            res = res + line.getLength();
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolyLine polyLine = (PolyLine) o;
        List<Point> pointsThis = this.getPoints();
        List<Point> pointsPolyLine = polyLine.getPoints();
        if (pointsThis.size() != pointsPolyLine.size()) return false;
        for (int i = 0; i < pointsThis.size(); i++) {
            if (!pointsThis.get(i).equals(pointsPolyLine.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
