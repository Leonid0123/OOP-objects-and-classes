import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> strings = new ArrayList<>(Arrays.asList(1, 423, 5231, 34215));
        printList(strings);
    }

    public static void printList(ArrayList<Integer> list) {
        list.forEach(i -> System.out.println(i));
    }
}