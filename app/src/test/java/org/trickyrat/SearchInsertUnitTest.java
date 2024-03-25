package org.trickyrat;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SearchInsertUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] nums, int target, int expected) {
        int actual = solution.searchInsert(nums, target);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[] { 1, 3, 5, 6 }, 5, 2),
                Arguments.arguments(new int[] { 1, 3, 5, 6 }, 2, 1),
                Arguments.arguments(new int[] { 1, 3, 5, 6 }, 7, 4));
    }
}
