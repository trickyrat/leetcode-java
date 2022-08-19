package org.trickyrat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PushDominoesUnitTests {
  private final Solution solution = new Solution();

  @ParameterizedTest
  @MethodSource("getDominoes")
  public void test(String input, String expected) {
    String actual = solution.PushDominoes(input);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> getDominoes() {
    return Stream.of(
        arguments("RR.L", "RR.L"),
        arguments(".L.R...LR..L..", "LL.RR.LLRRLL.."));
  }
}
