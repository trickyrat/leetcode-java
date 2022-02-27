package com.trickyrat.leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CountKDifferenceTests {
  private final Solution solution = new Solution();

  @ParameterizedTest
  @MethodSource("getData")
  public void test(int[] nums, int k, int expected) {
    int actual = solution.countKDifference(nums, k);
    Assertions.assertEquals(expected, actual);
  }

  static Stream<Arguments> getData() {
    return Stream.of(
        Arguments.arguments(new int[] { 1, 2, 2, 1 }, 1, 4),
        Arguments.arguments(new int[] { 1, 3 }, 3, 0),
        Arguments.arguments(new int[] { 3, 2, 1, 5, 4 }, 2, 3));
  }
}
