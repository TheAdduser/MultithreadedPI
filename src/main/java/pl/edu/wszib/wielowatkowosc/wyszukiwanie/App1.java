package pl.edu.wszib.wielowatkowosc.wyszukiwanie;

import java.util.Random;

public class App1 {
    public static void main(String[] args) {
        int[] tab = new int[1000000000];

        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for(int i = 0; i < tab.length; i++) {
           tab[i] = random.nextInt();
        }

        int min = tab[0];
        for(int element : tab) {
            if(element < min) {
                min = element;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(min);
        System.out.println(endTime - startTime);
    }
}
