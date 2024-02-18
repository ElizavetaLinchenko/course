package Transport;

public class Military extends Air {
    private boolean ejectionSystem;
    private int numberOfMissiles;

    public Military(double power, double maxSpeed, double weight, String brand, double wingspan, double minLength,
                    boolean ejectionSystem, int numberOfMissiles) {
        super(power, maxSpeed, weight, brand, wingspan, minLength);
        this.ejectionSystem = ejectionSystem;
        this.numberOfMissiles = numberOfMissiles;
    }

    public String getDescription() {
        return super.getDescription() + String.format(" ejectionSystem is %s numberOfMissiles is %s ", ejectionSystem, numberOfMissiles);
    }

    public String shoot() {
        if (numberOfMissiles != 0) {
            return ("Ракета пошла... ");
        } else {
            return ("Боеприпасы отсутствуют.");
        }
    }

    public String eject() {
        if (ejectionSystem) {
            return ("Катапультирование прошло успешно.");
        } else {
            return ("У вас нет такой системы.");
        }
    }
}