package pl.edu.wszib.wielowatkowosc.notify;

public class Sender implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Nadawca cos robi !!");
            Thread.sleep(1000);
            System.out.println("Nadawca dalej cos robi !!");
            Thread.sleep(1000);
            System.out.println("Nadawca nadal cos robi !!");
            Thread.sleep(1000);
            System.out.println("Nadawca wysyla !!");
            synchronized (App.communicationChannel) {
                App.notificationConfirmation = true;
                App.message = "Wiadomosc jakas !!";
                App.communicationChannel.notify();
            }
            System.out.println("Nadawca wyslal !!");
        } catch (InterruptedException e) {
            System.out.println("zepsulo sie !!");
        }
    }
}
