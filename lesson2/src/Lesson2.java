
public class Lesson2 {


    public static void main(String[] args) {
        task1();
        task2();
        task3();


    }

    static void task1() {
        /*
        Создать программу, в которой вывести на консоль литералы следующих видов:

            логический
            строковый
            символьный
            целочисленный 2-й
            целочисленный 8-й
            целочисленный 10-й
            целочисленный 16-й
            литерал типа float
            литерал типа double.

         */
        boolean logicLiteral = true;
        System.out.println("логический - " + logicLiteral);

        String stringLiteral = "Hello";
        System.out.println("строковый - " + stringLiteral);

        char charLiteral = 'J';
        System.out.println("символьный - " + charLiteral);

        int binaryLiteral = 0b1001;
        System.out.println("целочисленный 2-й - " + binaryLiteral);

        int octalLiteral = 012;
        System.out.println("целочисленный 8-й - " + octalLiteral);

        int decimalLiteral = 25;
        System.out.println("целочисленный 10-й - " + decimalLiteral);

        int hexadecimal = 0xC;
        System.out.println("целочисленный 16-й - " + hexadecimal);

        float floatLiteral = 3.14f;
        System.out.println("float - " + floatLiteral);

        double doubleLiteral = 2.15d;
        System.out.println("double - " + doubleLiteral);

    }


    static void task2() {
        /*

                    byte	short	char	int	    long	float	double	boolean
        ______________________________________________________________________________
        byte	   |   т  |   ня   |   я   |  ня  |  ня   |   ня   |   ня  |   х   |
        ------------------------------------------------------------------------------
        short	   |   я  |    я   |   ня  |  ня  |   ня  |   ня   |    х  |   х   |
        ------------------------------------------------------------------------------
        char	   |   я  |    я   |    т  |  ня  |   ня  |   ня   |   ня  |   х   |
        ------------------------------------------------------------------------------
        int	 	   |   я  |    я   |    я  |   т  |   ня  |   ня   |   ня  |   х   |
        ------------------------------------------------------------------------------
        long	   |   я  |    я   |    я  |   я  |    т  |   ня   |   ня  |   х   |
        ------------------------------------------------------------------------------
        float	   |   я  |    я   |    я  |   я  |    я  |    т   |   ня  |   х   |
        ------------------------------------------------------------------------------
        double	   |   я  |    я   |    я  |   я  |    я  |    я   |    т  |   х   |
        ------------------------------------------------------------------------------
        boolean	   |   х  |    х   |    х  |   х  |    х  |    х   |    х   |  т   |
        ------------------------------------------------------------------------------

         */
    }

    static void task3() {
        /*
        В переменной a хранится вещественное число с ненулевой дробной частью.
        Создайте программу, округляющую число a до ближайшего целого и выводящую результат на экран.
         */

        double a = 44.44;
        int roundedNumber = (int) Math.round(a);
        System.out.println(roundedNumber);
    }
}





