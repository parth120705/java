package BinarySearchTree;

public class RemoveNodeinBST {
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
    public static Node constructor(int[] arr,int low,int high){
        if(low>high){
            return null;
        }
        int mid=(low+high)/2;
        int data=arr[mid];
        Node lc=constructor(arr,low,mid-1);
        Node rc=constructor(arr, mid+1, high);
        Node node=new Node(data, lc, rc);
        return node;
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
    public static int max(Node node){
        if(node.right!=null){
            return max(node.right);
        }
        else{
            return node.data;
        }
    }
    public static Node remove(Node node,int data){
        if(node.data>data){
            node.left=remove(node.left, data);
        }
        else if(node.data<data){
            node.right=remove(node.right, data);
        }
        else{
            if(node.left!=null&&node.right!=null){
                int lmax=max(node.left);
                node.data=lmax;
                node.left=remove(node.left, lmax);
                return node;
            }
            else if(node.right!=null){
                return node.right;
            }
            else if(node.left!=null){
                return node.left;
            }
            else{
                return null;
            }
        }
        return node;
    }
    
   

    
        public static void main(String args[]){
              int[] arr={12,25,37,50,62,75,87};
              Node root=constructor(arr, 0, arr.length-1);
              remove(root, 12);
              display(root);
              
              
             
    
        }
}
