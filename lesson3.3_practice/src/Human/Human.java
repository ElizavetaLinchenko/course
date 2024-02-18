package Human;

public class Human {
    private String name;
    private Jacket jacket;
    private Pants pants;
    private Shoes shoes;

    Human(String name, Jacket jacket, Pants pants, Shoes shoes) {
        this.name = name;
        this.jacket = jacket;
        this.pants = pants;
        this.shoes = shoes;
    }

    public void dressUp() {
        jacket.putOn();
        pants.putOn();
        shoes.putOn();
    }

    public void undress() {
        jacket.takeOff();
        pants.takeOff();
        shoes.takeOff();
    }
}