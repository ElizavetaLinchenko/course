public class Tasks {
    void task1() {
      /*
        Вам надо разработать 1 feature file под сценарий, который я описал ниже.
        Шаги:
         - Развернуть окно браузера на весь экран
         - Перейдите на сайт https://www.jenkins.io/
         - Проверить, что формат картинки в карусели .png (На скрине img_1 вы найдёте под пунктом 1 картинку из этого шага).

         После разработки feature file вам надо реализовать все шаги с логикой к этому feature file.
         Не забудьте запустить свой тест, что бы проверить его. Запуск должен быть через отдельный класс раннер, RunnerTaskVariant1.
         Класс RunnerTaskVariant1 с всеми настройками вы должны создать самостоятельно.
         */
    }

    void task2() {
        /*
        Вам надо разработать 1 feature file под сценарий, который я описал ниже.
        Шаги:
         - Развернуть окно браузера на весь экран
         - Перейдите на сайт https://rest-assured.io/
         - В навбаре кликнуть по вкладке 'DOCS' (На скрине img_3 вы найдёте под пунктом 1 элемент из этого шага).
         - Кликнуть по ссылке 'Getting Started' в меню слева (На скрине img_3 вы найдёте под пунктом 2 элемент из этого шага).
         - Проверить, что текст 'GettingStarted' виден (На скрине img_2 вы найдёте под пунктом 1 элемент из этого шага).
         - Проверить, что текущий url https://github.com/rest-assured/rest-assured/wiki/GettingStarted

         Подсказка, с кликом по Getting Started могут быть проблемы, вам поможет клик через JS.
         Я подскажу какой класс надо использовать и метод, но уже как сделать клик через JS вам надо будет самостоятельно поискать.

         Используйте интерфейс JavascriptExecutor и метод executeScript, в этот метод вам надо передать нужный скрипт и элемент.

         После разработки feature file вам надо реализовать все шаги с логикой к этому feature file.
         Не забудьте запустить свой тест, что бы проверить его. Запуск должен быть через отдельный класс раннер, RunnerTaskVariant1.
         Класс RunnerTaskVariant1 с всеми настройками вы должны создать самостоятельно.
         */
    }

    void task3() {
      /*
        Вам надо разработать 1 feature file под сценарий, который я описал ниже.
        Шаги:
         - Развернуть окно браузера на весь экран
         - Перейдите на сайт https://rest-assured.io/
         - В навбаре кликнуть по вкладке 'DOCS' (На скрине img_3 вы найдёте под пунктом 1 элемент из этого шага).
         - Кликнуть по ссылке 'Downloads' в меню слева (На скрине img_3 вы найдёте под пунктом 3 элемент из этого шага).
         - Проверить, что текст 'Downloads' виден (На скрине img_4 вы найдёте под пунктом 1 элемент из этого шага).
         - Проверить, что текущий url https://github.com/rest-assured/rest-assured/wiki/Downloads
         - Проверить, что таблица аттрибутов содержит 2 колонки и 8 рядов (без учёта ряда заголовка) (На скрине img_4 вы найдёте под пунктом 2 таблицу из этого шага).

         Подсказка, с кликом по Downloads могут быть проблемы, вам поможет клик через JS.
         Я подскажу какой класс надо использовать и метод, но уже как сделать клик через JS вам надо будет самостоятельно поискать.

         Используйте интерфейс JavascriptExecutor и метод executeScript, в этот метод вам надо передать нужный скрипт и элемент.

         После разработки feature file вам надо реализовать все шаги с логикой к этому feature file.
         Не забудьте запустить свой тест, что бы проверить его. Запуск должен быть через отдельный класс раннер, RunnerTaskVariant1.
         Класс RunnerTaskVariant1 с всеми настройками вы должны создать самостоятельно.
         */
    }

    void task4() {
        /*
        Для вас создан enum Colors, который имеет 4 значения.
        Задача, написать тест с использованием датапровайдера JUnit5.
        Тест должен запускаться 2 раза для RED, WHITE и проверять, что значения цвета не пустое.
         */
    }

    void task5() {
        /*
        Создайте тест сценарий с использованием cucumber.
        К этому сценарию вам надо создать датапровайдер с двумя наборами данных.
        Первый набор будет иметь числа 10 и 20.
        Второй набор будет иметь числа 5 и 16.
        Напишите, единственный шаг к этому сценарию, в котором будет проверка, что число из первой колонки, больше числа из второй колонки.
        В результате у вас будет сценарий выполняться 2 раза.
        Первый раз сценарий будет проверять, что 10 больше 20. Второй раз, что 5 больше 16.
         */
    }
}