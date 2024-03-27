package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.trickyrat.DataStructures.TreeNode;

import java.util.stream.Stream;

public class ConstructMaximumBinaryTreeUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int[] input, TreeNode expected) {
        TreeNode actual = solution.constructMaximumBinaryTree(input);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{3,2,1,6,0,5}, Util.generateTreeNode("6,3,5,null,2,0,null,null,1")),
                Arguments.arguments(new int[]{3,2,1}, Util.generateTreeNode("3,null,2,null,1")));
    }
}
