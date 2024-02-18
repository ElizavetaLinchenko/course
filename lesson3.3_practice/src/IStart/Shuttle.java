package IStart;

import java.util.Random;

public class Shuttle implements IStart {
    public boolean preLaunchSystemCheck() {
        Random random = new Random();
        int randomNumber = random.nextInt(11);

        if (randomNumber > 3) {
            return true;
        } else {
            return false;
        }
    }

    public void startingEngines() {
        System.out.println("Двигатели Шаттла запущены. Все системы в норме.");
    }

    public void start() {
        System.out.println("Старт Шаттла");
    }
}