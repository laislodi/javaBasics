package useacabecajava.beatbox.parte4aclienteservidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }

    private void go() {
        try {
            Socket socket = new Socket("127.0.0.1",4242);

            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String advice = reader.readLine();
            System.out.println("Today you should: " + advice);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
