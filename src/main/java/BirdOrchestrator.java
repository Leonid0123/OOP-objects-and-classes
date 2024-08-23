import java.util.List;

public class BirdOrchestrator {
    public static void singAllBirds(List<Birdable> setOfBirds) {
        for (Birdable bird : setOfBirds) {
            bird.Sing();
        }
    }
}
