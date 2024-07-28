import java.util.ArrayList;
import java.util.List;

public class PolyLine {
    private List<Point> polyLine = new ArrayList<>();

    public PolyLine() {
    }

    public PolyLine(List<Point> pointList) {
        this.polyLine = pointList;
    }

    @Override
    public String toString() {
        return "Линия " + polyLine;
    }

    public List<Line> getLines() {
        List<Line> res = new ArrayList<>();
        for (int i = 0; i < this.polyLine.size()-1; i++) {
            res.add(new Line(polyLine.get(i),polyLine.get(i+1)));
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
}
