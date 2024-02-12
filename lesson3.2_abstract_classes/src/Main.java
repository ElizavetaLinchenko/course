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
        Apple apple = new Apple(1.5);
        Pear pear = new Pear(2);
        Apricot apricot = new Apricot(3.5);

        double totalCost = apple.getCost() + pear.getCost() + apricot.getCost();
        System.out.println("Total cost of fruits cost - " + totalCost);
    }
}