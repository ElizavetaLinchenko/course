package Transport;

public class Cargo extends Ground {
    private double liftingCapacity;

    public Cargo(double power, double maxSpeed, double weight, String brand, int numberOfWheels, double liftingCapacity) {
        super(power, maxSpeed, weight, brand, numberOfWheels, liftingCapacity);
        this.liftingCapacity = liftingCapacity;
    }

    public String getDescription() {
        return super.getDescription() + liftingCapacity;
    }

    public String cargoCapacity(double cargoCapacity) {
        if (cargoCapacity <= liftingCapacity) {
            return " Грузовик загружен";
        } else {
            return " Вам нужен грузовик побольше";
        }
    }
}