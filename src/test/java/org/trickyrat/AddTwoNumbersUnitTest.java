package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AddTwoNumbersUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(ListNode l1, ListNode l2, String expected) {
        ListNode head = solution.addTwoNumbers(l1, l2);
        String actual = Util.convertListNodeToString(head, "->");
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Util.generateListNode(new int[]{2, 4, 3}), Util.generateListNode(new int[]{5, 6, 4}), "7->0->8"),
                Arguments.arguments(Util.generateListNode(new int[]{0}), Util.generateListNode(new int[]{0}), "0"),
                Arguments.arguments(Util.generateListNode(new int[]{9, 9, 9, 9, 9, 9, 9}), Util.generateListNode(new int[]{9, 9, 9, 9}), "8->9->9->9->0->0->0->1"));
    }
}
