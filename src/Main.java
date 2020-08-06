import java.io.FileNotFoundException;

public class Main {
    public static void main (String [] args) {
        try {
            ReadTextFromFile.GetFileAndRead("Test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
