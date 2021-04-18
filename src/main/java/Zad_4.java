import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Zad_4 {

    public static void main(String[] args) {
        Path path = Paths.get("D:\\IdeaProjects\\pp_labo_1\\src\\main\\resources\\mackbeth.txt");
        try {
            Stream<String> lines = Files.lines(path);
            List<String> words = lines
                    .flatMap(line -> Stream.of(line.split("\\W+")))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());

            words.removeIf(a -> a.length() < 3);

            Map<String, Integer> uniqueWords = new HashMap<>();

            for (int i = 0; i < words.size(); i++) {
                String str = words.get(i);
                if (uniqueWords.containsKey(str)) {
                    uniqueWords.put(str, uniqueWords.get(words.get(i)) + 1);
                } else {
                    uniqueWords.put(str, 1);
                }
            }
            List<Map.Entry<String, Integer>> result = uniqueWords.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(8)
                    .collect(Collectors.toList());
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
