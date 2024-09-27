public class Dog {
    private static byte aByte = (byte) 152;
    private static short aShort = (short) 152;
    private static int anInt = 152;
    private static long aLong = 152;
    private static float aFloat = (float) 152;
    private static double aDouble = (double) 152;
    private static boolean aBoolean = true;
    private static char aChar = (char) 152;
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
