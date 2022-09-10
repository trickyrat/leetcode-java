package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

public class MinCostToHireWorkersUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] quality, int[] wage, int k, double expected) {
        var actual = solution.minCostToHireWorkers(quality, wage, k);
        BigDecimal d = new BigDecimal(actual);
        actual = d.setScale(5, RoundingMode.HALF_UP).doubleValue();
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2, 105.00000d),
                Arguments.arguments(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3, 30.66667d)
        );
    }
}