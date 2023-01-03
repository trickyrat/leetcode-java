package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AreNumberAscendingUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String s, boolean expected) {
        var actual = solution.areNumberAscending(s);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments("1 box has 3 blue 4 red 6 green and 12 yellow marbles", true),
                Arguments.arguments("hello world 5 x 5", false),
                Arguments.arguments("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s", false)
        );
    }
}