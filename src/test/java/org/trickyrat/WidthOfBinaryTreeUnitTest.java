package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WidthOfBinaryTreeUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(TreeNode root, int expected) {
        int actual = solution.widthOfBinaryTree(root);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Util.generateTreeNode("1,3,2,5,3,null,9"), 4),
                Arguments.arguments(Util.generateTreeNode("1,3,2,5,null,null,9,6,null,7"), 7),
                Arguments.arguments(Util.generateTreeNode("1,3,2,5"), 2)
        );
    }
}