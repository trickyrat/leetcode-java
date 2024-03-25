package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.trickyrat.DataStructures.ListNode;

import java.util.stream.Stream;

public class RemoveNthFromEndUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(ListNode head, int n, String expected) {
        ListNode node = solution.removeNthFromEnd(head, n);
        String actual = Util.convertListNodeToString(node, "->");
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Util.generateListNode(new int[]{1, 2, 3, 4, 5}), 2, "1->2->3->5"),
                Arguments.arguments(Util.generateListNode(new int[]{1}), 1, ""),
                Arguments.arguments(Util.generateListNode(new int[]{1, 2}), 1, "1")
        );
    }
}