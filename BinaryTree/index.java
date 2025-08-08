package BinaryTree;
import java.util.*;
public class index {
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
    public static int size(Node node){
        if(node==null){
            return 0;
        }
        int ls=size(node.left);
        int rs=size(node.right);
        int ts=ls+rs+1;
        return ts;
    }
    public static int sum(Node node){
        if(node==null){
            return 0;
        }
        int ls=sum(node.left);
        int rs=sum(node.right);
        int ts=ls+rs+node.data;
        return ts;
    }
    public static int max(Node node){
        if(node==null){
            return Integer.MIN_VALUE;
        }
        int l=max(node.left);
        int r=max(node.right);
        int t=Math.max(node.data, Math.max(l,r));
        return t;
    }
    public static int height(Node node){
        if(node==null){
            return -1; //-1 for edges,0 for nodes
        }
        int l=height(node.left);
        int r=height(node.right);
        int t=Math.max(l,r)+1;
        return t;
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
            System.out.println(size(root));
            System.out.println(sum(root));
            System.out.println(max(root));
            System.out.println(height(root));   
    
        }
    
    

}
