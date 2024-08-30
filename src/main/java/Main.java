public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Point p1 = new Point(1,2);
        Point p2 = new Point(2, 3);
        Point p3 = new Point(1,2);
        System.out.println(p1.equals(p3)); //объекты равны
        System.out.println(p1.equals(p2)); //объекты НЕ равны

        Point p4 = p2.clone();
        System.out.println(p2.equals(p4)); //объекты равны
    }
}