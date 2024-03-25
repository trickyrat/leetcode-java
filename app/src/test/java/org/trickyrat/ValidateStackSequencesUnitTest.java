package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ValidateStackSequencesUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] pushed, int[] popped, boolean expected) {
        boolean actual = solution.validateStackSequences(pushed, popped);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}, true),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}, false)
        );
    }
}