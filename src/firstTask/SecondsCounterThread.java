package firstTask;

public class SecondsCounterThread extends Thread {

    private long seconds = 1L;

    @Override
    public void run() {

        System.out.println(" Пройшло " + seconds + " секунд від запуску програми");
        seconds++;
    }
}