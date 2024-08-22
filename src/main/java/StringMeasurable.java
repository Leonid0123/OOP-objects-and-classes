public class StringMeasurable implements Measurable {
    String str;

    public StringMeasurable(String str) {
        this.str = str;
    }

    @Override
    public double getLength() {
        return str.length();
    }
}
