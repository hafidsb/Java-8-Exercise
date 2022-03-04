import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasic {
    public static void main(String[] args) {
        // a list of integers from 0 to 100
        List<Integer> theList = new ArrayList<>(Arrays.asList(1,10,101,200,400,5,11,9,121,48,59,67,88));

        // find all even numbers in the list
        System.out.println("Even Numbers:");
        System.out.println(theList.stream().filter(n -> n%2==0).collect(Collectors.toList()));

        // find all numbers starting with '1'
        System.out.println("Numbers starting with '1':");
        System.out.println(theList.stream().filter(n -> n.toString().startsWith("1")).collect(Collectors.toList()));

        // find total number of elements present in the list
        System.out.println("Total elements in the list:");
        System.out.println(theList.stream().count()); // why does this gets a warning?

        // sort all the values present in the list
        System.out.println("Sorted list ascending: ");
        System.out.println(theList.stream().sorted().collect(Collectors.toList()));
    }
}
