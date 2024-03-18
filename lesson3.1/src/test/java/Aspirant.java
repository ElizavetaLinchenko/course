public class Aspirant extends Student {
    private String scientificWork;

    Aspirant(String firstName, String lastName, String group, double averageMark, String scientificWork) {
        super(firstName, lastName, group, averageMark);
        this.scientificWork = scientificWork;
    }

    @Override
    public double getScholarship() {
        if (getAverageMark() == 5) {
            return 2500;
        } else {
            return 2200;
        }
    }
}

