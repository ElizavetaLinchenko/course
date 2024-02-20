package transport;

public class Passenger extends Ground {
    private String bodyType;
    private int numberOfPassengers;

    public Passenger(double power, double maxSpeed, double weight, String brand, int numberOfWheels, double fuel, String bodyType, int numberOfPassengers) {
        super(power, maxSpeed, weight, brand, numberOfWheels, fuel);
        this.bodyType = bodyType;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getDescription() {
        return super.getDescription() + String.format("bodyType is %s, numberOfPassengers is %s", bodyType, numberOfPassengers);
    }

    private double calculateFuelConsumption(double distance) {
        return (distance / 100) * getFuel();
    }

    public String calculateDistanceAndFuel(double time) {
        double distance = getMaxSpeed() * time;
        double fuelConsumption = calculateFuelConsumption(distance);
        return String.format(" За время %.2f ч, автомобиль %s двигаясь с максимальной скоростью %.2f км/ч проедет %.2f " +
                        "км и израсходует %.2f литров топлива.\n",
                time, getBrand(), getMaxSpeed(), distance, fuelConsumption);
    }
}