package transport;

public class Air extends Transport {
    private double wingspan;
    private double minLength;

    public Air(double power, double maxSpeed, double weight, String brand, double wingspan, double minLength) {
        super(power, maxSpeed, weight, brand);
        this.wingspan = wingspan;
        this.minLength = minLength;
    }

    public String getDescription() {
        return String.format(
                "Мощность: %.2f л.с. (%.2f кВ)%nМаксимальная скорость: %.2f км/ч%nМасса: %.2f кг%nМарка: %s%nРазмах " +
                        "крыльев: %.2f м%nМинимальная длина взлетно-посадочной полосы для взлета: %.2f м",
                getPower(), convertPowerToKilowatts(), getMaxSpeed(), getWeight(), getBrand(), wingspan, minLength);
    }
}