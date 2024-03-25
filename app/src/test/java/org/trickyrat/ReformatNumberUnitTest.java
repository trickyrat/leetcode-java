package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReformatNumberUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String number, String expected) {
        var actual = solution.reformatNumber(number);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments("1-23-45 6", "123-456"),
                Arguments.arguments("123 4-567", "123-45-67"),
                Arguments.arguments("123 4-5678", "123-456-78")
        );
    }
}