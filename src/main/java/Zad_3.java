import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Zad_3 {

    public void zad3() {
        Path path = Paths.get("D:\\IdeaProjects\\pp_labo_1\\src\\main\\resources\\mackbeth.txt");
        List<String> words = readFile(path);

        Map<String, Integer> uniqueWords = countWords(words);

        System.out.println("Liczba unikalnych słów w pliku: " + uniqueWords.size());

    }

    public List<String> readFile(Path path) {
        Stream<String> lines;
        List<String> words = null;
        try {
            lines = Files.lines(path);
            words = lines
                    .flatMap(line -> Stream.of(line.split("\\W+")))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());

            words.removeIf(a -> a.length() < 3);

        } catch (IOException e) {
            System.out.println("Błąd przy ładownaiu pliku");
            e.printStackTrace();
        }
        return words;
    }

    public Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> uniqueWords = new HashMap<>();

        for (int i = 0; i < words.size(); i++) {
            String str = words.get(i);
            if (uniqueWords.containsKey(str)) {
                uniqueWords.put(str, uniqueWords.get(words.get(i)) + 1);
            } else {
                uniqueWords.put(str, 1);
            }
        }
        return uniqueWords;
    }

}
