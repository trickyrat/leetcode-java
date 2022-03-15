package com.trickyrat.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PivotIndexTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] input, int expect) {
        int actual = solution.pivotIndex(input);
        Assertions.assertEquals(expect, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 7, 3, 6, 5, 6}, 3),
                Arguments.arguments(new int[]{1, -1, 4}, 2),
                Arguments.arguments(new int[]{2, 5}, -1));
    }
}
