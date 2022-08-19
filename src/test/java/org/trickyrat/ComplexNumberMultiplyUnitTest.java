package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ComplexNumberMultiplyUnitTest {
  private final Solution solution = new Solution();

  @ParameterizedTest
  @MethodSource("getData")
  public void test(String num1, String num2, String expected) {
    String actual = solution.complexNumberMultiply(num1, num2);
    Assertions.assertEquals(expected, actual);
  }

  static Stream<Arguments> getData() {
    return Stream.of(
        Arguments.arguments("1+1i", "1+1i", "0+2i"),
        Arguments.arguments("1+-1i", "1+-1i", "0+-2i"));
  }
}
