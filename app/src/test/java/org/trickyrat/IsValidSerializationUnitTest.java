package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsValidSerializationUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(String preorder, boolean expected) {
        var actual = solution.isValidSerialization(preorder);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments("9,3,4,#,#,1,#,#,2,#,6,#,#", true),
                Arguments.arguments("1,#",  false),
                Arguments.arguments("9,#,#,1",  false));
    }
}
