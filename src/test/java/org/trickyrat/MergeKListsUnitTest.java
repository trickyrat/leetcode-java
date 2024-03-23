package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MergeKListsUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(ListNode[] lists, String expected) {
        ListNode head = solution.mergeKLists(lists);
        String actual = Util.convertListNodeToString(head, "->");
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new ListNode[]{
                        Util.generateListNode(new int[]{1, 4, 5}),
                        Util.generateListNode(new int[]{1, 3, 4}),
                        Util.generateListNode(new int[]{2, 6})
                }, "1->1->2->3->4->4->5->6")
        );
    }
}