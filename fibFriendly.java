import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Scanner;

public class fibFriendly {
	
	static long solve(long n){
		
		if (n<1111){
			//numbers upto 1111 are Fibonacci friendly
			return n;
		}
		long count =1110;
		long i =1111;
    //Alread know the first 1111 Fibonacci friendly numbers. 
		while (count<n){
			if (isFib(i)){
				count++;
			}
			i++;
		}
		return i-1;
		
	}

    static boolean isFib(long num){
        //returns whether the number is Fibonacci friendly        
        //maping the frequency of all digits in the number
        Map<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        while (num>0){
            int digit = (int)num%10;

            if (!hmap.containsKey(digit)){
                hmap.put(digit,1);

            }
            else{
                hmap.put(digit,hmap.get(digit)+1);
            }
            num = num/10;
        }
        //check whether all frequencies are in Fibonacci sequence
        for (Integer value:hmap.values()){
          //A number belongs to Fibonacci sequence iff 5n^2+4 or 5n^2-4 are perfect squares
        	if (!((isPerfectSquare(5*value*value+4)) ||(isPerfectSquare(5*value*value-4)))){
        		return false;
        	}
        }
        return true;

    }
    static boolean isPerfectSquare(int num){
    //returns whetehr num is a perfect square
        int root = (int)Math.sqrt(num);
        //System.out.println("root = "+root);
        if (root*root==num){

            return true;
        }
        else{

            return false;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long n = in.nextLong();
            long result = solve(n);
            System.out.println(result);
        }
        
    }
}
