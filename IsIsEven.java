import java.util.function.Predicate;
import java.util.stream.IntStream;

public class IsIsEven {
        public static void main(String[] args) {
                System.out.println(isIsEven((x) -> (x == 16 ? false : x % 2 == 0)));
        }

        public static boolean isIsEven(Predicate<Integer> maybeIsEven) {
                Predicate<Integer> workingIsEven = (i) -> (i % 2 == 0);
                return IntStream
                        .range(Integer.MIN_VALUE, Integer.MAX_VALUE)
                        .parallel()
                        .allMatch((i) -> maybeIsEven.test(i) == workingIsEven.test(i));
        }
}
