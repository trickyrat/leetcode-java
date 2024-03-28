package org.trickyrat;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FirstDayBeenInAllRoomsUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] nextVisit, int expected) {
        int actual = solution.firstDayBeenInAllRooms(nextVisit);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{0, 0}, 2),
                Arguments.arguments(new int[]{0, 0, 2}, 6),
                Arguments.arguments(new int[]{0, 1, 2, 0}, 6));
    }
}
