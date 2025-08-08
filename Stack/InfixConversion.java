package Stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixConversion {
    public static int priority(char x){
        
        if(x=='+'){
            return 1;
        }
        else if(x=='-'){
            return 1;
        }
        else if(x=='/'){
            return 2;
        }
        else if(x=='*'){
            return 2;
        }
        return 0;        
    }
    public static void main(String [] args) {
        Scanner scn=new Scanner(System.in);
        String s=scn.nextLine();
        Stack<String> pre=new Stack<>();
        Stack<String> post=new Stack<>();
        Stack<Character> operator=new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if((ch>='a'&&ch<='z')||(ch>='0'&&ch<='9')||(ch>='A'&&ch<='Z')){
                post.push(ch+"");
                pre.push(ch+"");
            }
            if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                while(operator.size()!=0&&operator.peek()!='('&&priority(ch)<=priority(operator.peek())){
                    String s1=post.pop();
                    String s2=post.pop();
                    Character s3=operator.pop();
                    String q=s3+s2+s1;
                    post.push(q);

                    String r1=pre.pop();
                    String r2=pre.pop();
                    String p=r2+r1+s3;
                    pre.push(p);
                }
                operator.push(ch);
            }
            else if(ch=='('){
                operator.push(ch);
            }
            else if(ch==')'){
                while(operator.peek()!='('){
                    String s1=post.pop();
                    String s2=post.pop();
                    Character s3=operator.pop();
                    String q=s3+s2+s1;
                    post.push(q);

                    String r1=pre.pop();
                    String r2=pre.pop();
                    String p=r2+r1+s3;
                    pre.push(p);
                }
                operator.pop();
            }
            
        }
        while(operator.size()!=0){
            String s1=post.pop();
                    String s2=post.pop();
                    Character s3=operator.pop();
                    String q=s3+s2+s1;
                    post.push(q);

                    String r1=pre.pop();
                    String r2=pre.pop();
                    String p=r2+r1+s3;
                    pre.push(p);
        }
        System.out.println(pre.peek());
        System.out.println(post.peek());
    }
}
