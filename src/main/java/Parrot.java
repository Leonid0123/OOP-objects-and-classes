import java.util.Random;

public class Parrot implements Birdable {
    final private String textSing;

    public Parrot(String textSing) {
        this.textSing = textSing;
    }

    @Override
    public void Sing() {
        int min = 1;
        int max = textSing.length();
        Random rand = new Random();
        int count = rand.nextInt(max - min + 1) + min;
        System.out.println(textSing.substring(0, count));
    }
}
