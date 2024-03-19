package iStart;

public class Airship implements IStart {
    double maxWeight;

    Airship(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean preLaunchSystemCheck() {
        return !(1000 > maxWeight);
    }

    public void startingEngines() {
        System.out.println("Двигатели Airship запущены. Все системы в норме.");
    }

    public void start() {
        System.out.println("Старт Airship");
    }
}