import java.io.*;

public class T3Q4 {
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathname;
        
        System.out.println("Enter filename: ");
        pathname = reader.readLine();
        System.out.println("the filename is " + pathname);
    }
}
