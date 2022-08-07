package com.trickyrat.leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PlatesBetweenCandlesUnitTest {
  private final Solution solution = new Solution();

  @ParameterizedTest
  @MethodSource("getData")
  public void test(String input, int[][] queries, int[] expected) {
    int[] actual = solution.platesBetweenCandles(input, queries);
    Assertions.assertArrayEquals(expected, actual);
  }

  static Stream<Arguments> getData() {
    return Stream.of(
        Arguments.arguments("**|**|***|", new int[][] { { 2, 5 }, { 5, 9 } }, new int[] { 2, 3 }),
        Arguments.arguments("***|**|*****|**||**|*",
            new int[][] { { 1, 17 }, { 4, 5 }, { 14, 17 }, { 5, 11 }, { 15, 16 } },
            new int[] { 9, 0, 0, 0, 0 }));
  }
}
