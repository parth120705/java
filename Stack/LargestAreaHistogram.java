package Stack;
import java.util.Stack;
public class LargestAreaHistogram {
    public static void main(String args[]){
        int[] arr={6,2,5,4,5,1,6};
        Stack<Integer> st=new Stack<>();
        int[] rb=new int[arr.length];
        int[] lb=new int[arr.length];
        // st.push(0);
        // lb[0]=-1;
        for(int i=0;i<arr.length;i++){
            while(st.size()!=0&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                st.push(i);
                lb[i]=-1;
            }
            else{
                lb[i]=st.peek();
                st.push(i);
            }
        }
        st=new Stack<>();
        // st.push(arr.length);
        // rb[arr.length-1]=arr.length;
        for(int i=arr.length-1;i>=0;i--){
            while(st.size()!=0&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                st.push(i);
                rb[i]=arr.length;
            }
            else{
                rb[i]=st.peek();
                st.push(i);
            }
        }
        int max=0;
        for(int i=0;i<arr.length;i++){
            int x=arr[i]*(rb[i]-lb[i]-1);
            if(x>max){
                max=x;
            }

        }
        System.out.println(max);
    }
}
