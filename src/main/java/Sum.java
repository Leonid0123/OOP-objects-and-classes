public class Sum {
    public static double calculate(String[] strings) {
        double res = 0;
        for (String str : strings) {
            if (str.matches("[-+]?\\d*\\.?\\d+"))
                res += Double.parseDouble(str);
            else System.out.println(str + " не является числом и не будет учитываться при суммировании.");
        }
        return res;
    }
}
