package useacabecajava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SimpleDotComHelper {
    public String getUserInput(String s) {
        String inputLine = null;

        System.out.println(s + " ");
        try {
            InputStream in = System.in;
            InputStreamReader inputReader = new InputStreamReader(in);
            BufferedReader is = new BufferedReader(inputReader);
            inputLine = is.readLine();
            if (inputLine.length() == 0){
                return null;
            }
        } catch (IOException e){
            System.out.println("IOException? " + e);

        }
        return inputLine;
    }
}
