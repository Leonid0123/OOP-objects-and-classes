import java.util.Objects;

public class Line implements Cloneable {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        start = new Point(x1, y1);
        end = new Point(x2, y2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return start.equals(line.start) && end.equals(line.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    protected Line clone() throws CloneNotSupportedException {
        Line line = (Line) super.clone();
        line.start = start.clone();
        line.end = end.clone();
        return line;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }

    public double getLength() {
        int leg1Length = Math.abs(this.start.getX() - this.end.getX());
        int leg2Length = Math.abs(this.start.getY() - this.end.getY());
        return Math.sqrt((leg1Length * leg1Length) + (leg2Length * leg2Length));
    }
}