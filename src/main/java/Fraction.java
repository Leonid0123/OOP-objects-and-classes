public class Fraction extends Number {
    private final int numerator; //числитель
    private final int denominator; //знаменатель

    public Fraction(int numerator, int denominator) { //добавить проверку на знаменатель > 0
        if (denominator <= 0) {
            throw new IllegalArgumentException("Denominator должен быть больше нуля.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction sum(Fraction f2) {
        int resNumerator;
        int resDenominator;
        if (this.denominator == f2.denominator) {
            resNumerator = this.numerator + f2.numerator;
            resDenominator = this.denominator;
        } else {
            resNumerator = (this.numerator * f2.denominator) + (f2.numerator * this.denominator);
            resDenominator = this.denominator * f2.denominator;
        }
        return new Fraction(resNumerator, resDenominator);
    }

    public Fraction minus(Fraction f2) {
        int resNumerator;
        int resDenominator;
        if (this.denominator == f2.denominator) {
            resNumerator = this.numerator - f2.numerator;
            resDenominator = this.denominator;
        } else {
            resNumerator = (this.numerator * f2.denominator) - (f2.numerator * this.denominator);
            resDenominator = this.denominator * f2.denominator;
        }
        return new Fraction(resNumerator, resDenominator);
    }

    public Fraction sum(int i2) {
        int resNumerator = this.numerator + (i2 * this.denominator);
        return new Fraction(resNumerator, this.denominator);
    }

    public Fraction minus(int i2) {
        int resNumerator = this.numerator - (i2 * this.denominator);
        return new Fraction(resNumerator, this.denominator);
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }
}
