package pl.edu.wszib.wielowatkowosc.wyszukiwanie;

import java.util.Random;

public class MinFinder implements Runnable {
    private int[] tab;
    private int startIndex;
    private int endIndex;

    public MinFinder(int[] tab, int startIndex, int endIndex) {
        this.tab = tab;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(int i = this.startIndex; i < this.endIndex; i++) {
            this.tab[i] = random.nextInt();
        }

        int min = this.tab[this.startIndex];
        for(int i = this.startIndex; i < this.endIndex; i++) {
            if(tab[i] < min) {
                min = tab[i];
            }
        }

        synchronized(App2.partialResults) {
            App2.partialResults.add(min);
        }
    }
}
