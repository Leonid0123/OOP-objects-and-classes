public class Sum {
    private static double parseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException exception) {
            System.out.println("Не удалось преобразовать в тип double строку " + str);
            return 0;
        }
    }

    public static double calculate(String[] strings) {
        double res = 0;
        for (String str : strings) {
            res += parseDouble(str);
        }
        return res;
    }
}
