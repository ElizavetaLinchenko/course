public class Pear extends Fruit {
    public Pear(double weight) {
        super(weight);
    }

    @Override
    public double getCost() {
        return getWeight() * 7.80;
    }
}