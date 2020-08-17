import java.util.function.Predicate;
import java.util.stream.IntStream;

public class IsIsEven {
        public static void main(String[] args) {
                System.out.println(isIsEven((x) -> (x == 16 ? false : x % 2 == 0)));
        }

        public static boolean isIsEven(Predicate<Integer> possiblyIsIsEven) {
                Predicate<Integer> isEven = (i) -> (i % 2 == 0);
                return IntStream
                        .rangeClosed(Integer.MIN_VALUE, Integer.MAX_VALUE)
                        .allMatch((i) -> possiblyIsIsEven.test(i) == isEven.test(i));
        }
}
