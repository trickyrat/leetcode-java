package org.trickyrat;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MinSetSizeUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] arr, int expected) {
        int actual = solution.minSetSize(arr);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{3,3,3,3,5,5,5,2,2,7}, 2),
                Arguments.arguments(new int[] { 7, 7, 7, 7, 7, 7 }, 1));
    }
}
