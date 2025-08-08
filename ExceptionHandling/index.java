package ExceptionHandling;

import java.io.IOException;
import java.io.InputStreamReader;

public class index{
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr=new InputStreamReader(System.in)){
            int letter=isr.read();
            while(isr.ready()){
                System.out.println((char) letter);
                letter=isr.read();
            }
            isr.close();
            System.out.println();
        
        }
        catch(IOException e){
            System.out.println(e.getMessage());

        }
    }
}
