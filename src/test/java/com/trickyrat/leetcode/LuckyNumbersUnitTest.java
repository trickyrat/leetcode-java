package com.trickyrat.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LuckyNumbersUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[][] matrix, List<Integer> expected) {
        List<Integer> actual = solution.luckyNumbers(matrix);
        Assertions.assertIterableEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        int[][] grid1 = new int[3][3];
        grid1[0] = new int[]{3, 7, 8};
        grid1[1] = new int[]{9, 11, 13};
        grid1[2] = new int[]{15, 16, 17};

        int[][] grid2 = new int[3][4];
        grid2[0] = new int[]{1, 10, 4, 2};
        grid2[1] = new int[]{9, 3, 8, 7};
        grid2[2] = new int[]{15, 16, 17, 12};

        int[][] grid3 = new int[2][2];
        grid3[0] = new int[]{7, 8};
        grid3[1] = new int[]{1, 2};

        return Stream.of(
                Arguments.arguments(grid1, Arrays.asList(15)),
                Arguments.arguments(grid2, Arrays.asList(12)),
                Arguments.arguments(grid3, Arrays.asList(7)));
    }
}
