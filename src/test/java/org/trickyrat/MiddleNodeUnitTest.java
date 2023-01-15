package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MiddleNodeUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(ListNode head, ListNode expected) {
        ListNode actual = solution.middleNode(head);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Utilities.createListNode(new int[]{1, 2, 3, 4, 5}), Utilities.createListNode(new int[]{3, 4, 5})),
                Arguments.arguments(Utilities.createListNode(new int[]{1, 2, 3, 4, 5, 6}), Utilities.createListNode(new int[]{4, 5, 6}))
        );
    }
}