package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AtMostNGivenDigitSetUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String[] digits, int n, int expected) {
        var actual = solution.atMostNGivenDigitSet(digits, n);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new String[]{"1", "3", "5", "7"}, 100, 20),
                Arguments.arguments(new String[]{"1", "4", "9"}, 1000000000, 29523),
                Arguments.arguments(new String[]{"7"}, 8, 1)
        );
    }
}