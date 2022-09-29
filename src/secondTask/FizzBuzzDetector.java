package secondTask;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzDetector {
    Queue<Integer> startQueue;
    Queue<String> resultQueue;

    public FizzBuzzDetector(int n) {
        startQueue = IntStream.range(1, n + 1).boxed().collect(Collectors.toCollection(ConcurrentLinkedQueue::new));
        resultQueue = new ConcurrentLinkedQueue<>();
    }


    public synchronized void fizz() throws InterruptedException {
        while (!startQueue.isEmpty()) {
            if (startQueue.peek() % 3 == 0 && startQueue.peek() % 5 != 0) {

                resultQueue.add("fizz");
                startQueue.poll();

                notifyAll();
            } else {
                wait();
            }
        }
    }


    public synchronized void buzz() throws InterruptedException {
        while (!startQueue.isEmpty()) {
            if (startQueue.peek() % 3 != 0 && startQueue.peek() % 5 == 0) {

                resultQueue.add("buzz");
                startQueue.poll();

                notifyAll();
            } else {
                wait();
            }
        }
    }


    public synchronized void fizzbuzz() throws InterruptedException {
        while (!startQueue.isEmpty()) {
            if (startQueue.peek() % 15 == 0) {

                resultQueue.add("fizzbuzz");
                startQueue.poll();

                notifyAll();
            } else {
                wait();
            }
        }
    }


    public synchronized void number() throws InterruptedException {
        while (!startQueue.isEmpty()) {
            if (startQueue.peek() % 3 != 0 && startQueue.peek() % 5 != 0) {

                resultQueue.add(startQueue.peek().toString());
                startQueue.poll();

                notifyAll();
            } else {
                wait();
            }
        }
        System.out.println(resultQueue);

    }
}
