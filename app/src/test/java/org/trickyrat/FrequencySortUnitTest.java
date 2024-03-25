package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FrequencySortUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] nums, int[] expected) {
        var actual = solution.frequencySort(nums);
        Assertions.assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 1, 2, 2, 2, 3}, new int[]{3, 1, 1, 2, 2, 2}),
                Arguments.arguments(new int[]{2, 3, 1, 3, 2}, new int[]{1, 3, 3, 2, 2}),
                Arguments.arguments(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1}, new int[]{5, -1, 4, 4, -6, -6, 1, 1, 1})
        );
    }
}