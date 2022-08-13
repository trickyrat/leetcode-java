package com.trickyrat.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CombinationSumUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] candidates, int target, List<List<Integer>> expected) {
        var actual = solution.combinationSum(candidates, target);
        Assertions.assertIterableEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        List<List<Integer>> expected1 = new ArrayList<>();
        expected1.add(Arrays.asList(7));
        expected1.add(Arrays.asList(2, 2, 3));

        List<List<Integer>> expected2 = new ArrayList<>();
        expected2.add(Arrays.asList(3, 5));
        expected2.add(Arrays.asList(2, 3, 3));
        expected2.add(Arrays.asList(2, 2, 2, 2));

        return Stream.of(
                Arguments.arguments(new int[]{2, 3, 6, 7}, 7, expected1),
                Arguments.arguments(new int[]{2, 3, 5}, 8, expected2),
                Arguments.arguments(new int[]{2}, 1, new ArrayList<>()));
    }
}
