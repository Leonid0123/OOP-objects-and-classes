public enum Operation {
    ADDITION {
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
    },
    SUBTRACTION {
        @Override
        public double apply(double x, double y) {
            return x-y;
        }
    },
    MULTIPLY {
        @Override
        public double apply(double x, double y) {
            return x*y;
        }
    },
    DIVIDE {
        @Override
        public double apply(double x, double y) {
            if (y == 0 )
                throw new ArithmeticException("Деление на 0 запрещено!");
            return x/y;
        }
    };

    public abstract double apply(double x, double y);
}
