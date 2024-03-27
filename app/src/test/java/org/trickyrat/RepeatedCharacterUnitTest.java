package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RepeatedCharacterUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String s, char expected) {
        var actual = solution.repeatedCharacter(s);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments("abccbaacz", 'c'),
                Arguments.arguments("abcdd", 'd'),
                Arguments.arguments("aa", 'a'),
                Arguments.arguments("zz", 'z')
        );
    }
}