package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FinalPricesUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] prices, int[] expected) {
        int[] actual = solution.finalPrices(prices);
        Assertions.assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{8, 4, 6, 2, 3}, new int[]{4, 2, 4, 2, 3}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.arguments(new int[]{10, 1, 1, 6}, new int[]{9, 0, 1, 6})
        );
    }
}