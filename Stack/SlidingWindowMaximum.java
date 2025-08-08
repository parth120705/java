package Stack;

import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String args[]){
        int[] arr={2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6};
        int k=4;
        int nge[]=new int[arr.length];
        Stack <Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(st.size()!=0&&arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                nge[i]=arr.length;
                st.push(i);
            }
            else{
                nge[i]=st.peek();
                st.push(i);
            }
            
        }
        int j=0;
        for(int i=0;i<arr.length-k+1;i++){
            if(j<i){
                j=i;
            }
            while(nge[j]<i+k){
                j=nge[j];
            }
            System.out.println(arr[j]);
            
        }
    }
}
