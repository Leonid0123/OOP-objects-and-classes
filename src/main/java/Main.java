import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);
        reverse(list);
        reverse(arr);
        System.out.println(list);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(Integer[] intArray) {
        int n = intArray.length - 1;
        for (int i = 0; i < intArray.length / 2; i++) {
            int temp = intArray[i];
            intArray[i] = intArray[n - i];
            intArray[n - i] = temp;
        }
    }

    public static void reverse(ArrayList<Integer> list) {
        int n = list.size() - 1;
        for (int i = 0; i < list.size() / 2; i++) {
            int temp = list.get(i);
            list.set(i,list.get(n-i));
            list.set(n-i, temp);
        }
    }
}