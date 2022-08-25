package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FindClosestElementsUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] arr, int k, int x, List<Integer> expected) {
        var actual = solution.findClosestElements(arr, k, x);
        Assertions.assertIterableEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, 4, 3, Arrays.asList(1, 2, 3, 4)),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, 4, -1, Arrays.asList(1, 2, 3, 4))
        );
    }
}