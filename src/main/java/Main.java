public class Main {
    public static void main(String[] args) {
        Number[] example1 = {2, new Fraction(3,5), 2.3};
        Number[] example2 = {3.6, new Fraction(49,12), 3, new Fraction(3,2)};
        Number[] example3 = {new Fraction(1,3), 1};
        System.out.println("2 + 3/5 + 2.3 = " + Fraction.sumAll(example1));
        System.out.println("3.6 + 49/12 + 3 + 3/2 = " + Fraction.sumAll(example2));
        System.out.println("1/3 + 1 = " + Fraction.sumAll(example3));
    }
}