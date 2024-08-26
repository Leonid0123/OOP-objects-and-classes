package ru.courses.geometry;

public class Circle extends Figure{
    private final double radius;

    public Circle(double startX, double startY, double radius) {
        super(startX, startY);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius,2);
    }
}