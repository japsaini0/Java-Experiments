import java.util.Arrays;
import java.util.List;

public class Stream {

    public static void main(String[] args) {

        List <Integer> jap = Arrays.asList(1, 7, 9, 13, 18, 27, 45, 54, 81);      
        
        List <Integer> smth = jap.stream().filter(n -> n % 2 == 0).map(n -> n * n).toList();

        jap.stream().forEach(System.out::println);

        System.err.println(" ");

        System.out.println("Elements stored in another list using toList() function : ");
        smth.stream().forEach(System.out::println);
    }
}