package BinaryTree;

import java.util.Stack;

public class PrintSingleChildNode {
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
    public static void printsinglechildnodes(Node node,Node parent){
        if(node==null){
            return;
        }
        if(parent!=null&&parent.left==node&&parent.right==null){
            System.out.println(node.data);
        }
        if(parent!=null&&parent.right==node&&parent.left==null){
            System.out.println(node.data);
        }
        printsinglechildnodes(node.left, node);
        printsinglechildnodes(node.right, node);
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
