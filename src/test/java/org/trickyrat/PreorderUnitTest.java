package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PreorderUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(Node root, List<Integer> expected) {
        var actual = solution.preorder(root);
        Assertions.assertIterableEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        Node root1 = new Node(1, new ArrayList<>());
        Node root1ChildNode3 = new Node(3, new ArrayList<>());
        root1ChildNode3.children.add(new Node(5, new ArrayList<>()));
        root1ChildNode3.children.add(new Node(6, new ArrayList<>()));
        root1.children.add(root1ChildNode3);
        root1.children.add(new Node(2, new ArrayList<>()));
        root1.children.add(new Node(4, new ArrayList<>()));

        Node root2 = new Node(1, new ArrayList<>());

        root2.children.add(new Node(2, new ArrayList<>()));

        Node root2ChildNode3 = new Node(3, new ArrayList<>());
        Node root2ChildNode7 = new Node(7, new ArrayList<>());
        Node root2ChildNode11 = new Node(11, new ArrayList<>());
        root2ChildNode11.children.add(new Node(14, new ArrayList<>()));
        root2ChildNode7.children.add(root2ChildNode11);
        root2ChildNode3.children.add(new Node(6, new ArrayList<>()));
        root2ChildNode3.children.add(root2ChildNode7);

        Node root2ChildNode8 = new Node(8, new ArrayList<>());
        root2ChildNode8.children.add(new Node(12, new ArrayList<>()));

        Node root2ChildNode9 = new Node(9, new ArrayList<>());
        root2ChildNode9.children.add(new Node(13, new ArrayList<>()));

        Node root2ChildNode4 = new Node(4, new ArrayList<>());
        root2ChildNode4.children.add(root2ChildNode8);

        Node root2ChildNode5 = new Node(5, new ArrayList<>());
        root2ChildNode5.children.add(root2ChildNode9);
        root2ChildNode5.children.add(new Node(10, new ArrayList<>()));

        root2.children.add(root2ChildNode3);
        root2.children.add(root2ChildNode4);
        root2.children.add(root2ChildNode5);

        return Stream.of(
                Arguments.arguments(root1, Arrays.asList(1,3,5,6,2,4)),
                Arguments.arguments(root2, Arrays.asList(1,2,3,6,7,11,14,4,8,12,5,9,13,10)));
    }
}
