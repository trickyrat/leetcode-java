package com.trickyrat.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RepeatedNTimesUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] nums, int expected) {
        int actual = solution.repeatedNTimes(nums);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 3}, 3),
                Arguments.arguments(new int[]{2, 1, 2, 5, 3, 2}, 2),
                Arguments.arguments(new int[]{5, 1, 5, 2, 5, 3, 5, 4}, 5));
    }
}
