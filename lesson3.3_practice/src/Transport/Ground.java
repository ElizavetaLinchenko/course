package Transport;

public class Ground extends Transport {
    private int numberOfWheels;
    private double fuel;

    public Ground(double power, double maxSpeed, double weight, String brand, int numberOfWheels, double fuel) {
        super(power, maxSpeed, weight, brand);
        this.numberOfWheels = numberOfWheels;
        this.fuel = fuel;
    }

    public double getFuel() {
        return fuel;
    }

    public String getDescription() {
        return String.format("Мощность: %.2f л.с. (%.2f кВ)%nМаксимальная скорость: %.2f км/ч%nМасса: %.2f кг%nМарка: " +
                        "%s%nКоличество колес: %d%nРасход топлива: %.2f л/100 км ",
                getPower(), convertPowerToKilowatts(), getMaxSpeed(), getWeight(), getBrand(), numberOfWheels, fuel);
    }
}