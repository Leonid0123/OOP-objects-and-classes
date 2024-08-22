public class LengthCalculator {
    public static double sumLength(Measurable[] measurables) {
        double res = 0;
        for (Measurable measurable : measurables) {
            res += measurable.getLength();
        }
        return res;
    }
}
