package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TrimBSTUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(TreeNode root, int low, int high, TreeNode expected) {
        var actual = solution.trimBST(root, low, high);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(
                        Util.generateTreeNode("1,0,2"),
                        1, 2,
                        Util.generateTreeNode("1,null,2")
                ),
                Arguments.arguments(
                        Util.generateTreeNode("3,0,4,null,2,null,null,1"),
                        1, 3,
                        Util.generateTreeNode("3,2,null,1")
                )
        );
    }
}