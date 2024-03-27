package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FindLUSLengthUnitTest {
  private final Solution solution = new Solution();

  @ParameterizedTest
  @MethodSource("getData")
  public void test(String a, String b, int expected) {
    int actual = solution.findLUTLength(a, b);
    Assertions.assertEquals(expected, actual);
  }

  static Stream<Arguments> getData() {
    return Stream.of(
        Arguments.arguments("aba", "cdc", 3),
        Arguments.arguments("aaa", "bbb", 3),
        Arguments.arguments("aaa", "aaa", -1));
  }
}
