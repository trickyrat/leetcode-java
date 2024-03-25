package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BuildArrayUniTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] target, int n, List<String> expected) {
        var actual = solution.buildArray(target, n);
        Assertions.assertIterableEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 3}, 3, Arrays.asList("Push", "Push", "Pop", "Push")),
                Arguments.arguments(new int[]{1, 2, 3}, 3, Arrays.asList("Push", "Push", "Push")),
                Arguments.arguments(new int[]{1, 2}, 4, Arrays.asList("Push", "Push"))
        );
    }
}