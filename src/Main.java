import java.io.IOException;

public class Main {
    public static void main (String [] args) {
        try {
            ReadTextFromFile.GetFileAndRead("Test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
