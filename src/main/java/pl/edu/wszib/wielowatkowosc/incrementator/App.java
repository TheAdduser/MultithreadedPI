package pl.edu.wszib.wielowatkowosc.incrementator;

public class App {
    public static int counter = 0;
    public static final Object lock = new Object();

    public static void main(String[] args) {
        IncrementatorTool incrementatorTool = new IncrementatorTool();
        Thread t1 = new Thread(new IncrementatorThread(incrementatorTool));
        Thread t2 = new Thread(new IncrementatorThread(incrementatorTool));
        Thread t3 = new Thread(new IncrementatorThread(incrementatorTool));
        Thread t4 = new Thread(new IncrementatorThread(incrementatorTool));
        Thread t5 = new Thread(new IncrementatorThread(incrementatorTool));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            System.out.println("Cos sie zepsulo !!");
        }

        System.out.println(counter);
    }
}
