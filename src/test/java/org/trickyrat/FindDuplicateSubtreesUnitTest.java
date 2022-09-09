package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FindDuplicateSubtreesUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(TreeNode root, List<TreeNode> expected) {
        var actual = solution.findDuplicateSubtrees(root);
        Assertions.assertIterableEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(
                        Utilities.createTreeNode("1,2,3,4,null,2,4,null,null,4"),
                        Arrays.asList(
                                Utilities.createTreeNode("2,4"),
                                Utilities.createTreeNode("4")
                        )),
                Arguments.arguments(
                        Utilities.createTreeNode("2,1,1"),
                        Arrays.asList(Utilities.createTreeNode("1"))),
                Arguments.arguments(
                        Utilities.createTreeNode("2,2,2,3,null,3,null"),
                        Arrays.asList(
                                Utilities.createTreeNode("2,3"),
                                Utilities.createTreeNode("3")
                        ))
        );
    }
}