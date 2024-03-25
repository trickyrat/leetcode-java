package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ConstructArrayUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int n, int k, int[] expected) {
        var actual = solution.constructArray(n, k);
        Assertions.assertArrayEquals(expected ,actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(3, 1, new int[]{1,2,3}),
                Arguments.arguments(3, 2, new int[]{1,3,2})
        );
    }
}