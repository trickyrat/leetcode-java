package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReverseIntUnitTest {
  private final Solution solution = new Solution();

  @ParameterizedTest
  @MethodSource("getData")
  public void test(int input, int expected) {
    int actual = solution.reverseInt(input);
    Assertions.assertEquals(expected, actual);
  }

  static Stream<Arguments> getData() {
    return Stream.of(
        Arguments.arguments(123, 321),
        Arguments.arguments(-123, -321),
        Arguments.arguments(120, 21),
        Arguments.arguments(100, 1),
        Arguments.arguments(0, 0),
        Arguments.arguments(-2147483648, 0),
        Arguments.arguments(2147483647, 0));
  }
}
