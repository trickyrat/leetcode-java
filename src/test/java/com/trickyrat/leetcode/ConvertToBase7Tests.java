package com.trickyrat.leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ConvertToBase7Tests {
  private final Solution solution = new Solution();

  @ParameterizedTest
  @MethodSource("getData")
  public void test(Integer input, String expected) {
    String actual = solution.convertToBase7(input);
    Assertions.assertEquals(expected, actual);
  }

  static Stream<Arguments> getData() {
    return Stream.of(
        Arguments.arguments(100, "202"),
        Arguments.arguments(-7, "-10"));
  }
}
