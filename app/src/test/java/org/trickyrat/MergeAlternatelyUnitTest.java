package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MergeAlternatelyUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String word1, String word2, String expected) {
        var actual = solution.mergeAlternately(word1, word2);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments("abc", "pqr", "apbqcr"),
                Arguments.arguments("ab", "pqrs", "apbqrs"),
                Arguments.arguments("abcd", "pq", "apbqcd")
        );
    }
}