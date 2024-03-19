import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Lesson6 {
    private static String baseUrl = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {
        task1();
        task2();
        task3();
    }

    public static void task1() throws IOException {
        /*
        Создать программу для чтения данных из текстового файла variant2.txt с использованием FileInputStream.
        Файл должен находиться в том же пакете (папке) где будет запускаться ваша программа.
        Содержимое файла надо вывести в консоль.
        Использовать абсолютный путь к файлам запрещено.
        Задание не будет засчитано если преподавать запустить вашу программу, а путь до файла будет указан как на вашем компьютере.
        Ваша программа должна работать на любом компьютере, у любого человека не зависимо от расположения файла (его пути).
         */

        String baseUrl = System.getProperty("user.dir");
        File file = new File(baseUrl + "/src/variant2.txt");
        FileInputStream fileInput;

        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            byte[] buffer = new byte[fileInput.available()];
            fileInput.read(buffer, 0, fileInput.available());
            System.out.println("File:");
            for (int i = 0; i < buffer.length; i++) {
                System.out.print((char) buffer[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInput.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void task2() {
        /*
        Создать программу для записи переменной array в текстовый файл task2.txt с использованием ByteArrayOutputStream и FileInputStream.
        Файл должен находиться в том же пакете (папке) где будет запускаться ваша программа.
        Содержимое файла надо вывести в консоль.
        Использовать абсолютный путь к файлам запрещено.
        Задание не будет засчитано если преподавать запустить вашу программу, а путь до файла будет указан как на вашем компьютере.
        Ваша программа должна работать на любом компьютере, у любого человека не зависимо от расположения файла (его пути).
         */
        String text = "Hello java!";
        byte[] array = text.getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            outputStream.write(array);

            FileOutputStream fileOutputStream = new FileOutputStream("src/task2.txt");
            outputStream.writeTo(fileOutputStream);
            fileOutputStream.close();
            outputStream.close();

            FileInputStream fileInputStream = new FileInputStream("src/task2.txt");
            int i;
            while ((i = fileInputStream.read()) != -1) {
                System.out.print((char) i);
            }
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> deserialize(String fileName) {
        /*
    История:
    Динамический массив Employee был сериализован в employee.dat. На момент сериализации у класса Employee параметр
    age был отмечен как transient

    Задача:
    Выполнить десериализацию файла employee.dat в динамический массив (список) с типом Employee.
    Использовать абсолютный путь к файлам запрещено.
    Задание не будет засчитано если преподаватель запустить вашу программу, а путь до файла будет указан как на вашем
    компьютере.
    Ваша программа должна работать на любом компьютере, у любого человека не зависимо от расположения файла (его пути).
    Переопределить метод toString класса Employee
    serialVersionUID класса Employee равен -4364626656486808842
    В цикле forEach вывести все значения параметров каждого клиента.
     */

        List<Employee> employees = new ArrayList<>();
        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream(new FileInputStream(fileName));
            employees = (List<Employee>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return employees;
    }

    public static void task3() {

        Employee employee = new Employee("Andrey", "Ivanov", 30);
        Employee employee1 = new Employee("Ivan", "Petrov", 28);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);

        ObjectOutputStream dataOutputStream = null;

        try {
            dataOutputStream = new ObjectOutputStream(new FileOutputStream("src/employee.dat"));
            dataOutputStream.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        List<Employee> employees1 = deserialize("src/employee.dat");

        for (Employee empl : employees1) {
            System.out.println(empl);
        }
    }
}