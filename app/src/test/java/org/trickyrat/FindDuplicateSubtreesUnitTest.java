package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.trickyrat.DataStructures.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FindDuplicateSubtreesUnitTest {
    private final Solution solution = new Solution();
    
    @ParameterizedTest
    @MethodSource("getData")
    public void test(TreeNode root, List<TreeNode> expected) {
        var actual = solution.findDuplicateSubtrees(root);

		assertEquals(expected.size(), actual.size());

		for (TreeNode treeNode : actual) {
			Assertions.assertTrue(Util.containsTree(expected, treeNode));
		}
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(
                        Util.generateTreeNode("1,2,3,4,null,2,4,null,null,4"),
                        Arrays.asList(
                                Util.generateTreeNode("4"),
                                Util.generateTreeNode("2,4")
                        )),
                Arguments.arguments(
                        Util.generateTreeNode("2,1,1"),
                        Arrays.asList(Util.generateTreeNode("1"))),
                Arguments.arguments(
                        Util.generateTreeNode("2,2,2,3,null,3,null"),
                        Arrays.asList(
                                Util.generateTreeNode("2,3"),
                                Util.generateTreeNode("3")
                        ))
        );
    }
}