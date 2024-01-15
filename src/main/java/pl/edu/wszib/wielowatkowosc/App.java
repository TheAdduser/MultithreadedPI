package pl.edu.wszib.wielowatkowosc;

public class App {
    public static void main(String[] args) {
        /*Thread w = new Watek(1);
        w.start();
        Thread w2 = new Watek(2);
        w2.start();
        Thread w3 = new Watek(3);
        w3.start();
        Thread w4 = new Watek(4);
        w4.start();*/

        Thread lepszyWatek1 = new Thread(new LepszyWatek());
        Thread lepszyWatek2 = new Thread(new LepszyWatek());
        Thread lepszyWatek3 = new Thread(new LepszyWatek());
        Thread lepszyWatek4 = new Thread(new LepszyWatek());

        lepszyWatek1.start();
        lepszyWatek2.start();
        lepszyWatek3.start();
        lepszyWatek4.start();

        System.out.println("Koniec programu !!");
    }
}
