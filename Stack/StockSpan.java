package Stack;

import java.util.Stack;

public class StockSpan {
    public static void main(String args[]){
        int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        ans[0]=1;
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size()!=0&&arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=i+1;
                st.push(i);
            }else{
                ans[i]=i-st.peek();
                st.push(i);
            }
            
            
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

//use same like ngeonr
