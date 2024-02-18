package Transport;

public class Main {
    public static void main(String[] args) {
        Passenger passenger = new Passenger(1000, 250, 2500, "BMW", 4,
                6, "sedan", 5);
        System.out.println(passenger.getDescription() + passenger.calculateDistanceAndFuel(2.5));

        Cargo cargo = new Cargo(1500, 300, 3000, "MAN", 8, 20);
        System.out.println(cargo.getDescription() + cargo.cargoCapacity(10));

        Military military = new Military(5000, 1500, 20000, "MQ-1C Gray Eagle",
                50, 3000, true, 8);
        System.out.println(military.getDescription() + military.shoot() + military.eject());

        Civil civil = new Civil(20000, 1000, 50000, "Airbus", 50,
                2000, 200, true);
        System.out.println(civil.getDescription() + civil.passengersCapacity(250));
    }
}