package pl.edu.wszib.wielowatkowosc.notify;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public final static Object communicationChannel = new Object();
    public static boolean notificationConfirmation = false;

    public static String message = null;

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        executorService.schedule(new Receiver(), 0, TimeUnit.SECONDS);
        executorService.schedule(new Sender(), 5, TimeUnit.SECONDS);

        executorService.shutdown();
    }
}
