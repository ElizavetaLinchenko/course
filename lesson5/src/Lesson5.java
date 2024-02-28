import java.util.*;

public class Lesson5 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        HashSet<Map.Entry<String, String>> set = new HashSet<>();
        set.add(new Item("k1", "v1"));
        set.add(new Item("k1", "v2"));
        set.add(new Item("k2", "v1"));
        /*
        Сделайте HashMap из HashSet<Map.Entry<K, V>>
        Ответ запишите ниже */
        HashMap<String, String> hashMap = new HashMap<>();
        for (Map.Entry<String, String> entry : set) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
    }

    public static void task2() {
        /*
        Создать очередь, содержащую объекты класса HeavyBox.
        Используем класс ArrayDeque.
        Поместить объекты в очередь с помощью метода offer().
        Удалить все объекты методом poll().
         */
        Queue<HeavyBox> queue = new ArrayDeque<>();
        HeavyBox box1 = new HeavyBox(5);
        HeavyBox box2 = new HeavyBox(10);
        HeavyBox box3 = new HeavyBox(15);

        queue.add(box1);
        queue.add(box2);
        queue.add(box3);

        while (!queue.isEmpty()) {
            HeavyBox removedBox = queue.poll();
            System.out.println("Удаление: " + removedBox.getWeight());
        }
    }

    public static void task3() {
        /*
        Создать динамический массив, содержащий объекты класса HeavyBox.
        Переопределить метод toString у HeavyBox
        Распечатать его содержимое используя for each и метод toString.
        Изменить вес первого ящика на 10.
        Удалить предпоследний ящик.
        Получить массив содержащий ящики из коллекции двумя способами и вывести на консоль. Использовать java stream api запрещено
        Удалить все ящики.
         */
        ArrayList<HeavyBox> boxes = new ArrayList<>();
        boxes.add(new HeavyBox(3));
        boxes.add(new HeavyBox(10));
        boxes.add(new HeavyBox(15));

        for (HeavyBox box : boxes) {
            System.out.println("Вес" + " " + box.getWeight() + " " + box.toString());
        }

        HeavyBox box1 = boxes.get(0);
        box1.setWeight(box1.getWeight() + 10);

        int removingBox = boxes.size() - 2;
        boxes.remove(removingBox);

        List<HeavyBox> boxArray1 = new ArrayList<>(boxes);

        HeavyBox[] boxArray2 = new HeavyBox[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            boxArray2[i] = boxes.get(i);
        }

        for (HeavyBox box : boxArray1) {
            System.out.println(box.getWeight());
        }

        for (HeavyBox box : boxArray2) {
            System.out.println(box.getWeight());
        }

        boxes.clear();
    }
}