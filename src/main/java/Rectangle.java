public class Rectangle extends Figure {
    private final double firstSide;
    private final double secondSide;

    public Rectangle(double startX, double startY, double firstSide, double secondSide) {
        super(startX, startY);
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }

    @Override
    public double getArea() {
        return firstSide * secondSide;
    }
}
