public class Main {
    public static void main(String[] args) {
        Sauce habanero = new Sauce("Хабанеро", Spiciness.VERYHOT);
        Sauce chipotle = new Sauce("Чипотле", Spiciness.HOT);
        Sauce tartar = new Sauce("Тартар", Spiciness.NOTHOT);

        System.out.println(habanero);
        System.out.println(chipotle);
        System.out.println(tartar);
    }
}