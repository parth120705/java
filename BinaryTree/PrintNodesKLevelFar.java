package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class PrintNodesKLevelFar {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data=data;
            this.right=right; 
            this.left=left;
        }
    }
    public static class Pair{
        Node node;
        int state;

        Pair(Node node,int state){
            this.node=node;
            this.state=state;
        }
        
    }
    public static void display(Node node){
        if(node==null){
            return;
        }
        String str="";
        str+=node.left==null?".":node.left.data;
        str+="<-"+node.data+"->";
        str+=node.right==null?".":node.right.data;
        System.out.println(str);

        display(node.left);
        display(node.right);

    }
    public static void printklevelfar(Node node,int data,int k){
        path=new ArrayList<>();
        find(node, data);
        for(int i=0;i<path.size();i++){
            printkleveldown(node, k,i==0?null:path.get(i-1));
        }
    }
    static ArrayList<Node> path;
    public static boolean find(Node node,int target){
        if(node==null){
            return false;
            
        }
        if(node.data==target){
            path.add(node);
            return true;
        }
        
        
        boolean ls=find(node.left,target);
        if(ls){
            path.add(node);
            return true;
        }
        boolean rs=find(node.right,target);
        if(rs){
            path.add(node);
            return true;
        }
        return false;

    }
    public static void printkleveldown(Node node,int k,Node blocker){
            if(node==null||k<0||node==blocker){
                return;
            }
            if(k==0){
                System.out.println(node.data);
            }
            printkleveldown(node.left, k-1,blocker);
            printkleveldown(node.right, k-1,blocker);
    }
    

    
        public static void main(String args[]){
            Integer[] arr={50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
            Stack<Pair> st=new Stack<>();
            Node root=new Node(arr[0], null, null);
            Pair rtp=new Pair(root,1);
            st.push(rtp);
            int index=0;
            while(st.size()>0){
                Pair top=st.peek();
                if(top.state==1){
                    index++;
                    if(arr[index]!=null){
                        top.node.left=new Node(arr[index], null, null);
                        Pair lp=new Pair(top.node.left, 1);
                        st.push(lp);
                    }
                    else if(arr[index]==null){
                        top.node.left=null;
                    }
                    top.state++;
                }
                else if(top.state==2){
                    index++;
                    if(arr[index]!=null){
                        top.node.right=new Node(arr[index], null, null);
                        Pair rp=new Pair(top.node.right, 1);
                        st.push(rp);
                    }
                    else if(arr[index]==null){
                        top.node.right=null;
                    }
                    top.state++;
                }
                else{
                    st.pop();
                }
            }
            display(root);
            
               
    
        }
}
