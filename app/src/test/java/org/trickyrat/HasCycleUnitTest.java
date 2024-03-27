package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.trickyrat.DataStructures.ListNode;

import java.util.stream.Stream;

public class HasCycleUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(ListNode l1, boolean expected) {
        boolean actual = solution.hasCycle(l1);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        var head1 = new ListNode(3);
        var headNext1 = new ListNode(2, new ListNode(0));
        headNext1.next = new ListNode(-4, headNext1);
        head1.next = headNext1;

        var head2 = new ListNode(1);
        var cycleNode2 = new ListNode(2);
        head2.next = cycleNode2;
        cycleNode2.next = head2;

        var head3 = new ListNode(1);

        return Stream.of(
                Arguments.arguments(head1, true),
                Arguments.arguments(head2, true),
                Arguments.arguments(head3, false));
    }
}
