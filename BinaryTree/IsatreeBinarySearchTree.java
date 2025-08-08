package BinaryTree;

import java.util.Stack;

public class IsatreeBinarySearchTree {
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
    public static class BSTPair{
        boolean isBST;
        int min;
        int max;
    }
    public static BSTPair ISBST(Node node){
        if(node==null){
            BSTPair mp=new BSTPair();
            mp.isBST=true;
            mp.min=Integer.MAX_VALUE;
            mp.max=Integer.MIN_VALUE;
            return mp;
        }
        BSTPair lp=ISBST(node.left);
        BSTPair rp=ISBST(node.right);

        BSTPair np=new BSTPair();
        np.isBST=lp.isBST&&rp.isBST&&(node.data>=lp.max&&node.data<=rp.min);
        np.min=Math.min(node.data, Math.min(lp.min, rp.min));
        np.max=Math.max(node.data,Math.max(lp.max, rp.max));
        return np;
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
            BSTPair bp=ISBST(root);
            System.out.println(bp.isBST);

            
               
    
        }
}
