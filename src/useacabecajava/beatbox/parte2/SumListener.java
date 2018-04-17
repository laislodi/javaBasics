package useacabecajava.beatbox.parte2;

public class SumListener implements Listener {

    double sum = 0.0;

    @Override
    public void listen(double rand) {
        sum += rand;
    }
}
