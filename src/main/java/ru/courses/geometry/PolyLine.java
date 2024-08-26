package ru.courses.geometry;

import java.util.ArrayList;
import java.util.List;

public class PolyLine implements Measurable {
    final private List<Point> polyLine;

    public PolyLine(List<Point> pointList) {
        this.polyLine = pointList;
    }

    public List<Point> getPolyLine() {
        return polyLine;
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
