package IStart;

public class SpaceX implements IStart {
    int declaredPassengerCount;

    public SpaceX(int declaredPassengerCount) {
        this.declaredPassengerCount = declaredPassengerCount;
    }

    public boolean preLaunchSystemCheck() {
        int numberOfPassengers = 5;
        if (declaredPassengerCount > numberOfPassengers) {
            return false;
        } else {
            return true;
        }
    }

    public void startingEngines() {
        System.out.println("Двигатели SpaceX запущены. Все системы в норме.");
    }

    public void start() {
        System.out.println("Старт SpaceX");
    }
}