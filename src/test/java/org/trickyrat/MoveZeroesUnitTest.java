package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MoveZeroesUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] nums, int[] expected) {
        solution.moveZeroes(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
                Arguments.arguments(new int[]{0}, new int[]{0})
        );
    }
}
