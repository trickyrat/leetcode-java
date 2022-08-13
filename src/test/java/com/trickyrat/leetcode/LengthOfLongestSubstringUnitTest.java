package com.trickyrat.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LengthOfLongestSubstringUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String s, int expected) {
        var actual = solution.lengthOfLongestSubstring(s);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments("abcabcbb", 3),
                Arguments.arguments("bbbbb", 1),
                Arguments.arguments("pwwkew", 3));
    }
}
