public class Main {
    /*
            Создайте пример наследования, реализуйте класс Student и класс Aspirant, аспирант отличается от студента наличием некой научной работы.
            Класс Student содержит переменные: String firstName, lastName, group.

            А также, double averageMark, содержащую среднюю оценку.

            Создать метод getScholarship() для класса Student, который возвращает сумму стипендии.
            Если средняя оценка студента равна 5, то сумма 2000 usd, иначе 1900.

            Переопределить этот метод в классе Aspirant.
            Если средняя оценка аспиранта равна 5, то сумма 2500 usd, иначе 2200.
            Создать массив типа Student, содержащий объекты класса Student и Aspirant.
            Вызвать метод getScholarship() для каждого элемента массива.
             */

    public static void main(String[] args) {
        Student oneStudent = new Student("Мария", "Иванова", "136", 3);
        Aspirant oneAspirant = new Aspirant("Юлия", "Петрова", "12", 5, "Наука и жизнь");

        Student[] arrayStudents = {oneStudent, oneAspirant};

        for (int i = 0; i < arrayStudents.length; i++) {
            if (arrayStudents[i] instanceof Aspirant) {
                System.out.println("Стипендия " + arrayStudents[i].firstName + " " + arrayStudents[i].lastName + " - "
                        + arrayStudents[i].getScholarship() + "\nНаучная работа - " + ((Aspirant) arrayStudents[i]).scientificWork);
            } else {
                System.out.println("Стипендия " + arrayStudents[i].firstName + " " + arrayStudents[i].lastName + " - "
                        + arrayStudents[i].getScholarship());
            }
        }
    }
}


