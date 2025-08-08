package Strings;

import java.net.SocketPermission;
import java.util.*;

public class index {
    public static void main(String[] args) {
        // String s = "hello my name is parth";
        // String[] parts = s.split(" ");
        // for (int i = 0; i < parts.length; i++) {
        //     System.out.println(parts[i]);
        // }

        String s="abcd";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length()+1;j++){
                System.out.println(s.substring(i,j));
            }
        }

        
        
    }
}
