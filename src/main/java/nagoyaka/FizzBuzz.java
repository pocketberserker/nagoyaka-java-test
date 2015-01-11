package nagoyaka;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class FizzBuzz {

    public static boolean isFizzBuzz(int number) {
        return (number % 3 == 0 || number % 5 == 0);
    }

    public static String toFizzBuzz(int number) {
        boolean m3 = number % 3 == 0;
        boolean m5 = number % 5 == 0;
        return
            (m3 && m5) ? "fizzbuzz" :
            (m5) ? "buzz" :
            (m3) ? "fizz" :
            String.valueOf(number);
    }

    static Optional<IntStream> inverse(String[] input, int start) {
        int n = start;
        for(String element : input)
        {
            while (!isFizzBuzz(n)) n++;
            if (element != toFizzBuzz(n)) return Optional.empty();
            n++;
        }
        return Optional.of(IntStream.range(start, n));
    }

    public static Optional<int []> inverseFizzBuzz(String[] input) {
        Stream<Optional<IntStream>> list = IntStream.rangeClosed(1, 15)
            .mapToObj(x -> inverse(input, x))
            .filter(x -> x.isPresent());

        //if (!list.iterator().hasNext()) return Optional.empty();

        return list
            //.sorted(x -> x.get().max(Comparator.naturalOrder()).get() - x.get().min(Comparator.naturalOrder()).get())
            .findFirst()
            .flatMap(x -> x)
            .map(x -> x.toArray());
    }
}
