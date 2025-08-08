package ExceptionHandling;
import java.io.*;
public class readfile {
    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(
            new FileReader("/Users/parthmunjal/Desktop/C file/output.txt"));
            String s;
            while((s=br.readLine())!=null){
                System.out.println(s);
            }
            br.close();
        }
        catch(Exception e){
            return;
        }

    }
}
