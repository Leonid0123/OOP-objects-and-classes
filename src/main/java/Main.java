import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Vasya", 10, new ArrayList<>(Arrays.asList("Anton", "Oleg", "Igor")));
        System.out.println(cat);
        setFieldsToNull(cat);
        System.out.println(cat);

        Dog dog = new Dog("Rex");
        System.out.println(dog);
        setFieldsToNull(dog);
        System.out.println(dog);
    }

    public static void setFieldsToNull(Object obj) {
        Class aClass = obj.getClass();
        for (Field field : aClass.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.getType().isPrimitive())
                    setPrimitiveFieldToDefault(obj, field);
                else
                    field.set(obj, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static void setPrimitiveFieldToDefault(Object obj, Field field) throws IllegalAccessException {
        Class type = field.getType();
        if (type.equals(boolean.class)) {
            field.setBoolean(obj, false);
        } else if (type.equals(byte.class)) {
            field.setByte(obj, (byte) 0);
        } else if (type.equals(char.class)) {
            field.setChar(obj, '\u0000');
        } else if (type.equals(short.class)) {
            field.setShort(obj, (short) 0);
        } else if (type.equals(int.class)) {
            field.setInt(obj, 0);
        } else if (type.equals(long.class)) {
            field.setLong(obj, 0L);
        } else if (type.equals(float.class)) {
            field.setFloat(obj, 0.0f);
        } else if (type.equals(double.class)) {
            field.setDouble(obj, 0.0d);
        }
    }
}