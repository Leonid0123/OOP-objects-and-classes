import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int number = 0;
        do {
            System.out.println("Введите четное целое число для создания списка: ");
            String line = new Scanner(System.in).nextLine();
            try {
                number = Integer.parseInt(line);
            } catch (IllegalArgumentException e) {
                System.out.println("Введено не целое число!");
            }
            if (number%2!=0)
                System.out.println("Введено нечетное число!");
        } while (number%2!=0);
        for (int i = 1; i <= number; i++) {
            list.add(i);
        }
        ArrayList<Integer> resList = new ArrayList<>();
        for (int i = 0; i < number; i=i+2) {
            resList.add(list.get(i+1));
            resList.add(list.get(i));
        }
        System.out.println(resList);
    }
}