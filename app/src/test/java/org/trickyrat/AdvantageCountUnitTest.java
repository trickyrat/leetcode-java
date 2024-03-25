package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AdvantageCountUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] nums1, int[] nums2, int[] expected) {
        var actual = solution.advantageCount(nums1, nums2);
        Assertions.assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11}, new int[]{2, 11, 7, 15}),
                Arguments.arguments(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11}, new int[]{24, 32, 8, 12})
        );
    }
}