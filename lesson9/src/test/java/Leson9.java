import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Leson9 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
         /*
         Определить реализацию метода IFunction интерфейса с использованием lambda-выражения.
         В реализации метода должно быть умножение первой переменной на вторую.
         Результат вывести в консоль.
         */

        IFunction function = (x, y) -> {
            int result = x * y;
            return result;
        };

        int val = function.geResult(2, 3);
        System.out.println("Результат: " + val);
    }

    public static void task2() {
        /*
        Создать функциональный интерфейс IBox с одним методом List<HeavyBox> checkWeight(List<HeavyBox> boxes);
        Создать коллекцию, содержащую объекты HeavyBox.
        Определить реализацию метода checkWeight интерфейса IBox с использованием lambda-выражения.
        Реализация должна перебирать элементы коллекции и проверять вес коробок.
        Если вес коробки больше 300 гр, коробка перемещается в другую коллекцию.
        Метод должен возвращать коллекцию с коробками весом больше 300 гр
        Содержимое коллекции с коробками весом больше 300 гр вывести в консоль.
         */

        List<HeavyBox> boxes = new ArrayList<>();
        boxes.add(new HeavyBox(100));
        boxes.add(new HeavyBox(300));
        boxes.add(new HeavyBox(400));
        boxes.add(new HeavyBox(500));
        boxes.add(new HeavyBox(600));

        IBox box = (List<HeavyBox> boxList) -> {
            List<HeavyBox> heavyBoxes = new ArrayList<>();
            for (HeavyBox heavyBox : boxList) {
                if (heavyBox.getWeight() > 300) {
                    heavyBoxes.add(heavyBox);
                }
            }
            return heavyBoxes;
        };

        List<HeavyBox> heavyBoxes = box.checkWeight(boxes);

        for (HeavyBox heavyBox : heavyBoxes) {
            System.out.println(heavyBox.getWeight());
        }
    }

    public static void task3() {
        /*
        Создать динамический массив HeavyBox, в котором будут HeavyBox с весами, 200, 300, 400 и 500.
        Создать функцию перехода от объекта типа Integer к объекту типа HeavyBox.
        Function должен проверять вес HeavyBox, если больше 300, то создавать новый HeavyBox с тем весом который
        проверялся на условие больше 300.
        Этот же объект должен быть возвращён.
        Если же вес HeavyBox не больше 300, то создать новый HeavyBox с весом 10 и вернуть его.
        Запустить Function для каждого элемента динамического массива.
         */

        List<HeavyBox> heavyBoxes = new ArrayList<>();
        List<Integer> weights = new ArrayList<>();
        weights.add(200);
        weights.add(300);
        weights.add(400);
        weights.add(500);

        Function<Integer, HeavyBox> function = (weight) -> {
            if (weight > 300) {
                return new HeavyBox(weight);
            } else {
                return new HeavyBox(10);
            }
        };

        for (Integer weight : weights) {
            HeavyBox heavyBox = function.apply(weight);
            heavyBoxes.add(heavyBox);
        }

        for (HeavyBox heavyBox : heavyBoxes) {
            System.out.println(heavyBox);
        }
    }
}