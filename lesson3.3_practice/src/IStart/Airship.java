package IStart;

public class Airship implements IStart {
    double maxWeight;

    Airship(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean preLaunchSystemCheck() {
        int decklaredWeight = 1000;
        if (decklaredWeight > maxWeight) {
            return false;
        } else {
            return true;
        }
    }

    public void startingEngines() {
        System.out.println("Двигатели Airship запущены. Все системы в норме.");
    }

    public void start() {
        System.out.println("Старт Airship");
    }
}