import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class expectedCasinoProfit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int m = in.nextInt();
        int profit = 0;
        double output = 0.0;
        for(int a0 = 0; a0 < n; a0++){
            int w = in.nextInt();
            int p = in.nextInt();
           profit =  profit + w*p;
        }
        output = x*m-profit*m/100.0;
        System.out.println(output);
        
        in.close();
    }
}
