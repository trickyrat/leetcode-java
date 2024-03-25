package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinMovesToSeatUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] seats, int[] students, int expected) {
        int actual = solution.minMovesToSeat(seats, students);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 1, 5}, new int[]{2, 7, 4}, 4),
                Arguments.arguments(new int[]{4, 1, 5, 9}, new int[]{1, 3, 2, 6}, 7),
                Arguments.arguments(new int[]{2, 2, 6, 6}, new int[]{1, 3, 2, 6}, 4)
        );
    }
}