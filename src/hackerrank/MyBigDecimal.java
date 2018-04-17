package hackerrank;

import java.math.BigDecimal;
import java.util.*;

class MyBigDecimal {
    public static void main(String []args){
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] s = new String[n + 2];
        for(int i = 0 ; i < n ; i++){
            s[i] = sc.next();
        }
        sc.close();

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String strBigDec1, String strBigDec2) {
                if (strBigDec1 != null && strBigDec2 != null){
                    BigDecimal bigDec1 = new BigDecimal(strBigDec1);
                    BigDecimal bigDec2 = new BigDecimal(strBigDec2);
                    if (bigDec1.compareTo(bigDec2) <= 0){
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return 0;
            }
        });

        //Output
        for(int i = 0 ; i < n ; i++)
        {
            System.out.println(s[i]);
        }
    }
}
