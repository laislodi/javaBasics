package hackerrank;

import java.awt.SystemTray;
import java.util.Scanner;

public class JavaStaticInitializerBlock {

    private static boolean flag;
    private static int H;
    private static int B;

    static {
        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        H = sc.nextInt();

        if (H < 0 || B < 0){
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }else{
            flag = true;
        }
    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main

}//end of class

