import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class strongCorrelation {

    static String solve(int n, int[] p, int[] d) {
        // Complete this function
        for (int i=1;i<p.length;i++){
            if ((p[i]==p[i-1] && d[i]==d[i-1]) || (p[i]<p[i-1] && d[i]<d[i-1])  ||(p[i]>p[i-1] && d[i]>d[i-1])){
                continue;
            }
            else{
                return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for(int p_i = 0; p_i < n; p_i++){
            p[p_i] = in.nextInt();
        }
        int[] d = new int[n];
        for(int d_i = 0; d_i < n; d_i++){
            d[d_i] = in.nextInt();
        }
        String result = solve(n, p, d);
        System.out.println(result);
        in.close();
    }
}
