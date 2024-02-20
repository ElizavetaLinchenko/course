package iStart;

public class Main {
    public static void main(String[] args) {
        Cosmodrome cosmodrome = new Cosmodrome();
        Shuttle shuttle = new Shuttle();
        SpaceX spacex = new SpaceX(5);
        Airship airship = new Airship(2400);

        cosmodrome.launch(shuttle);
        cosmodrome.launch(spacex);
        cosmodrome.launch(airship);
    }
}