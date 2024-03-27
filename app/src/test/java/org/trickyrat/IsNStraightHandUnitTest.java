package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsNStraightHandUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] hand, int groupSize, boolean expected) {
        boolean actual = solution.isNStraightHand(hand, groupSize);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{1,2,3,6,2,3,4,7,8}, 3, true),
                Arguments.arguments(new int[]{1,2,3,4,5}, 4, false));
    }
}
