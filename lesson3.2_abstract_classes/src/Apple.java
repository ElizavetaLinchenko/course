public class Apple extends Fruit {
    public Apple(double weight) {
        super(weight);
    }

    @Override
    public double getCost() {
        return getWeight() * 5.50;
    }
}