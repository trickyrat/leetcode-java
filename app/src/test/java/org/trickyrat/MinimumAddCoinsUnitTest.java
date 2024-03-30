package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinimumAddCoinsUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] coins, int target, int expected) {
        int actual = solution.minimumAddedCoins(coins, target);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 4, 10}, 19, 2),
                Arguments.arguments(new int[]{1, 4, 10, 5, 7, 19}, 19, 1),
                Arguments.arguments(new int[]{1, 1, 1}, 20, 3));
    }
}
