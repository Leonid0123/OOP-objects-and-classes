import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        Cuckoo cuckoo = new Cuckoo();
        Parrot parrot = new Parrot("Привет, как дела?");
        sparrow.Sing();
        cuckoo.Sing();
        parrot.Sing();

        List<Birdable> setOfBirds = new ArrayList<>(List.of(sparrow, cuckoo, parrot));
        BirdOrchestrator.singAllBirds(setOfBirds);
    }
}