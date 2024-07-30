public class Main {
    public static void main(String[] args) {
        Square s1 = new Square(3, 4, 2);
        System.out.println(s1);
        s1.setX(5);
        s1.setY(5);
        s1.setSideLength(5);
        System.out.println(s1);
    }
}