package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinOperations2UnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] nums, int x, int expected) {
        int actual = solution.minOperations(nums, x);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 1, 4, 2, 3}, 5, 2),
                Arguments.arguments(new int[]{5, 6, 7, 8, 9}, 4, -1),
                Arguments.arguments(new int[]{3, 2, 20, 1, 1, 3}, 10, 5)
        );
    }
}