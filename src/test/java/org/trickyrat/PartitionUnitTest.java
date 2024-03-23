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
    public void test(ListNode head, int x, String expected) {
        ListNode node = solution.partition(head, x);
        String actual = Util.convertListNodeToString(node, "->");
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Util.generateListNode(new int[]{1, 4, 3, 2, 5, 2}), 3, "1->2->2->4->3->5"),
                Arguments.arguments(Util.generateListNode(new int[]{2, 1}), 2, "1->2")
        );
    }
}