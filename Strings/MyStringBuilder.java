package Strings;
import java.util.*;
public class MyStringBuilder {
    public static void main(String[]args){
        StringBuilder ss=new StringBuilder("hello");
        System.out.println(ss);

        char ch=ss.charAt(2);
        System.out.println(ch);//get

        ss.setCharAt(1, 'd');
        System.out.println(ss);//update

        ss.insert(2, "f");
        System.out.println(ss);//inset

        ss.deleteCharAt(3);
        System.out.println(ss);//delete

        ss.append('k');
        System.out.println(ss);

        System.out.println(ss.length());
        
    }
}
