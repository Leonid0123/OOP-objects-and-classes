import java.util.Random;

public class Cuckoo extends Bird {
    @Override
    public void Sing() {
        Random rand = new Random();
        int count = rand.nextInt(10) + 1;
        for (int i = 0; i < count; i++) {
            System.out.println("ку-ку");
        }
    }
}
