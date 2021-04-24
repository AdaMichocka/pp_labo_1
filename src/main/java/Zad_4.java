import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Zad_4 {

    Zad_3 zad_3 = new Zad_3();

    public void zad4() {
        Path path = Paths.get("D:\\IdeaProjects\\pp_labo_1\\src\\main\\resources\\mackbeth.txt");

        List<String> words = zad_3.readFile(path);

        Map<String, Integer> uniqueWords = zad_3.countWords(words);

        List<Map.Entry<String, Integer>> result = uniqueWords.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(8)
                .collect(Collectors.toList());

        System.out.println("8 najczęściej występujących słów w pliku: ");
        result.forEach(System.out::println);
    }
}
