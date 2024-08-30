public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 5);
        Fraction f3 = new Fraction(7, 8);
        Fraction f4 = new Fraction(1, 3);

        System.out.println("Сравнение объектов f1 и f4: " + f1.equals(f4)); //объекты равны
        System.out.println("Сравнение объектов f1 и f2: " + f1.equals(f2)); //объекты НЕ равны

        Fraction f5 = (Fraction) f3.clone();
        System.out.println("Сравнение объектов f5 и f3: " + f5.equals(f3)); //объекты равны
    }
}