import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(4);
        list.add(1);

        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);
        bubbleSort(list);
        bubbleSort(arr);
        System.out.println(list);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(ArrayList<Integer> intList) {
        for (int i = 0; i < intList.size() - 1; i++) {
            for (int j = 0; j < intList.size() - i - 1; j++) {
                if (intList.get(j) > intList.get(j + 1)) {
                    int temp = intList.get(j);
                    intList.set(j, intList.get(j + 1));
                    intList.set(j + 1, temp);
                }
            }
        }
    }

    public static void bubbleSort(Integer[] intArray) {
        for (int i = 0; i < intArray.length - 1; i++) {
            for (int j = 0; j < intArray.length - i - 1; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    int temp = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = temp;
                }
            }
        }
    }
}