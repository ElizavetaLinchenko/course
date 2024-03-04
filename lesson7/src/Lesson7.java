import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson7 {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        /*
        Разделите слова java, test и string пробелами для переменной buffer.
        Результат запишите в обратном порядке
        Результат в обратном порядке вывести в консоль
         */

        StringBuffer buffer = new StringBuffer("javateststring");
        buffer.insert(4, " ");
        buffer.insert(9, " ");
        buffer.reverse();
        System.out.println(buffer);
    }

    public static void task2() {
        /*
        Найти фрагмент Java software в тексте переменной text с использованием регулярных выражений.
        Найденный фрагмент текста вывести в консоль в обратном порядке.
         */

        String text = "The Java Virtual Machine is only one part of Java software that is involved in running an application.";
        Pattern pattern = Pattern.compile("Java software");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String foundText = matcher.group();
            String reversedText = (new StringBuilder(foundText)).reverse().toString();
            System.out.println(reversedText);
        }
    }

    public static void task3() {
        /*
        Записать каждое слово параметра text в value Map. Ключ мапы это позиция слова в предложении.
        К примеру, первое слов The, у него позиция 1, значит в мапе это будет как ключ 1, а значение The.
        У слова Java позиция 2, значил ключ 2, значение Java и дальше по аналогии.
        В конце заполненную мапу вывести в консоль.
         */

        String text = "The Java Runtime Environment (JRE) version 8 is what you get when you download Java software from java.com.";
        String[] array = text.split(" ");
        Map<Integer, String> valueMap = new HashMap();

        for (int i = 0; i < array.length; ++i) {
            valueMap.put(i + 1, array[i]);
        }

        System.out.println(valueMap);
    }
}