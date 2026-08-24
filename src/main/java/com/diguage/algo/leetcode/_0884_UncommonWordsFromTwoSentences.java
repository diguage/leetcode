import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _0884_UncommonWordsFromTwoSentences {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-24 20:55:12
   */
  public String[] uncommonFromSentences(String s1, String s2) {
    Map<String, Long> sw1 = Arrays.stream(s1.split(" "))
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Map<String, Long> sw2 = Arrays.stream(s2.split(" "))
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    List<String> result = new ArrayList<>();
    sw1.forEach((key, value) -> {
      if (value == 1 && !sw2.containsKey(key)) {
        result.add(key);
      }
    });
    sw2.forEach((key, value) -> {
      if (value == 1 && !sw1.containsKey(key)) {
        result.add(key);
      }
    });
    return result.toArray(new String[result.size()]);
  }
  // end::answer[]
}
