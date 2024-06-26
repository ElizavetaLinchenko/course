public class Student {
    private String firstName;
    private String lastName;
    private String group;
    private double averageMark;

    Student(String firstName, String lastName, String group, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public double getScholarship() {
        if (averageMark == 5) {
            return 2000;
        } else {
            return 1900;
        }
    }
}


