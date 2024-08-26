package ru.courses.birds;

import java.util.Random;

public class Cuckoo implements Birdable {
    @Override
    public void Sing() {
        Random rand = new Random();
        int count = rand.nextInt(10) + 1;
        for (int i = 0; i < count; i++) {
            System.out.println("ку-ку");
        }
    }
}
