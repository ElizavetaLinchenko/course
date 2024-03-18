public class Apricot extends Fruit {
    public Apricot(double weight) {
        super(weight);
    }

    @Override
    public double getCost() {
        return getWeight() * 9;
    }
}