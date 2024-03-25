package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CoinChangeIIUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int amount, int[] coins, int expected) {
        int actual = solution.change(amount, coins);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(5, new int[]{1, 2, 5}, 4),
                Arguments.arguments(3, new int[]{2}, 0),
                Arguments.arguments(10, new int[]{10}, 1));
    }
}
