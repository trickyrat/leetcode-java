package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CountMaxOrSubsetsUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] input, int expected) {
        int actual = solution.countMaxOrSubsets(input);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 1}, 2),
                Arguments.arguments(new int[]{2, 2, 2}, 7),
                Arguments.arguments(new int[]{3, 2, 1, 5}, 6));
    }
}
