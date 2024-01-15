package pl.edu.wszib.wielowatkowosc.wyszukiwanie;

import java.util.ArrayList;
import java.util.List;

public class App2 {

    public static final List<Integer> partialResults = new ArrayList<>();

    public static void main(String[] args) {
        int[] tab = new int[1000000000];
        int threadNumber = 8;
        Thread[] threads = new Thread[threadNumber];
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < threadNumber; i++) {
            threads[i] = new Thread(new MinFinder(
                    tab,
                    i * (tab.length / threadNumber),
                    (i + 1) * (tab.length / threadNumber)));
            threads[i].start();
        }

        try {
            for (int i = 0; i < threadNumber; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("Zepsulo sie !!");
        }

        int globalMin = partialResults.get(0);
        for(int element : partialResults) {
            if(element < globalMin) {
                globalMin = element;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println(globalMin);
        System.out.println(endTime - startTime);
    }
}
