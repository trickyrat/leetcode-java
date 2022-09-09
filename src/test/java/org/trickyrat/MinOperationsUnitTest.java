package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinOperationsUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String[] logs, int expected) {
        var actual = solution.minOperations(logs);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new String[]{"d1/", "d2/", "../", "d21/", "./"}, 2),
                Arguments.arguments(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}, 3),
                Arguments.arguments(new String[]{"d1/", "../", "../", "../"}, 0)
        );
    }
}