package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class NumSpecialUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[][] mat, int expected) {
        var actual = solution.numSpecial(mat);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}, 1),
                Arguments.arguments(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, 3)
        );
    }
}