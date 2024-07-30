public class Main {
    public static void main(String[] args) {
        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");

        A.addWay(F, 1);
        A.addWay(B, 5);
        A.addWay(D, 6);

        B.addWay(C, 3);
        B.addWay(A, 5);

        C.addWay(D, 4);
        C.addWay(B, 3);

        D.addWay(A, 6);
        D.addWay(E, 2);
        D.addWay(C, 4);

        F.addWay(E, 2);
        F.addWay(B, 1);

        int n = 3; //количество переходов
        City destination = B.travelBy(n);
        if (destination != null)
            System.out.println("Путешествие из города " + B.getName() + " в город " + destination.getName() + " за количество переходов равное " + n);
    }
}