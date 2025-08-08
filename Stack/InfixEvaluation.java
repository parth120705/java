package Stack;
import java.util.Scanner;
import java.util.Stack;
public class InfixEvaluation {
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
    public static void main(String args[]){
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        Stack<Character> optr=new Stack<>();
        Stack<Integer> oprnd=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(Character.isDigit(ch)){
                oprnd.push(ch-'0');
            }
            else if(ch=='('){
                optr.push(ch);
            }
            else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                while(optr.size()!=0&&optr.peek()!='('&&priority(ch)<=priority(optr.peek())){
                    char operatr=optr.pop();
                    int x=oprnd.pop();
                    int y=oprnd.pop();
                    oprnd.push(calc(y, x, operatr));
                }
                optr.push(ch);
            }
            else if(ch==')'){
                while(optr.peek()!='('){
                    char operatr=optr.pop();
                    int x=oprnd.pop();
                    int y=oprnd.pop();
                    oprnd.push(calc(y, x, operatr));
                }
                optr.pop();
            }
        }
        while(optr.size()!=0){
            char operatr=optr.pop();
            int x=oprnd.pop();
            int y=oprnd.pop();
            oprnd.push(calc(y, x, operatr));
        }
        System.out.println(oprnd.peek());
    }

}
