package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PossibleBipartitionUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int n, int[][] dislikes, boolean expected) {
        var actual = solution.possibleBipartition(n, dislikes);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}, true),
                Arguments.arguments(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}, false),
                Arguments.arguments(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}, false)
        );
    }
}