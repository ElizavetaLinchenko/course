import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        /*
        Создать класс Product с приватным параметром name и гетер и сеттер для него.
        Создать динамический массив из объектов Product.
        Массив должен содержать минимум 4 продукта, название для продуктов придумайте сами.
        Замените название последнего проекта на название первого проекта.
        С помощью Stream API в одной цепочки вызовов методов одного стрима выполните отображение (маппинг) имени проекта,
        удалите все дубликаты и выведите каждое имя проекта в обратном порядке.
         */

        List<Product> products = new ArrayList<>();
        products.add(new Product("Apple"));
        products.add(new Product("Pineapple"));
        products.add(new Product("Watermelon"));
        products.add(new Product("Orange"));

        products.get(products.size() - 1).setName(products.get(0).getName());

        products.stream()
                .map(Product::getName)
                .distinct()
                .map(str -> new StringBuilder(str).reverse().toString())
                .collect(Collectors.toList())
                .forEach(product -> {
                    System.out.println(product);
                });
    }

    public static void task2() {
        /*
        Создать класс Product с приватным параметром name и гетер и сеттер для него.
        Создать динамический массив из объектов Product.
        Массив должен содержать минимум 1000 продуктов, название для продуктов придумайте сами.
        Замените название последнего проекта на название первого проекта.
        Создайте еще один массив Product, который будет содержать 1000 продуктов.
        Создайте потоки этих двух массивов.
        Объедините элементы двух потоков, возвращая объединенный поток.

        В возвращённом объединенном потоке примените плоское отображение.

        Плоское отображение должно выполнить выборку первых 777 продуктов первого потока и первых 777 продуктов второго
        потока. И верните модифицированный поток.
        Выполните приведение модифицированного потока к коллекции выведите результат в консоль.

        В результате у вас будет список из двух проектов, размер каждого списка будет 777.
         */

        List<Product> productList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Product product = new Product("Product " + i);
            productList.add(product);
        }
        if (!productList.isEmpty()) {
            if (productList.get(0) != null) {
                Product firstProduct = productList.get(0);
                if (productList.lastIndexOf(productList) != -1) {
                    Product lastProduct = productList.get(productList.lastIndexOf(productList));
                    lastProduct.setName(firstProduct.getName());
                }
            }
            List<Product> secondProductlist = new ArrayList<>();

            for (int i = 0; i < 1000; i++) {
                Product product = new Product("Product " + i);
                secondProductlist.add(product);
            }
            Stream<Product> stream1 = productList.stream();
            Stream<Product> stream2 = secondProductlist.stream();
            Stream<Product> commonStream = Stream.concat(stream1, stream2);
            commonStream
                    .flatMap(stream -> (
                            Stream.of(
                                            String.format("First stream %s", stream.getName()),
                                            String.format("Second stream %s", stream.getName()))
                                    .limit(777)))
                    .collect(Collectors.toList())
                    .forEach(product -> {
                        System.out.println(product);
                    });
        }
    }

    public static void task3() {
        /*
        Создать динамический массив из объектов Product.
        Массив должен содержать минимум 4 продукта, название для продуктов придумайте сами.
        С помощью Stream API выполните сложение имён проектов с условием, что каждый проект должен разделяться запятой
        с пробелом ', '.
        Сложение должно выполняться наоборот, сначала последний проект прибавляется к предпоследнему, потом к предпоследнему
        прибавляем второй и так по аналогии.
        Выполните приведение reduce к строке через метод get и вывести результат в косноль.
         */

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Carrot"));
        productList.add(new Product("Tomato"));
        productList.add(new Product("Cucumber"));
        productList.add(new Product("Cabbage"));

        String resultList = productList.stream()
                .map(Product::getName)
                .reduce((a, b) -> b + ", " + a)
                .get();

        System.out.println(resultList);
    }
}