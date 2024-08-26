package ru.courses.geometry;

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
}