package org.trickyrat;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CountWaysUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[][] ranges, int expected) {
        var actual = solution.countWays(ranges);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[][] { new int[] { 6, 10 }, new int[] { 5, 15 } }, 2),
                Arguments.arguments(new int[][] { new int[] { 1, 3 }, new int[] { 10, 20 }, new int[] { 2, 5 },
                        new int[] { 4, 8 } }, 4));
    }
}
