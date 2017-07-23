import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


  public class TreeNode {
  // Each node has the fields val, parent, children,a,hasChild,hasParent
      int val;
      List<Integer> children;
      int parent;
      int a;
      boolean hasChild;
      boolean hasParent;
      TreeNode(int x,List<Integer> adjacencyList,int a) {
    	  this.val = x;
    	  this.a = a;
    	  if (x==1){
    		  parent = -1;
    	  }
    	  children = new ArrayList<Integer>();
    	  for (Integer item:adjacencyList){
    		  if (item>x){
    			  this.hasChild = true;
    			  children.add(item);
    			  
    		  }
    		  else{
    			  this.parent = item;
    			  this.hasParent = true;
    		  }
    		  
    	  }

      }
      
      public int getParent(int value){
    	  return this.parent;
      }
      
      public int getA(int value){
    	  return this.a;
      }
      public List<Integer> getChildren(int x){
       	  return this.children;
      }
      
      public void setA(int value){
    	  this.a = value;
      }

  }
 

