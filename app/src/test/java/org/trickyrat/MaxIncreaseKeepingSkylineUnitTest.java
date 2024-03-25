package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MaxIncreaseKeepingSkylineUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[][] grid, int expected) {
        int actual = solution.maxIncreaseKeepingSkyline(grid);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        int[][] grid1 = new int[4][4];
        grid1[0] = new int[]{3, 0, 8, 4};
        grid1[1] = new int[]{2, 4, 5, 7};
        grid1[2] = new int[]{9, 2, 6, 3};
        grid1[3] = new int[]{0, 3, 1, 0};

        int[][] grid2 = new int[3][3];
        grid2[0] = new int[]{0, 0, 0};
        grid2[1] = new int[]{0, 0, 0};
        grid2[2] = new int[]{0, 0, 0};

        return Stream.of(
                Arguments.arguments(grid1, 35),
                Arguments.arguments(grid2, 0));
    }
}
