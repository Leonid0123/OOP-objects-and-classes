public class Square {
    private final Point point;
    private int sideLength;

    public Square(int x, int y, int sideLength) {
        this.point = new Point(x, y);
        this.setSideLength(sideLength);
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + point + " со стороной " + sideLength;
    }

    public void setX(int x) {
        this.point.setX(x);
    }

    public void setY(int y) {
        this.point.setY(y);
    }

    public void setSideLength(int sideLength) {
        if (sideLength > 0)
            this.sideLength = sideLength;
        else
            throw new IllegalArgumentException("Вы указали значение sideLength <= 0. Это некорректное значение. Длина стороны квадрата обязана быть всегда положительной.");
    }
}
