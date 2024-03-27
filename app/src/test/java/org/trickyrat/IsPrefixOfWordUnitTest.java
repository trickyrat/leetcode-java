package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsPrefixOfWordUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String sentence, String searchWord, int expected) {
        int actual = solution.isPrefixOfWord(sentence, searchWord);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments("i love eating burger", "burg", 4),
                Arguments.arguments("this problem is an easy problem", "pro", 2),
                Arguments.arguments("i am tired", "you", -1)
                );
    }
}
