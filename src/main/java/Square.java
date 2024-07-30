public class Square {
    private int x;
    private int y;
    private int sideLength;

    public Square(int x, int y, int sideLength) {
        this.setX(x);
        this.setY(y);
        this.setSideLength(sideLength);
    }

    @Override
    public String toString() {
        return "Квадрат в точке {" + x + "," + y + "} со стороной " + sideLength;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSideLength(int sideLength) {
        if (sideLength > 0)
            this.sideLength = sideLength;
        else
            throw new IllegalArgumentException("Вы указали значение sideLength <= 0. Это некорректное значение. Длина стороны квадрата обязана быть всегда положительной.");
    }
}
