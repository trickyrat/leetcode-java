package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RemoveNthFromEndUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(ListNode head, int n, ListNode expected) {
        ListNode actual = solution.removeNthFromEnd(head, n);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Utilities.createListNode(new int[]{1, 2, 3, 4, 5}), 2, Utilities.createListNode(new int[]{1, 2, 3, 5})),
                Arguments.arguments(Utilities.createListNode(new int[]{1}), 1, null),
                Arguments.arguments(Utilities.createListNode(new int[]{1, 2}), 1, Utilities.createListNode(new int[]{1}))
        );
    }
}