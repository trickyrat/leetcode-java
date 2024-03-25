package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.trickyrat.DataStructures.TreeNode;

import java.util.stream.Stream;

public class InsertIntoMaxTreeUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(TreeNode root, int val, TreeNode expected) {
        TreeNode actual = solution.insertIntoMaxTree(root, val);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Util.generateTreeNode("4,1,3,null,null,2"), 5,
                        Util.generateTreeNode("5,4,null,1,3,null,null,2")),
                Arguments.arguments(Util.generateTreeNode("5,2,4,null,1"), 3,
                        Util.generateTreeNode("5,2,4,null,1,null,3")),
                Arguments.arguments(Util.generateTreeNode("5,2,3,null,1"), 4,
                        Util.generateTreeNode("5,2,4,null,1,3"))
        );
    }
}