package useacabecajava.beatbox.parte2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Runner runner = new Runner();
        SumListener sumListener = new SumListener();
        PrintListener printListener = new PrintListener();

        runner.listeners.add(sumListener);
        runner.listeners.add(printListener);

        runner.runAll();
        System.out.println("soma total:");
        System.out.println(sumListener.sum);
    }

    List<Listener> listeners = new ArrayList<>();

    void runAll() {
        Scanner sc = new Scanner(System.in);

        boolean stop = false;
        while (!stop) {
            String line = sc.nextLine();

            double random = Math.random();
            if (random >= 0.5) {
                for (Listener listener : listeners) {
                    listener.listen(random);
                }
            }

            stop = line.isEmpty();
        }
    }
}
