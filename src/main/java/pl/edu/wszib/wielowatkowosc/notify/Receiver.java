package pl.edu.wszib.wielowatkowosc.notify;

public class Receiver implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Odbiorca sie odpala !!");
            System.out.println("Odbiorca czeka !!");
            synchronized (App.communicationChannel) {
                while(!App.notificationConfirmation) {
                    App.communicationChannel.wait();
                }
            }
            System.out.println(App.message);
            System.out.println("Odbiorca odebral notyfikacje !!");
        } catch (InterruptedException e) {
            System.out.println("zepsulo sie !!");
        }
    }
}
