package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MergeTwoListsUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(ListNode list1, ListNode list2, String expected) {
        ListNode head = solution.mergeTwoSortedLists(list1, list2);
        String actual = Util.convertListNodeToString(head, "->");
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Util.generateListNode(new int[]{1, 2, 4}),
                        Util.generateListNode(new int[]{1, 3, 4}),
                       "1->1->2->3->4->4"),
                Arguments.arguments(null, null, ""),
                Arguments.arguments(null, Util.generateListNode(new int[]{0}),
                        "0")
        );
    }
}