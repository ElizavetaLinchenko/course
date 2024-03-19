import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
        Создать абстрактный класс Фрукт и классы Яблоко, Груша, Абрикос расширяющие его.
        Класс Фрукт содержит:
        а) переменную вес,
        б) завершенный метод printManufacturerInfo(){System.out.print("Made in Ukraine");}
        в) абстрактный метод, возвращающий стоимость фрукта, который должен быть переопределен в каждом классе наследнике.
        Метод должен учитывать вес фрукта.
        Создать несколько объектов разных классов.
        Подсчитать общую стоимость проданных фруктов.
     */

    public static void main(String[] args) {
        Fruit[] fruit = new Fruit[3];

        Apple apple = new Apple(1.5);
        Pear pear = new Pear(2);
        Apricot apricot = new Apricot(3.5);

        fruit[0] = apple;
        fruit[1] = pear;
        fruit[2] = apricot;

        double totalCost = 0;

        for (Fruit fruit1 : fruit) {
            totalCost += fruit1.getCost();
        }
        System.out.println("Total cost of fruits cost - " + totalCost);
    }
}