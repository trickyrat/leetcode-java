package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FinalValueAfterOperationsUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String[] operations, int expected) {
        int actual = solution.finalValueAfterOperations(operations);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new String[]{"--X", "X++", "X++"}, 1),
                Arguments.arguments(new String[]{"++X", "++X", "X++"}, 3),
                Arguments.arguments(new String[]{"X++", "++X", "--X", "X--"}, 0)
        );
    }
}