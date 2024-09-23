import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("один", "два", "три", "четыре"));
        Stream<String> stringStream = strings.stream();
        System.out.println(getStringFromStream(stringStream));
    }

    public static String getStringFromStream(Stream<String> stringStream) {
        return stringStream.map(n -> n + " ").collect(Collectors.joining());
    }
}