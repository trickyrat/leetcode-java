package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class UniqueLetterStringUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String s, int expected) {
        var actual = solution.uniqueLetterString(s);
        Assertions.assertEquals(expected ,actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments("ABC", 10),
                Arguments.arguments("ABA", 8),
                Arguments.arguments("LEETCODE", 92)
        );
    }
}