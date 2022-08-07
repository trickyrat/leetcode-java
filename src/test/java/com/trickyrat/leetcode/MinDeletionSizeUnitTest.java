package com.trickyrat.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinDeletionSizeUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String[] strs, int expected) {
        var actual = solution.minDeletionSize(strs);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new String[]{"cba", "daf", "ghi"}, 1),
                Arguments.arguments(new String[]{"a", "b"}, 0),
                Arguments.arguments(new String[]{"zyx", "wvu", "tsr"}, 3));
    }
}
