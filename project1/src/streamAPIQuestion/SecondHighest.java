package streamAPIQuestion;
import java.util.Arrays;
import java.util.Comparator;

public class SecondHighest {
    public static int findSecondHighest(int[] arr) {
        return Arrays.stream(arr)
                .distinct() //remove duplicate
                .boxed()    //convert intstream to stream
                .sorted(Comparator.reverseOrder())   //sort decreasing
                .skip(1)  //skip highest
                .findFirst()  //Get second Highest
                .orElse(-1); //Return -1 if not present
    }

    static void main(String[] args) {
        int[] arr = {10,20,5,20,8};
        System.out.println(findSecondHighest(arr));
    }
}
