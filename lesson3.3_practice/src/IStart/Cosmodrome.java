package IStart;

public class Cosmodrome {
    void launch(IStart iStart) {
        if (iStart.preLaunchSystemCheck()) {
            iStart.startingEngines();
            countDown();
            iStart.start();
        } else {
            System.out.println("Предстартовая проверка провалена");
        }
    }

    private void countDown() {
        for (int i = 10; i >= 1; i--) {
            System.out.println("Обратный отсчёт: " + i);
        }
    }
}
