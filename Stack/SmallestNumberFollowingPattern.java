package Stack;
import java.util.*;
public class SmallestNumberFollowingPattern {
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        Stack<Integer> st=new Stack<>();
        int j=1;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            
            if(ch=='d'){
                st.push(j);
                j=j+1;
            }
            else if(ch=='i'){
                st.push(j);
                while(st.size()!=0){
                    System.out.println(st.pop());
                }
                j=j+1;
            }
        }
        st.push(j);
        while(st.size()!=0){
            System.out.println(st.pop());
        }
        
    }
}
