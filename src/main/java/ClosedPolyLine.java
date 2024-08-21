import java.util.List;

public class ClosedPolyLine extends PolyLine {
    public ClosedPolyLine(List<Point> pointList) {
        super(pointList);
    }

    public List<Line> getLines() {
        List<Line> res = super.getLines();
        List<Point> polyLine = this.getPolyLine();
        res.add(new Line(polyLine.get(0),polyLine.get(polyLine.size()-1)));
        return res;
    }
}
