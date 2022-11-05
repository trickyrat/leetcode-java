package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class NumComponentsUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(ListNode head, int[] nums, int expected) {
        var actual = solution.numComponents(head, nums);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Utilities.createListNode(new int[]{0, 1, 2, 3}), new int[]{0, 1, 3}, 2),
                Arguments.arguments(Utilities.createListNode(new int[]{0, 1, 2, 3, 4}), new int[]{0, 3, 1, 4}, 2)
        );
    }
}