import java.util.function.Predicate;
import java.util.stream.IntStream;

public class IsIsEven {
        public static void main(String[] args) {
                System.out.println(isIsEven((x) -> (x == 16 ? false : x % 2 == 0)));
        }

        public static boolean isIsEven(Predicate<Integer> maybeIsEven) {
                // Create a known working isEven function to test against
                Predicate<Integer> workingIsEven = (i) -> (i % 2 == 0);
                // Test Integer.MAX_VALUE specifically, it'll be excluded in the stream
                if (maybeIsEven.test(Integer.MAX_VALUE)) return false;
                // test every other number, ensure they all match
                return IntStream
                        .range(Integer.MIN_VALUE, Integer.MAX_VALUE)
                        .allMatch((i) -> maybeIsEven.test(i) == workingIsEven.test(i));
        }
}
