import java.io.*;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class T3Q4 {

    public enum HashFunction{
        MD5("MD5"),
        SHA1("SHA1"),
        SHA256("SHA-256"),
        SHA512("SHA-512");
    
        private String name;
    
        HashFunction(String name) {
            this.name = name;
        }
    
        public String getName(){
            return name;
        }

        public byte[] checksum(File input) {
            int blockLength;
            try(FileInputStream in = new FileInputStream(input)){
                MessageDigest myDigest = MessageDigest.getInstance(this.getName());
                byte[] byteBlock = new byte[4096];
                while((blockLength = in.read(byteBlock)) > 0) {
                    myDigest.update(byteBlock, 0, blockLength);
                }
        
                return myDigest.digest();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }//checksum()
    }//HashFunction()

    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputText;
        
        System.out.println("Enter filename: ");
        inputText = reader.readLine();

        File file = new File(inputText);
        System.out.println("File: " + file);
        System.out.println("MD5: " + toHex(HashFunction.MD5.checksum(file)));
        System.out.println("SHA1: " + toHex(HashFunction.SHA1.checksum(file)));
        System.out.println("SHA256: " + toHex(HashFunction.SHA256.checksum(file)));
    }
    
    private static String toHex(byte[]  bytes) {
        return DatatypeConverter.printHexBinary(bytes);
    }
}
