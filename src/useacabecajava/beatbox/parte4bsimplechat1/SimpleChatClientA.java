package useacabecajava.beatbox.parte4bsimplechat1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleChatClientA {

    JTextField textField;
    PrintWriter writer;
    Socket socket;

    public static void main(String[] args) {
        SimpleChatClientA chat = new SimpleChatClientA();
        chat.go();
    }

    private void go() {
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel panel = new JPanel();
        textField = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        panel.add(textField);
        panel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        setUpNetworking();
        frame.setSize(400,500);
        frame.setVisible(true);
    }

    private void setUpNetworking() {
        try {
            socket = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Network established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class SendButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                writer.println(textField.getText());
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
