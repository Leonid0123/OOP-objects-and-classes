public class Line implements Measurable {
    private final Point start;
    private final Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        start = new Point(x1, y1);
        end = new Point(x2, y2);
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