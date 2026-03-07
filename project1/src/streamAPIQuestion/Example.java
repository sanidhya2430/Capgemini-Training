package streamAPIQuestion;
import java.util.*;
import java.util.stream.*;

public class Example {
        public static void main(String[] args) {
            List<Integer> nums = Arrays.asList(1,2,3,4,5,6);

            int sum = nums.stream()
                    .filter(n -> n % 2 == 0)
                    .map(n -> n * n)
                    .reduce(0, Integer::sum);

            System.out.println("Sum of squares of even numbers: " + sum);

            List<String> names = Arrays.asList("java", "stream", "api");

            names.stream()
                    .map(String::toUpperCase)
                    .forEach(System.out::println);
    }
}
