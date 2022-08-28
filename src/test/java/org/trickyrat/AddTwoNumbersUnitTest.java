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
    public void test(ListNode l1, ListNode l2, ListNode expected) {
        ListNode actual = solution.addTwoNumbers(l1, l2);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Utilities.createListNode(new int[]{2, 4, 3}), Utilities.createListNode(new int[]{5, 6, 4}), Utilities.createListNode(new int[]{7, 0, 8})),
                Arguments.arguments(Utilities.createListNode(new int[]{0}), Utilities.createListNode(new int[]{0}), Utilities.createListNode(new int[]{0})),
                Arguments.arguments(Utilities.createListNode(new int[]{9, 9, 9, 9, 9, 9, 9}), Utilities.createListNode(new int[]{9, 9, 9, 9}), Utilities.createListNode(new int[]{8, 9, 9, 9, 0, 0, 0, 1})));
    }
}
