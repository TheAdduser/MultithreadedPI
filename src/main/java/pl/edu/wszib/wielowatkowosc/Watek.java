package pl.edu.wszib.wielowatkowosc;

public class Watek extends Thread {

    private int threadNumber;

    public Watek(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000; i++) {
            System.out.println(this.threadNumber + " I:" + i);
        }
    }
}
