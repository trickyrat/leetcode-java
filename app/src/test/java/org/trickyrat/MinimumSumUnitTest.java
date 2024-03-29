package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinimumSumUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] nums, int expected) {
        int actual = solution.minimumSum(nums);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{8, 6, 1, 5, 3}, 9),
                Arguments.arguments(new int[]{5, 4, 8, 7, 10, 2}, 13),
                Arguments.arguments(new int[]{6, 5, 4, 3, 4, 5}, -1));
    }
}
