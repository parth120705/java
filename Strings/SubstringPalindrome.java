package Strings;

public class SubstringPalindrome {
    public static boolean ispalindrome(String s){
        int x=0;
        int y=s.length()-1;

        while(x<=y){
            char c1=s.charAt(x);
            char c2=s.charAt(y);
            if(c1!=c2){
                return false;
            }
            else{
                x++;
                y--;
            }
        }
        return true;
    }
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String ss=s.substring(i,j);
                if(ispalindrome(ss)==true){
                    count++;
                }
            }
        }
        return count;
    }
}
