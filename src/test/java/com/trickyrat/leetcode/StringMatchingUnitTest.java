package com.trickyrat.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringMatchingUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String[] words, String[] expected) {
        var actual = solution.stringMatching(words);
        Assertions.assertArrayEquals(expected, actual.toArray());
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new String[]{"mass", "as", "hero", "superhero"}, new String[]{"as", "hero"}),
                Arguments.arguments(new String[]{"leetcode", "et", "code"}, new String[]{"et", "code"}),
                Arguments.arguments(new String[]{"blue", "green", "bu"}, new String[]{})
        );
    }
}
