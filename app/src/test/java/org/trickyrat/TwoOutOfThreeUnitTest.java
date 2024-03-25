package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class TwoOutOfThreeUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] nums1, int[] nums2, int[] nums3, List<Integer> expected) {
        var actual = solution.twoOutOfThree(nums1, nums2, nums3);
        actual.sort(Comparator.comparingInt(a -> a));
        expected.sort(Comparator.comparingInt(a -> a));
        Assertions.assertIterableEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{1,1,3,2},new int[]{2,3}, new int[]{3}, Arrays.asList(3, 2))
        );
    }
}