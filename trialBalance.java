import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class trialBalance {
	static int[] solve(int n, int m, int[] d, int[] c) {
		int cSum = 0;
		int dSum = 0;
		int[] output = new int[2];
		int diff = 0;
		//findinf sum of both credit and debit array
		for (int i=0;i<c.length;i++){
			cSum = cSum+c[i];
		}
		for (int i=0;i<d.length;i++){
			dSum = dSum+d[i];
		}
    //if both sums are equal, no exchange required
		if (cSum==dSum){
			output[0] = 0;
			output[1] = 0;
			return output;
		}
		else if (cSum>dSum){
			diff = cSum-dSum;
			//negate dSum
			for(int i=0;i<d.length;i++){
				d[i] = -1*d[i];
			}
		}
		else if(dSum>cSum){
			diff = dSum - cSum;
			//negate cSum
			for(int i=0;i<c.length;i++){
				c[i] = -1*c[i];
			}
		}
    //making a new arraylist combining both credit and debit
		List<Integer> values = new ArrayList<Integer>();
		for (int i=0;i<c.length;i++){
			values.add(c[i]);
		}
		for (int i=0;i<d.length;i++){
			values.add(d[i]);
		}
    
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		//finding all subsets with sum diff/2
    subsets = findMin(values,diff/2);
		int currentSetSize = Integer.MAX_VALUE;
		//List<Integer> currentSet = new ArrayList<Integer>();
		for (List list:subsets){
			
			 if (list.size()<currentSetSize){
				 currentSetSize = list.size();
			}
		}
		output[0] = 0;
		output[1] =currentSetSize;		
		return output;
	}
	
	public static List<List<Integer>> findMin(List<Integer> values,int sum){
		List<Integer> current = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(values,0,sum,0,current,result,Integer.MAX_VALUE);
		return result;
	}
  
    private static void helper(List<Integer> values,int currentSum,int sum, int idx, List<Integer> current,List<List<Integer>> solution,int minSize) {
    //function to generate subsets
    if (current.size()>minSize){
    		return;
    	}
    	if (currentSum == sum) {
    		if (current.size()<minSize){
    			solution.add(new ArrayList<Integer>(current));
    			minSize = current.size();
    		}
            
            return;
         }
        if (idx == values.size()){
            return;  
        } 
        current.add(values.get(idx));
        currentSum = currentSum+values.get(idx);
        helper(values, currentSum, sum, idx+1, current, solution,minSize);
        currentSum = currentSum-current.get(current.size()-1);
        current.remove(current.size()-1);
        helper(values, currentSum, sum, idx+1, current, solution,minSize);
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] d = new int[n];
        
        for(int d_i = 0; d_i < n; d_i++){
            d[d_i] = in.nextInt();
        }
        int[] c = new int[m];
        for(int c_i = 0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        int[] result = solve(n, m, d, c);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
