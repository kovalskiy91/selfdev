package kovalskiy91.selfdev.rxjava3;

import java.util.stream.IntStream;

public final class Utils {

    private Utils() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static String[] stringItems(int amount) {
        return IntStream.range(0, 1000)
                .mapToObj(i -> String.format("Item-%d", i))
                .toArray(String[]::new);
    }

}
