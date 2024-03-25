package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TwoSumUnitTests {
  private final Solution solution = new Solution();

  @ParameterizedTest
  @MethodSource("getData")
  public void test(int[] nums, int target, int[] expected) {
    int[] actual = solution.twoSum(nums, target);
    Assertions.assertArrayEquals(expected, actual);
  }

  static Stream<Arguments> getData() {
    return Stream.of(
        Arguments.arguments(new int[] { 2, 7, 11, 15 }, 9, new int[] { 0, 1 }),
        Arguments.arguments(new int[] { 3, 2, 4 }, 6, new int[] { 1, 2 }),
        Arguments.arguments(new int[] { 3, 3, }, 6, new int[] { 0, 1 }));
  }
}
