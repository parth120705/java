package Stack;

import java.util.Scanner;
import java.util.Stack;

public class balancedbrackets {
    public static void main(String args[]){
        Scanner scn=new Scanner(System.in);
        String exp=scn.nextLine();

        Stack<Character> st=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }
            if(ch==')'){
                if(st.peek()=='('){
                    st.pop();
                }
                else{
                    System.out.println(false);
                    return;
                }
            }
            else if(ch=='}'){
                if(st.peek()=='{'){
                    st.pop();
                }
                else{
                    System.out.println(false);
                    return;
                }
            }
            else if(ch==']'){
                if(st.peek()=='['){
                    st.pop();
                }
                else{
                    System.out.println(false);
                    return;
                }
            }
        }
        if(st.size()==0){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
    
}

