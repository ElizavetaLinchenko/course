package iStart;

public class SpaceX implements IStart {
    int declaredPassengerCount;

    public SpaceX(int declaredPassengerCount) {
        this.declaredPassengerCount = declaredPassengerCount;
    }

    public boolean preLaunchSystemCheck() {
        return declaredPassengerCount <= 5;
    }

    public void startingEngines() {
        System.out.println("Двигатели SpaceX запущены. Все системы в норме.");
    }

    public void start() {
        System.out.println("Старт SpaceX");
    }
}