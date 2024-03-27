package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TotalFruitUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] fruits, int expected) {
        var actual = solution.totalFruit(fruits);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 1}, 3),
                Arguments.arguments(new int[]{0, 1, 2, 2}, 3),
                Arguments.arguments(new int[]{1, 2, 3, 2, 2}, 4)
        );
    }
}