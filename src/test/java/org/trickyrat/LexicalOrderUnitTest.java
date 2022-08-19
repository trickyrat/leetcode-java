package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LexicalOrderUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int n, List<Integer> expected) {
        List<Integer> actual = solution.lexicalOrder(n);
        Assertions.assertIterableEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(13, Arrays.asList(1,10,11,12,13,2,3,4,5,6,7,8,9)),
                Arguments.arguments(2, Arrays.asList(1,2)));
    }
}
