package com.trickyrat.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MostCommonWordUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String words, String[] banned, String expect) {
        String actual = solution.mostCommonWord(words, banned);
        Assertions.assertEquals(expect, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}, "ball"));
    }
}
