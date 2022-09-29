package secondTask;


public class SecondTask {
    public static void main(String[] args) {
        FizzBuzzDetector fizzBuzz = new FizzBuzzDetector(15);

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }
}
