package com.trickyrat.leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ZConvertUnitTest {
  private final Solution solution = new Solution();

  @ParameterizedTest
  @MethodSource("getData")
  public void test(String s, int numRows, String expected) {
    String actual = solution.zconvert(s, numRows);
    Assertions.assertEquals(expected, actual);
  }

  static Stream<Arguments> getData() {
    return Stream.of(
        Arguments.arguments("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
        Arguments.arguments("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
        Arguments.arguments("A", 1, "A"));
  }
}
