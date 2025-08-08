package ExceptionHandling;
import java.io.*;
public class copy {
    public static void main(String[] args) {
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter("/Users/parthmunjal/Desktop/C file/output-copy.txt"));
            BufferedReader br=new BufferedReader(new FileReader("/Users/parthmunjal/Desktop/C file/output.txt"));
            String s;
            while((s=br.readLine())!=null){
                bw.write(s);
                bw.newLine();
            }
            br.close();
            bw.close();
        }
        catch(Exception e){
            return;
        }
    }
}
