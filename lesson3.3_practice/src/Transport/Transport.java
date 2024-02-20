package transport;

public class Transport {
    private double power;
    private double maxSpeed;
    private double weight;
    private String brand;

    Transport(double power, double speed, double weight, String brand) {
        this.power = power;
        this.maxSpeed = speed;
        this.weight = weight;
        this.brand = brand;
    }

    public double getPower() {
        return power;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getWeight() {
        return weight;
    }

    public String getBrand() {
        return brand;
    }

    public double convertPowerToKilowatts() {
        return getPower() * 0.74;
    }
}