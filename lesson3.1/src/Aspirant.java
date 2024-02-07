public class Aspirant extends Student {
    String scientificWork;

    Aspirant(String firstName, String lastName, String group, double averageMark, String scientificWork) {
        super(firstName, lastName, group, averageMark);
        this.scientificWork = scientificWork;
    }

    @Override
    public double getScholarship() {
        if (averageMark == 5) {
            return 2500;
        } else {
            return 2200;
        }
    }
}

