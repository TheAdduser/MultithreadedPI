package pl.edu.wszib.wielowatkowosc.incrementator;

public class IncrementatorThread implements Runnable {

    private final IncrementatorTool incrementatorTool;

    public IncrementatorThread(IncrementatorTool incrementatorTool) {
        this.incrementatorTool = incrementatorTool;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            /*synchronized (App.lock) {
                App.counter++;
            }*/
            this.incrementatorTool.increment();
        }
    }
}
