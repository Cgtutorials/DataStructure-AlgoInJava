import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain{
    public static void main(String[] args) {
        List<Integer> integers= Arrays.asList(14,1234,45,3,5667,3,573,65,23467);

        System.out.println(integers);

        integers.stream().forEach(e -> {
            System.out.println(e);
        });

        integers.stream().forEach(System.out::println);
    }
}
