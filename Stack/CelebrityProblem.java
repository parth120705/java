package Stack;
import java.util.*;
public class CelebrityProblem {
    public static void main(String[] args) {
        Scanner scn=new Scanner (System.in);
        int n=scn.nextInt();

        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            st.push(i);
        }
        while(st.size()>=2){
            int x=st.pop();
            int y=st.pop();

            if(arr[x][y]==0){
                st.push(x);
            }
            else{
                st.push(y);
            }
        }
        int pot=st.pop();
        for(int i=0;i<n;i++){
            if(i!=pot){
                if(arr[i][pot]==0||arr[pot][i]==1){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(pot);

    }
}
