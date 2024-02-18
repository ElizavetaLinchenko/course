package Transport;

public class Civil extends Air {
    private int numberOfPassengers;
    private boolean businessClass;

    public Civil(double power, double maxSpeed, double weight, String brand, double wingspan, double minLength,
                 int numberOfPassengers, boolean businessClass) {
        super(power, maxSpeed, weight, brand, wingspan, minLength);
        this.numberOfPassengers = numberOfPassengers;
        this.businessClass = businessClass;
    }

    public String getDescription() {
        return super.getDescription() + String.format(" numberOfPassengers is %s, businessClass is %s", numberOfPassengers, businessClass);
    }

    public String passengersCapacity(double passengers) {
        if (passengers <= numberOfPassengers) {
            return " Самолет загружен";
        } else {
            return " Вам нужен самолет побольше";
        }
    }
}