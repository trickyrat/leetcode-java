package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.trickyrat.DataStructures.TreeNode;

import java.util.stream.Stream;

public class LongestUnivaluePathUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(TreeNode root, int expected) {
        var actual = solution.longestUnivaluePath(root);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Util.generateTreeNode("5,4,5,1,1,null,5"), 2),
                Arguments.arguments(Util.generateTreeNode("1,4,5,4,4,null,5"), 2)
        );
    }
}