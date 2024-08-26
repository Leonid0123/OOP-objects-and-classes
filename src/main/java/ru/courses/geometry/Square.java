package ru.courses.geometry;

public class Square extends Figure{
    private final double sideLength;

    public Square(double startX, double startY, double sideLength) {
        super(startX, startY);
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return Math.pow(sideLength,2);
    }
}
