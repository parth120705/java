package Stack;
import java.util.*;
public class PostfixConversion {
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
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();

        Stack<Integer> vs=new Stack<>();
        Stack<String> ifs=new Stack<>();
        Stack<String> pre=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            if(ch=='+'||ch=='-'||ch=='/'||ch=='*'){
                int v2=vs.pop();
                int v1=vs.pop();
                int res1=calc(v1,v2,ch);
                vs.push(res1);

                String i2=ifs.pop();
                String i1=ifs.pop();
                String res2="(" + i1 + ch + i2 + ")";
                ifs.push(res2);

                String p2=pre.pop();
                String p1=pre.pop();
                String res3=ch+p1+p2;
                pre.push(res3);


            }
            else{
                vs.push(ch-'0');
                ifs.push(ch+"");
                pre.push(ch+"");
            }
            
        }
        System.out.println(vs.pop());
        System.out.println(ifs.pop());
        System.out.println(pre.pop());


    }
}
