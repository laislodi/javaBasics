package useacabecajava.beatbox.parte4aclienteservidor;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

    private String[] adviceList = {"Morda pedaços menores.","Use o jeans apertado. NÃO, ele não faz você parecer gorda.",
        "Só vou dizer uma palavra: INAPROPRIADO.","Pelo menos hoje, seja honesta. Diga a seu chefe o que você realmente pensa.",
        "Reconsidere esse corte de cabelo."};

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }

    private void go() {
        try {
            ServerSocket server = new ServerSocket(4242);

            while (true) {
                Socket socket = server.accept();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }
}
