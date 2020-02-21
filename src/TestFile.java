import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestFile {

    public static String filename = "test file";

    public static void main (String[] args){
        try {
            FileReader newFileReader = new FileReader(filename);
            BufferedReader buff = new BufferedReader(newFileReader);
        }catch (IOException e){
            System.out.println(e.getMessage());

        }
    }
}
