import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ReadTextFromFile {
    public static void GetFileAndRead(String pathname) throws IOException {
        Scanner in = new Scanner(new File(pathname), StandardCharsets.UTF_8);
        var count = new HashMap<String, Set<String>>();
        var line = 1;
        while(in.hasNextLine()) {
            var words = in.nextLine().split(" ");
            for (var word : words) {
                if (!(word.isEmpty())) // zabezpieczenie przed plikami tekstowymi w których są puste linie
                {
                    var lines = count.getOrDefault(word, new TreeSet<>()); // tworzy połączenie pomiędzy danym słowem a numerem linijki wystąpienia
                    lines.add(String.valueOf(line)); // dodaje do zestawu kolejny numer linijki w której wystąpiło słowo
                    count.put(word, lines); // dodaje kolejny wpis do mapy złożony z nazwą słowa i linijkami występowania
                }
            }
            line++;
        }
        for (var entry : count.entrySet()) { // lista wszystkich słów i numerów linijek występowania
            System.out.println("Słowo '" + entry.getKey().replaceAll("\\p{Punct}", "") + "' znajduje się w linijkach " + String.join(",", entry.getValue())); // metoda replaceAll użyta do usunięcia znaków interpukcyjnych ze słów
        }
        in.close();
    }
}
