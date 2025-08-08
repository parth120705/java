package ExceptionHandling;
import java.io.*;
public class writefile {
    public static void main(String[] args) {
        try{
            BufferedWriter bw=new BufferedWriter(
                new FileWriter("/Users/parthmunjal/Desktop/C file/output.txt"));
                bw.write("hello\n");
                bw.write("my name is\n");
                bw.write("parth");
                bw.close();
        }
        catch(Exception e){
            return;
        }
    }
}
