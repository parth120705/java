package Stack;

import java.util.Scanner;
import java.util.Stack;

public class PrefixConversion {
    public static int calc(int x,int y,char z){
        
        if(z=='+'){
            return x+y;
        }
        else if(z=='-'){
            return x-y;
        }
        else if(z=='/'){
            return x/y;
        }
        else if(z=='*'){
            return x*y;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();

        Stack<Integer> vs=new Stack<>();
        Stack<String> ifs=new Stack<>();
        Stack<String> posts=new Stack<>();

        for(int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                int v1=vs.pop();
                int v2=vs.pop();
                int res1=calc(v1, v2, ch);
                vs.push(res1);

                String if1=ifs.pop();
                String if2=ifs.pop();
                String res2='('+if1+ch+if2+')';
                ifs.push(res2);

                String post1=posts.pop();
                String post2=posts.pop();
                String res3=post1+post2+ch;
                posts.push(res3);
            }
            else{
                vs.push(ch-'0');
                ifs.push(ch+"");
                posts.push(ch+"");
            }
        }
        System.out.println(vs.pop());
        System.out.println(ifs.pop());
        System.out.println(posts.pop());
    }
}
