package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PartitionUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(ListNode head, int x, ListNode expected) {
        ListNode actual = solution.partition(head, x);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Utilities.createListNode(new int[]{1, 4, 3, 2, 5, 2}), 3, Utilities.createListNode(new int[]{1, 2, 2, 4, 3, 5})),
                Arguments.arguments(Utilities.createListNode(new int[]{2, 1}), 2, Utilities.createListNode(new int[]{1, 2}))
        );
    }
}