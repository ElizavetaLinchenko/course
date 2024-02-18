package Human;

public class Main {
    public static void main(String[] args) {
        Jacket jacket = new LongJacket();
        Pants pants = new ShortPants();
        Shoes shoes = new MartensShoes();

        Human human = new Human("Maria", jacket, pants, shoes);
        human.dressUp();
        human.undress();
    }
}