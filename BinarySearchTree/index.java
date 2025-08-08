package BinarySearchTree;

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
    public static int min(Node node){
        if(node.left!=null){
            return min(node.left);
        }
        else{
            return node.data;
        }
    }
    public static boolean find(Node node,int data){
        if(node==null){
            return false;
        }
        if(node.data>data){
            return find(node.left, data);
        }
        else if(node.data<data){
            return find(node.right, data);
        }
        else{
            return true;
        }
    }
   

    
        public static void main(String args[]){
              int[] arr={12,25,37,50,62,75,87};
              Node root=constructor(arr, 0, arr.length-1);
              display(root);
              System.out.println(min(root));
              System.out.println(max(root));
              System.out.println(find(root, 12));
    
        }
    
    

}

