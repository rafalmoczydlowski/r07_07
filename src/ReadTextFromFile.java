import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ReadTextFromFile {
    public static void GetFileAndRead(String pathname) throws FileNotFoundException {
        Scanner in = new Scanner(new File(pathname), "UTF-8");
        Map<String, Integer> countWords = new TreeMap<>();
        while (in.hasNext()) {
            in.useDelimiter("\\PL+");
            String word = in.next();
            countWords.merge(word, 1, Integer::sum);
        }
        System.out.println(countWords);
    }
}
