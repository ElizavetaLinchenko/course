public abstract class Fruit {
    private double weight;

    Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public final void printManufacturerInfo() {
        System.out.print("Made in Ukraine");
    }

    public abstract double getCost();
}