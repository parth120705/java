// package Stack;
// import java.util.Stack;
// public class NGEONR {
//     public static void main(String args[]){
//         int[] arr={2,5,9,3,1,12,6,8,7};
//         int[] ans=new int[arr.length];
//         ans[arr.length-1]=-1;
//         Stack<Integer> st=new Stack<>();
//         st.push(arr[arr.length-1]);
//         for(int i=arr.length-2;i>=0;i--){
//             if(st.peek()>arr[i]){
//                 ans[i]=st.peek();
//                 st.push(arr[i]);
//             }
//             else{
//                 while(st.peek()<arr[i]){
//                     st.pop();
//                     if(st.size()==0){
//                         st.push(arr[i]);
//                         ans[i]=-1;
//                         break;
//                     }
//                 }
//                 if(st.peek()>arr[i]){
//                     ans[i]=st.peek();
//                     st.push(arr[i]);
//                 }
//             }
//         }
//         for(int i=0;i<ans.length;i++){
//             System.out.print(ans[i]+" ");
//         }
    

//     }
// }


package Stack;
import java.util.Stack;

public class NGEONR {
    public static void main(String args[]) {
        int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            
            ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
        }

        
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

