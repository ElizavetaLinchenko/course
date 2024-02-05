import java.util.Random;

public class Lesson3 {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    static void task1() {
 /*
        Объявить три переменные типа int и присвоить первой числовое значение,
        вторая переменная равна первой переменной увеличенной на 3,
        а третья переменная равна сумме первых двух.
         */

        int firstVariable = 2;
        int secondVariable = firstVariable + 3;
        int thirdVariable = firstVariable;
        thirdVariable += secondVariable;
        System.out.println("Переменная 1 : " + firstVariable + "\nПеременная 2 : "
                + secondVariable + "\nПеременная 3 : " + thirdVariable);
    }

    static void task2() {
/*
        Создайте массив из 15 случайных целых чисел из отрезка [0;9].
        Выведите массив на экран.
        Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на отдельной строке.
         */

        int[] arrayNumber = new int[15];
        Random num = new Random();
        int count = 0;

        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = num.nextInt(10);
            System.out.print(arrayNumber[i] + " ");
            int evenNumbers = arrayNumber[i] % 2;
            if (evenNumbers == 0) {
                count += 1;
            }
        }
        System.out.println("\nКоличество четных элементов - " + count);
    }

    static void task3() {
/*
        Создать двумерный массив из 8 строк по 5 столбцов в каждой из случайных целых чисел из отрезка [10;99].
        Вывести массив на экран.
         */

        int[][] twoDimensionalArray = new int[8][5];
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                twoDimensionalArray[i][j] = (int) (Math.random() * 90) + 10;
                System.out.print(twoDimensionalArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}









