package streamAPIQuestion;
import java.util.* ;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FrequencyCount {
    static void main(String[] args) {
        int[] arr = {1,2,2,3,1,4};

        Map<Integer , Long> frequencyMap =
                Arrays.stream(arr)
                        .boxed()
                        .collect(Collectors.groupingBy(num -> num,Collectors.counting()));
        frequencyMap.forEach((key,value) ->
                System.out.println(key + " -> " + value));

    }
}
