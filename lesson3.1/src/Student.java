public class Student {
    String firstName;
    String lastName;
    String group;
    double averageMark;

    Student(String firstName, String lastName, String group, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public double getScholarship() {
        if (averageMark == 5) {
            return 2000;
        } else {
            return 1900;
        }
    }
}

