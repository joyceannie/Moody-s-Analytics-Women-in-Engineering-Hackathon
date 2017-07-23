import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class xorQuestion{
     void divide(TreeNode[] obj,int u,int v,int w){
        if (u==v){
        //source and destination are the same
            return;
        }
        Set<Integer> visited = new HashSet<Integer>();      
         List<Integer> path = new ArrayList<Integer>();        
        findDestination(obj,u,v,visited,path,w);
        

    }
    
     public void findDestination(TreeNode[] obj,int source,int destination,Set<Integer> visited,List<Integer> path,int w){
     //finds path from source to destination and updates a value in the path
    	 visited.add(source);
    	 path.add(source);
    	 List<Integer> neighbours = new ArrayList<Integer>();
    	 if (source==destination){
    		 for (Integer item:path){
    			 int currentA = obj[item].getA(item);
    			 obj[item].setA((int) Math.ceil((double)currentA/w));
    		 }
    		 return;
    	 }
    	 else {
       //check for both parents as well as children
    		 if (obj[source].hasChild){
        		 for (Integer item:obj[source].getChildren(source)){
        			 neighbours.add(item);
        		 }	 
    		 }
   	
    		 if (obj[source].hasParent){
    			 neighbours.add(obj[source].getParent(source)); 
    		 }    	
    		 for (Integer child:neighbours){
    			 if (visited.add(child)){
    				 findDestination(obj,child,destination,visited,path,w);
    			 }
    		 }
    		 
    	 }
    	 path.remove(path.size()-1);
     }
     
     void multiply(TreeNode[] obj,int k,int w){
    	 int currentA = obj[k].getA(k);
    	 int newA = (currentA*w)%1009;
    	 obj[k].setA(newA);
     }
     void query(TreeNode[] obj,int k,int w,Map<Integer,List<Integer>> adjacencyList){
         Set<Integer> visited = new HashSet<Integer>();
         int max = obj[k].getA(k)^w;
         visited.add(k);
         max = findMax(obj,k,max,w);
         //max = bfs(k,visited,adjacencyList,max,a,w);        
         System.out.println(max);
     }
     
     public int findMax(TreeNode[] obj,int currentNode,int max,int w){
    	 for (Integer child:obj[currentNode].getChildren(currentNode)){
    		 max = Math.max(max, obj[child].getA(child)^w);
    		 max = findMax(obj,child,max,w);
    		 
    	 }
    	 return max;
     }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = scanner.nextInt();
        }
        int[][] adjacencyMatrix = new int[n-1][2];
        for (int i=0;i<n-1;i++){
            for (int j=0;j<2;j++){
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        //make adjacency list from the matrix
        Map<Integer,List<Integer>> adjacencyList = new HashMap<Integer,List<Integer>>();
     
        for (int i=1;i<=n;i++){
            adjacencyList.put(i,new ArrayList<Integer>());
        }
        for (int[] edge:adjacencyMatrix){
            List<Integer> list;
            list= adjacencyList.get(edge[0]);
            list.add(edge[1]);
            adjacencyList.put(edge[0],list);
           
            list = adjacencyList.get(edge[1]);
            list.add(edge[0]);
            adjacencyList.put(edge[1],list);          
        }
        

        TreeNode obj[] = new TreeNode[n+1];
        for(int i=1;i<=n;i++){
        	obj[i] = new TreeNode(i,adjacencyList.get(i),a[i-1]);
        }

        xorQuestion object = new xorQuestion();
        
        while (q>=0){
            //process the input
            String s = scanner.nextLine();
            String[] token = s.split(" ");
           // System.out.println("#"+token[0]+"#");
            if (token[0].equals("Divide")){
                object.divide(obj,Integer.parseInt(token[1]),Integer.parseInt(token[2]),Integer.parseInt(token[3]));
            }
            else if (token[0].equals("Query")){
                object.query(obj,Integer.parseInt(token[1]),Integer.parseInt(token[2]),adjacencyList);
                
            }
            else if(token[0].equals("Multiply")){
            	object.multiply(obj,Integer.parseInt(token[1]),Integer.parseInt(token[2]));
            }
            q--;
        }
    }
}
