public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        /*
        Создать новый класс для потока через наследование от класса Thread.
        Переопределить метод run.
        В переопределённом методе run выводить в консоль имя текущего потока задом наперёд и его id.
        В переопределённом методе run должен быть слип на пол секунды.
        Создать динамический массив потоков и запустить их в цикле в порядке возрастания.
        Потоки должны запускаться не хаотично, а строго по порядку. Сначала самый первый, потом второй и т.д
         */

        User[] threads = new User[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new User(i);

        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void task2() {
        /*
        У нас есть микросервисное приложение, в котором есть класс DatabaseService, отвечающий за операции с базой данных.
        Так же есть класс ClientService, который обрабатывает данные из базы данных и показывает их конечному пользователю
        в понятном виде.
        Вам необходимо разработать программу, которая позволяет запускать эти сервисы в разных потоках.
        Поток для работы с базой данных должен иметь возможность получать данные из потока для работы с клиентом.
        Поток для работы с клиентом должен получать данные от потока для работы с базой данных.

        В результате у вас должно получиться улучшенное микросервисное приложение, которое может запускать сервисы в
        разных потоках и каждый из сервисов может перехватывать сообщения друг друга.

         */

        DatabaseService databaseService = new DatabaseService("Client's data");
        ClientService clientService = new ClientService("Database's data", databaseService);
        Thread databaseThread = new Thread(databaseService);
        Thread clientThread = new Thread(clientService);

        databaseThread.start();
        clientThread.start();
    }

    public static void task3() {
        /*
        Существует программа, которая заполняет в несколько потоков clientId каким то числовым значением.
        Программа должна в 7 потоков заполнить clientId.
        В классе UserThread в методе run clientId должен быть установлен для каждого потока 5 раз.
        В методе run clientId должен добавлять +1 к текущему clientId на каждой итерации цикла.
        В результате у вас должно быть 5 значение клиент Id для каждого потока.

        Ваша задача исправить программу так, что бы она соответствовала условиям выше.
        Текущая версия программы создаёт больше 7 потоков, может записать значение параметра clientId одного потока в
        clientId другого потока.
        Так же, для каждого потока, программа записывает clientId больше чем 5 раз.
        Для решения задачи запрещено использовать оператор ReentrantLock и метод join()

        Ниже представлен код программы
        }

        Client client = new Client();
        for (int i = 0; i < 16; i++) {
            Thread thread = new Thread(new UserThread(client));
            thread.setName("Thread with index " + i);
            thread.start();
            */

        Client client = new Client();
        for (int i = 0; i < 7; i++) {
            Thread thread = new Thread(new UserThread(client));
            thread.setName("Thread with index " + i);
            thread.start();
        }
    }
}