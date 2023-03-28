package org.trickyrat;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SearchUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] nums, int target, int expected) {
        int actual = solution.search(nums, target);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0, 4),
                Arguments.arguments(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3, -1),
                Arguments.arguments(new int[] { 1 }, 0, -1));
    }
}
