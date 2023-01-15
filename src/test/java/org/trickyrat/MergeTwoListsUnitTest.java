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
    public void test(ListNode list1, ListNode list2, ListNode expected) {
        ListNode actual = solution.mergeTwoSortedLists(list1, list2);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Utilities.createListNode(new int[]{1, 2, 4}),
                        Utilities.createListNode(new int[]{1, 3, 4}),
                        Utilities.createListNode(new int[]{1, 1, 2, 3, 4, 4})),
                Arguments.arguments(null, null, null),
                Arguments.arguments(null, Utilities.createListNode(new int[]{0}),
                        Utilities.createListNode(new int[]{0}))
        );
    }
}