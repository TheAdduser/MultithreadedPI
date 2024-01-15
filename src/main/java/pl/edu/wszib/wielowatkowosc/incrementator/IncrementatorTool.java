package pl.edu.wszib.wielowatkowosc.incrementator;

public class IncrementatorTool {

    public synchronized void increment() {
        App.counter++;
    }
}
