import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class SumCalculator {
    private final int number;
    private int sum;
    public SumCalculator(int number) {
        this.number = number;
    }
    public void calculateSum() {
        int n = number / 5;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new SumWorker(1, 1 + n));
        executor.execute(new SumWorker(2 + n,  2 + 2 * n));
        executor.execute(new SumWorker(3 + 2 * n, 3 + 3 * n));
        executor.execute(new SumWorker(4 + 3 * n, 4 + 4 * n));
        executor.execute(new SumWorker(5  + 4 * n, number - 1));

        executor.shutdown();
        while (!executor.isTerminated()) {}
        System.out.println("The sum of all numbers from 1 to " + number + " is " + sum);
    }
    private class SumWorker extends Thread implements Runnable {
        private final int start;
        private final int end;
        public SumWorker(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public void run() {
            try {
                int tempSum = 0;
                for (int i = start; i <= end; i++) {
                    tempSum += i;
                }
                sum += tempSum;
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}