package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinSwapUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] nums1, int[] nums2, int expected) {
        var actual = solution.minSwap(nums1, nums2);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}, 1),
                Arguments.arguments(new int[]{0, 3, 5, 8, 9}, new int[]{2, 1, 4, 6, 9}, 1)
        );
    }
}