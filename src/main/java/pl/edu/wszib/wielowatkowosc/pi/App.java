package pl.edu.wszib.wielowatkowosc.pi;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        int allPoints = 2000000000;
        int pointsInCircle = 0;

        long startTime = System.currentTimeMillis();

        Random random = new Random();
        for (int i = 0; i < allPoints; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();

            double distanceFromCenter = Math.sqrt(x * x + y * y);

            if (distanceFromCenter < 1) {
                pointsInCircle++;
            }
        }

        long endTime = System.currentTimeMillis();
        double pi = ((double) pointsInCircle * 4) / ((double) allPoints);

        System.out.println("Pi: " + pi);
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }
}
