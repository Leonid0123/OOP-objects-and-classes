public class Main {
    public static void main(String[] args) {
        System.out.println("1 + 3.3 = " + Operation.ADDITION.apply(1,3.3));
        System.out.println("3 - 1.1 = " + Operation.SUBTRACTION.apply(3,1.1));
        System.out.println("2.5 * 3 = " + Operation.MULTIPLY.apply(2.5,3));
        System.out.println("3 / 2 = " + Operation.DIVIDE.apply(3,2));
    }
}