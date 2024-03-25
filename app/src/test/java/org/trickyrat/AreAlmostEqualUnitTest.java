package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AreAlmostEqualUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String s1, String s2, boolean expected) {
        var actual = solution.areAlmostEqual(s1, s2);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments("bank", "kanb", true),
                Arguments.arguments("attack", "defend", false),
                Arguments.arguments("kelb", "kelb", true)
        );
    }
}