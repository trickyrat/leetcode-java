package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FindLongestChainUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[][] pairs, int expected) {
        var actual = solution.findLongestChain(pairs);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[][]{
                        {1, 2},
                        {2, 3},
                        {3, 4},
                }, 2),
                Arguments.arguments(new int[][]{
                        {1, 2},
                        {7, 8},
                        {4, 5},
                }, 3)
        );
    }
}