package pl.edu.wszib.wielowatkowosc.pi;

import java.util.Random;

public class App2 {
    public static void main(String[] args) {
        int allPoints = 2000000000;
        final int[] pointsInCircle = {0};
        int threadCount = Runtime.getRuntime().availableProcessors();
        int pointsPerThread = allPoints / threadCount;

        Thread[] threads = new Thread[threadCount];

        long startTime = System.currentTimeMillis();

        for (int t = 0; t < threadCount; t++) {
            threads[t] = new Thread(() -> {
                Random random = new Random();

                int localPointsInCircle = 0;
                for (int i = 0; i < pointsPerThread; i++) {
                    double x = random.nextDouble();
                    double y = random.nextDouble();

                    double distanceFromCenter = Math.sqrt(x * x + y * y);

                    if (distanceFromCenter < 1) {
                        localPointsInCircle++;
                    }
                }

                synchronized (App.class) {
                    pointsInCircle[0] += localPointsInCircle;
                }
            });

            threads[t].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        double pi = ((double) pointsInCircle[0] * 4) / ((double) allPoints);

        System.out.println("Pi: " + pi);
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }
}
