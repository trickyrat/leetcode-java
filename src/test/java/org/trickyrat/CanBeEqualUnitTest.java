package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CanBeEqualUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] target, int[] arr, boolean expected) {
        var actual = solution.canBeEqual(target, arr);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(Arguments.arguments(new int[]{1, 2, 3, 4}, new int[]{2, 1, 3, 4}, true),
                Arguments.arguments(new int[]{7}, new int[]{7}, true),
                Arguments.arguments(new int[]{3, 7, 9}, new int[]{3, 7, 11}, false)
        );
    }
}